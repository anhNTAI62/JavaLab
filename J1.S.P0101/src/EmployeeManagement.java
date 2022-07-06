
import java.util.List;
import entity.Employee;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;


public class EmployeeManagement {

    private List<Employee> employees;
    
    public EmployeeManagement(List<Employee> employee) {
        this.employees = employee;
    }

    public List<Employee> getEmployee() {
        return employees;
    }

    //add Employee
    public void addEmployee(Employee e) {
        employees.add(e);
    }

    //return infor of employee
    public Employee getEmployeeByID(String id) {
        for (Employee e : employees) {
            if (id.equals(e.getId())) {
                return e;
            }
        }
        return null;
    }

    //
    public void updateEmployee(Employee e) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == e.getId()) {
                employees.set(i, e);
                break;
            }
        }
    }

    public void removeEmployee(String id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equalsIgnoreCase(id)) {
                employees.remove(i);
            }
        }
    }

    private String plusString(String firstName, String lastName) {
        String str;
        str = firstName + " " + lastName;
        return str;
    }

    public List<Employee> searchByName(String searchValue) {
        List<Employee> searched = new ArrayList<>();
        for (Employee e : employees) {
            if (plusString(e.getFirstName(), e.getLastName()).toLowerCase().contains(searchValue.toLowerCase())) {
                searched.add(e);
            }
        }
        return searched;
    }

    public void sortBySalary() {
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getSalary() > o2.getSalary()) {
                    return 1;
                } else if (o1.getSalary() < o2.getSalary()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }
}
