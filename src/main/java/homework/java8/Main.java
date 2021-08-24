package homework.java8;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Vasya", 10),
                new Employee("Vika", 15),
                new Employee("Kika", 20),
                new Employee("Vasya", 25));
        List<String> employeeNamesBySalary = EmployeeUtils.getEmployeeNamesBySalary(employees);
        System.out.println("employeeNamesBySalary = " + employeeNamesBySalary);

        System.out.println();

        Map<String, Employee> mapEmployees = EmployeeUtils.listToMap(employees);
        System.out.println("mapEmployees = " + mapEmployees);
    }
}
