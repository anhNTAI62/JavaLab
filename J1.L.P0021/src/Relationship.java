
import java.util.ArrayList;

public class Relationship {

    //th neu cai id trung -> cung 1 ten
    public String checkNameExit(ArrayList<Student> list, String id) {
        for (Student student : list) {
            if (student.getId().equals(id)) {
                return student.getStudentName();
            }
        }

        return "";
    }

    //check xem exist ko , neu cung 1 nguoi thi ko dk
    public boolean checkCourseExit(ArrayList<Student> list, String course, String semester,
            String id, String name) {
        for (Student student : list) {
            if (student.getSemester().equals(semester)
                    && student.getCourseName().equals(course)
                    && student.getId().equals(id)
                    && student.getStudentName().equals(name)) {
                return true;
            }
        }
        return false;
    }

}
