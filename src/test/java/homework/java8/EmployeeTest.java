package homework.java8;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    @Test
    void testEmployeesSumSalary() {
        List<Employee> employees = List.of(new Employee("Vasya", 10), new Employee("Valera", 20), new Employee("Vika", 25));
        int salarySum = employees.stream()
                .mapToInt(Employee::getSalary)
                .sum();

        assertEquals(55, salarySum);
    }

}