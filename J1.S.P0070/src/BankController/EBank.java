
package BankController;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;


public class EBank {

    private Locale lc;
    private ResourceBundle lang;

    //read file .properties input (Ngon ngu mac dinh)
    public EBank() {
        lang = ResourceBundle.getBundle("Language.language", new Locale("en"));
//        lang = ResourceBundle.getBundle("Language.language", new Locale("vi"));
    }

    //1:setlocale : change language from file language
    public void setLocale(Locale language) {
        this.lc = new Locale(language + "");
        this.lang = ResourceBundle.getBundle("Language.language", lc);
    }

    //erro -> thong báo
    public String getMsg(String key) {
        return this.lang.getString(key);
    }
    
    //2:length of account
    public String checkAccountNumber(String account) {
        if (Utility.matchesPattern("^[0-9]{10}$", account)) {
            return "";
        } else {
            return getMsg("accountError");
        }
    }
    
    private boolean isValidPassword(String xPassword) {
//        String patt1 = "[0-9a-zA-Z]+";
        String patt2 = "[a-z]+";
        String patt3 = "[A-Z]+";
        String patt4 = "[0-9]+";
//        
        return 
//               Utility.matchesPattern(patt1, xPassword) &&
               Utility.matchesPattern(patt2, xPassword) &&
               Utility.matchesPattern(patt3, xPassword) &&
               Utility.matchesPattern(patt4, xPassword) &&
               xPassword.length() >=8 &&
               xPassword.length()<= 31;
    }

    //3:check pass
    public String checkPassword(String xPassword) {
        if (isValidPassword(xPassword) == true) {
            return "";
        } else {
            return getMsg("passwordError");
        }
    }
    
    private ArrayList<Character> buildListCharacterForCaptcha() {
        ArrayList<Character> accepted_character_forCaptcha = new ArrayList<>();
        for (int i = '0'; i <= '9'; ++i) {
            accepted_character_forCaptcha.add((char) i);
        }
        for (int i = 'a'; i <= 'z'; ++i) {
            accepted_character_forCaptcha.add((char) i);
        }
        for (int i = 'A'; i <= 'Z'; ++i) {
            accepted_character_forCaptcha.add((char) i);
        }
        return accepted_character_forCaptcha;
    }

    //4: Generate a random captcha code (build random)
    public String generateCaptcha() {
        ArrayList<Character> temp = buildListCharacterForCaptcha();
        Random rand = new Random();
        StringBuilder res = new StringBuilder();
        int pos;
        for (int i = 0; i < 5; ++i) {
            pos = rand.nextInt(temp.size());
            res.append(temp.get(pos));
//            temp.remove(pos);
        }
        return res.toString();
    }

    //5: Check Captcha
    public String checkCaptcha(String captchaInput, String captchaGenerate) {
        if (captchaGenerate.contains(captchaInput)&& captchaInput.trim().length()>0) {
            return "";
        } else {
            return getMsg("captchaInputError");
        }
    }
}
