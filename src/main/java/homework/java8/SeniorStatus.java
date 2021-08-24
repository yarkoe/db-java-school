package homework.java8;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public enum SeniorStatus {
    JUNIOR(0, 9), MIDDLE(10, 19), SENIOR(20, Integer.MAX_VALUE);

    private final int minSalary;
    private final int maxSalary;

    public static SeniorStatus getBySalary(int salary) {
        return Arrays.stream(values())
                .filter(seniorStatus -> seniorStatus.minSalary <= salary && seniorStatus.maxSalary >= salary)
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
