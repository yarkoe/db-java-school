package my_spring.robot;

import my_spring.object_factory.RandomInteger;

public class CleanerImpl implements Cleaner {
    @RandomInteger(min=1, max=5)
    private int cleanNumber;

    @Override
    public void clean() {
        for (int i = 0; i < cleanNumber; i++) {
            System.out.println("Cleaning");
        }
    }
}
