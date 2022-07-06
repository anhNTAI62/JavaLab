
package BankController;

import java.util.Locale;
import java.util.ResourceBundle;


public class View {

    public static void main(String[] args) {

        EBank m = new EBank();
        String xAccount;
        String xPassword;
        int tried;
        String xCaptcha;
        System.out.println(m.getMsg("notification"));
        int choice = Utility.GetInt("Enter your choice: ", 1, 3);
        switch (choice) {
            case 1:
                m.setLocale(new Locale("vi"));
                break;
            case 2:
                m.setLocale(new Locale("en"));
                break;
            case 3:
                return;
        }
        do {
            xAccount = m.checkAccountNumber(Utility.GetString(m.getMsg("account"), true));
            if (xAccount.equals(m.getMsg("accountError"))) {
                System.out.println(xAccount);
            }

        } while (xAccount.equals(m.getMsg("accountError")));
        do {
            xPassword = m.checkPassword(Utility.GetString(m.getMsg("password"), true));
            if (xPassword.equals(m.getMsg("passwordError"))) {
                System.out.println(xPassword);
            }
        } while (xPassword.equals(m.getMsg("passwordError")));
        tried = 0;
        do {
            if (tried >= 5) {
                System.out.println("Fail to login!");
                return;
            } else {
                String randcaptcha = m.generateCaptcha();
                System.out.println(m.getMsg("captcha") + randcaptcha);
                xCaptcha = m.checkCaptcha(Utility.GetString(m.getMsg("captchaInput"), true), randcaptcha);
                if (xCaptcha.equals(m.getMsg("captchaInputError"))) {
                    System.out.println(xCaptcha);
                } else {
                    System.out.println("Login successfull");
                }
            }
        } while (xCaptcha.equals(m.getMsg("captchaInputError")));

    }
}
