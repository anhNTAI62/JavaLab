
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Mr D
 */
public class Validate {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public int checknum(int min, int max) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String raw = scanner.nextLine().trim();
            if (!raw.isEmpty()) {
                try {
                    int choice = Integer.parseInt(raw);
                    if (choice >= min && choice <= max) {
                        return choice;
                    } else {
                        System.out.print("Choice must in range [" + min + "-"
                                + max + "], enter again: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Choice must be an integer, enter again: ");
                }
            } else {
                System.out.print("Choice can not empty, enter again: ");
            }
        }
    }
    

    public String checkString(String mess) throws IOException {
        String out = "";
        try {
            do {
                System.out.println(mess);
                out = in.readLine();
                if (out.trim().isEmpty()) {
                    System.out.println("Please Enter String");
                } else {
                    break;
                }
            } while (true);
        } catch (Exception e) {
        }

        return out;
    }

    //check id  exist
    public boolean checkIdExist(ArrayList<Student> list, String id) {
        for (Student s : list) {
            if (id.equalsIgnoreCase(s.getId())) {

                return true;
            }
        }
        return false;
    }

    public String chekIntSemester(String mess) {
        String regex = "[0-9]*";
        String out = "";
        try {
            do {
                System.out.println(mess);
                out = in.readLine();
                if (out.isEmpty()) {
                    System.out.println("Please Enter String");
                } else {
                    if (out.matches(regex) && out.equals("0")==false) {
                        break;
                    } else {
                        System.out.println("Please Enter semester is digit");
                    }
                }
            } while (true);
        } catch (Exception e) {
        }
        return out.trim();
    }

    //check user input course
    public String checkInputCourse(String mess) throws IOException {
        //loop until user input correct
        while (true) {
            String result = checkString(mess);
            //check input course in java/ .net/ c/c++
            if (result.equalsIgnoreCase("java")
                    || result.equalsIgnoreCase(".net")
                    || result.equalsIgnoreCase("c/c++")) {
                return result;
            }
            System.err.println("There are only three courses: Java, .Net, C/C++");
            System.out.print("Enter again: ");
        }
    }

    //check user input u / d
    public boolean checkInputUD() throws IOException {
        //loop until user input correct
        while (true) {
            String result = checkString("");
            //return true if user input u/U
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            //return false if user input d/D
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.println("Please input u/U or d/D.");
            System.out.print("Enter again: ");
        }

    }

    //check report exist
    //
    public boolean checkReportExist(ArrayList<Report> lr,String id, String name,
            String course, int total) {
        for (Report report : lr) {
            //ten va khoa hoc khac nhau vi report gop het rui
            if ( id.equalsIgnoreCase(report.getId()) && name.equalsIgnoreCase( report.getStudentName()) && course.equalsIgnoreCase(report.getCourseName())) {
                return false;
            }
        }
        return true;
    }

}
