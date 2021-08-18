package homework.lab2.client;

import lombok.Data;

@Data
public class Salary {
    private int salary;
    private int bonus;

    public Salary(int salary, int bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }
}
