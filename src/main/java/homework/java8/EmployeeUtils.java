package homework.java8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeUtils {
    public static List<String> getEmployeeNamesBySalary(List<Employee> employees) {
        return employees.stream()
                .sorted((employee1, employee2) -> Integer.compare(employee2.getSalary(), employee1.getSalary()))
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

    public static Map<String, Employee> listToMap(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.toMap(Employee::getName, employee -> employee,
                        (employee1, employee2) -> employee1.getSalary() > employee2.getSalary() ? employee1 : employee2));
    }
}
