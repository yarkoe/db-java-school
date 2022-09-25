package my_spring.robot;

import my_spring.object_factory.annotation.proxy.Benchmark;

public class ConsoleSpeaker implements Speaker {
    @Override
    public void speak(String str) {
        System.out.println(str);
    }

    @Benchmark
    @Override
    public void welcome(String welcome) {
        System.out.println(welcome);
    }

    @Benchmark
    @Override
    public void sayGoodbye(String goodbye) {
        System.out.println(goodbye);
    }
}
