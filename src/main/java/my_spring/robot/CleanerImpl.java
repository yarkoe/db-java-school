package my_spring.robot;

import my_spring.object_factory.annotation.proxy.Benchmark;
import my_spring.object_factory.annotation.field.RandomInteger;

@Benchmark
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
