
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import jdk.nashorn.internal.ir.BreakNode;

public class View {

    Manager Mn;

    public View(Manager Mn) {
        this.Mn = Mn;
    }

    Validate v = new Validate();

    Relationship r = new Relationship();

    public void createStudent() throws IOException {
        //check size > 10
//        Relationship r = new Relationship();
// nhac nho qua nhieu
        if (Mn.size() > 10) {
            String choice = v.checkString("Do you want to continue (Y/N): ");
            if (!choice.equals("Y")) {
                return;
            }
        }
        //add
        while (true) {
            String id = v.checkString("Enter id: ");
            if (v.checkIdExist(Mn.getList(), id) == true) {
                String name = r.checkNameExit(Mn.getList(), id);
                System.out.println("Name Student : " + name);
                //nhap ky and khoa
                String semester = v.chekIntSemester("Enter semester: ");
                String course = v.checkInputCourse("Enter name course: ");

                //check exit of ky and khoa vi cai nay cung 1 nguoi
                if (r.checkCourseExit(Mn.getList(), course, semester, id, name)) {
                    System.err.println("Course is Exit ,Please Enter aligan");
                    continue;
                }
                Mn.getList().add(new Student(id, name, semester, course));
                System.out.println("Add student success.");
                return;
// id not exist:
            } else {
                String name = v.checkString("Enter name student: ");

                String semester = v.chekIntSemester("Enter semester: ");
                String course = v.checkInputCourse("Enter name course: ");
                Mn.getList().add(new Student(id, name, semester, course));
                System.out.println("Add student success.");
                return;

            }
        }
    }

    public void findAndSort() throws IOException {
        //check list empty 

        ArrayList<Student> listStudentFindByName = Mn.listStudentFindByName();

        Collections.sort(listStudentFindByName);
        System.out.printf("%-15s%-15s%-15s\n", "Student name", "semester", "Course Name");
        for (Student student : listStudentFindByName) {
            student.print();

        }
    }

    public void updateOrDelete() throws IOException {

        // check list exist
        if (Mn.list.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        String id = v.checkString("Enter id: ");

        ArrayList<Student> studentDelete = Mn.StuDelete(id);
        //check ID exist
        if (studentDelete.isEmpty()) {
            return;
        }
        System.out.print("Do you want to update (U) or delete (D) student: ");

        if (v.checkInputUD()) {
            //input value

            String idStudent = "";
            ArrayList<Student> ar = new ArrayList<>();
            ar.addAll(Mn.list);

            //check exist 
            if (ar.size() > 1) {
                for (int i = 0; i < ar.size(); i++) {
                    if (id.equalsIgnoreCase(ar.get(i).getId())) {
                        ar.remove(i);
                        i--;
                    }
                }
                for (int i = 0; i < ar.size(); i++) {
                    String k = v.checkString("Enter id: ");
                    if (!k.equalsIgnoreCase(ar.get(i).getId())) {
                        idStudent = k;
                        break;
                    } else {
                        System.out.println("ID exist");
                        return;
                    }
                }
            } else {
                idStudent = v.checkString("Enter id: ");
            }

            String name = v.checkString("Enter name student: ");
            int max = studentDelete.size();

            System.out.print("Enter numerical order:");
            //chọn gtri u and xóa
            int stt = v.checknum(0, max - 1);

            String semester = "";
            String course = "";

            //check course
            while (true) {
                semester = v.chekIntSemester("Enter semester: ");
                course = v.checkInputCourse("Enter name course: ");
                //check xem ton tai hay chua
                if (r.checkCourseExit(Mn.list, course, semester, id, studentDelete.get(0).getStudentName())) {
                    System.err.println("Course is Exit ,Please Enter aligan");
                    continue;
                } else {
                    break;
                }
            }
            for (Student student : studentDelete) {
                student.setId(idStudent);
                student.setStudentName(name);
                if (student.getIdEdit() == stt) {
                    student.setSemester(semester);
                    student.setCourseName(course);
                }
            }
            return;
        } else {
            System.out.println("Enter numerical order:");
            Mn.deleS(id);
        }
            System.err.println("Update success.");
    }

    public void report() {
        if (Mn.list.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        ArrayList<Report> lr = Mn.subReport();
        //print report
        for (int i = 0; i < lr.size(); i++) {
            System.out.printf("%-5s|%s|%d\n", lr.get(i).getStudentName(),
                    lr.get(i).getCourseName(), lr.get(i).getTotalCourse());
        }
    }

}
