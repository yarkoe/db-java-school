package homework.java8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

public class EmployeeUtils {
    public static List<String> getEmployeeNamesBySalary(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

    public static Map<String, Employee> listToMap(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.toMap(Employee::getName, identity(),
                        (employee1, employee2) -> employee1.getSalary() > employee2.getSalary() ? employee1 : employee2));
    }

    public static Map<SeniorStatus, Long> getEmployeeNumberGroupedBySeniorStatus(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(e -> SeniorStatus.getBySalary(e.getSalary()), Collectors.counting()));
    }
}
