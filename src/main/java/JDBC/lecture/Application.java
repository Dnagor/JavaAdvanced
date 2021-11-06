package JDBC.lecture;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Application {


    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
       EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionUtils.openConnection());
//       employeeDAO.readAll().stream().forEach(System.out::println);

       List<Employee> employees = new ArrayList<>();
       employees.add(new Employee("One","Two"));
       employees.add(new Employee("Three","Four"));
       employees.add(new Employee("Five","Six"));
       employees.add(new Employee("Seven","Eight"));
       employees.add(new Employee("Nine","Ten"));

//       Insert
       employees.forEach(employee -> employeeDAO.insert(employee));

//       Read
       List<Employee> employeeList = employeeDAO.readAll();
       employeeList.forEach(System.out::println);
       System.out.println();
       Employee employee = employeeDAO.read(31);
       System.out.println(employee);
//       Update
       employee.setLastName(employee.getLastName()+"-Some new Last name");
       employeeDAO.update(employee);
       System.out.println(employee);
//       Delete
       employeeList.forEach(employee1 -> employeeDAO.delete(employee1.getId()));
//       employeeDAO.delete(3);
       System.out.println(employeeDAO.readAll());
    }
}
