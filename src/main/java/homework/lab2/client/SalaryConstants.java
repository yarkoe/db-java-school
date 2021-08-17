package homework.lab2.client;

public interface SalaryConstants {
    Salary PROGRAMMER_SALARY = new Salary(100, 10);
    Salary ANIMAL_DOCTOR = new Salary(95, 7);
    Salary PILOT_SALARY = new Salary(80, 13);

    Salary DEFAULT_SALARY = PROGRAMMER_SALARY;
}
