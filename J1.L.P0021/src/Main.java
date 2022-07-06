
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Student> list = new ArrayList<>();
        Validate v = new Validate();
        Manager m = new Manager(list);
        View n = new View(m);

        while (true) {
            System.out.println(" 1.	Create");
            System.out.println(" 2.	Find and Sort");
            System.out.println(" 3.	Update/Delete");
            System.out.println(" 4.	Report");
            System.out.println(" 5.	Exit");
            System.out.print("Enter choice:");
            int choice = v.checknum(1, 5);
            switch (choice) {
                case 1:
                    n.createStudent();
                    break;
                case 2:
                    n.findAndSort();
                    break;
                case 3:
                    n.updateOrDelete();
                    break;
                case 4:
                    n.report();
                    break;
                case 5:
                    return;
            }

        }
    }
}
