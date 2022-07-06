
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Manager {

    ArrayList<Student> list;

    public Manager(ArrayList<Student> list) {
        this.list = list;
    }

    public ArrayList<Student> getList() {
        return list;
    }

    // create new student
    int size() {
        return list.size();
    }

    //find list
    public ArrayList<Student> listStudentFindByName() throws IOException {
        if (list.isEmpty()) {
            System.err.println("List empty.");
        }
        Validate v = new Validate();
        ArrayList<Student> listStudentFindByName = new ArrayList<>();
        System.out.print("Enter name:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine().trim();
        for (Student student : list) {
            //check student have name contains input
            if (student.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                listStudentFindByName.add(student);
            }
        }
        return listStudentFindByName;
    }

    ArrayList<Student> StuDelete(String t) throws IOException {
        Validate v = new Validate();
        // if list empty 
        ArrayList<Student> studentDelete = new ArrayList<Student>();
        for (Student s : list) {
            if (t.equalsIgnoreCase(s.getId())) {
                studentDelete.add(s);
            }
        }
        //check list empty
        if (studentDelete.isEmpty()) {
//            System.err.println("Not found student.");
        } else {
            int idEdit = 0;
            System.out.printf("%-10s%-15s%-15s%-15s\n", "stt", "studentName", "semester", "courseName");
            for (Student student : studentDelete) {
                student.setIdEdit(idEdit++);
                System.out.printf("%-10d%-15s%-15s%-15s\n", student.getIdEdit(),
                        student.getStudentName(), student.getSemester(),
                        student.getCourseName());
            }
        }
        return studentDelete;
    }

    void deleS(String t) throws IOException {
        Validate v = new Validate();
        ArrayList<Student> studentDelete = StuDelete(t);
        int stt = v.checknum(0, studentDelete.size() - 1);
        for (int i = 0; i < studentDelete.size(); i++) {
            if (studentDelete.get(i).getIdEdit() == stt) {
                list.remove(studentDelete.get(i));
                System.err.println("Delete success.");
            }
        }
    }

    ArrayList<Report> subReport() {
        Validate v = new Validate();
        ArrayList<Report> lr = new ArrayList<>();

        for (Student student : list) {
            int total = 0;
            String id = student.getId();
            String courseName = student.getCourseName();
            String studentName = student.getStudentName();
            for (Student studentCountTotal : list) {
                if ( id.equalsIgnoreCase(studentCountTotal.getId()) && studentName.equalsIgnoreCase(studentCountTotal.getStudentName()) && courseName.equalsIgnoreCase(studentCountTotal.getCourseName())) {
                    total++;
                }
            }
            //phai khac nhau vi da gop het roi
            if (v.checkReportExist(lr,id, studentName,
                    courseName, total)) {
                lr.add(new Report(student.getId(),student.getStudentName(), courseName, total));
            }
        }
        return lr;
    }
}
