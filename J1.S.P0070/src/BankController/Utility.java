
package BankController;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
    
    public static int GetInt(String msg, int min,int max){
        int i;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print(msg);
            try {
                i=Integer.parseInt(sc.nextLine());
                if(i>=min && i<=max) return i;
                else System.out.println("Out of range");
                
            } catch (Exception e) {
                System.err.println(e);
            }
        }while(true);    
    }
    
    public static String GetString(String msg,boolean isEmpty){
        
        String s;
        Scanner sc = new Scanner(System.in);
        do { 
            System.out.print(msg);
            s = sc.nextLine();
            if(isEmpty == true) return s;
            else{
                if(s.equals("")){
                    System.err.println("String must have atleast 1 character");
                } else return s;
            }
            
        } while (true);
    }
    
    public static boolean matchesPattern(String patt, String inp) {
        Pattern pattern = Pattern.compile(patt, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(inp);
        return matcher.find();
    }
    
}
//public void setLocale(Locale locate){
//        if(locate.getDisplayLanguage().equalsIgnoreCase("Vietnamese")){
//            this.lang = ResourceBundle.getBundle("Language.language", new Locale("vi"));
//        }else if(locate.getDisplayLanguage().equalsIgnoreCase("English")){
//            this.lang = ResourceBundle.getBundle("Language.language", new Locale("Locale.ENGLISH"));
//        }
//    }

//public void setLocale(Locale locate){
//        if(locate.getDisplayLanguage().equalsIgnoreCase("Vietnamese")){
//            this.lang = ResourceBundle.getBundle("Language.language",new Locale("vi"));
//        }else if(locate.getDisplayLanguage().equalsIgnoreCase("English")){
//            this.lang = ResourceBundle.getBundle("Language.language", new Locale("en"));
//        }
//    }