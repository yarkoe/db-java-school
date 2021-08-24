package homework.java8;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Employee {
    private final String name;
    private final int salary;
}
