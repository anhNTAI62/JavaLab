
import entity.ID;
import entity.Task;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Main {

    public static void main(String[] args) throws ParseException {
        List<Task> task = new ArrayList<>();

        Main m = new Main();
        DataInput in = new DataInput();
        TaskManagement tm = new TaskManagement(task);
        View v = new View(tm);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        task.add(new Task(1, "Code", "Dev Program", sdf.parse("16/09/2021"), 8, 15, "Dev", "Lead"));
        task.add(new Task(2, "Test", "Test Program", sdf.parse("17/09/2021"), 9, 15.5, "Dev", "Lead"));        
        task.add(new Task(3, "Design", "Design Program", sdf.parse("18/09/2021"), 10.5, 17.5, "Dev", "Lead"));
        boolean isStop = false;
        while (!isStop) {
            m.displayMenu();
            int choice = in.inputChoice(1, 4);
            switch (choice) {
                case 1: {
                    tm.loadId();
                    v.addTask();
                    break;
                }
                case 2: {
                    tm.loadId();
                    v.removeTask();
                    break;
                }
                case 3: {
                    v.displayTask();
                    break;
                }
                case 4: {
                    isStop = true;
                    break;
                }
            }
        }
    }

    private void displayMenu() {
        System.out.println("=======Task program=======");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Display");
        System.out.println("4. Exit");
        System.out.print("Your choice: ");
    }
}
