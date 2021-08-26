package my_spring.robot;

import my_spring.object_factory.annotation.InjectByType;

public class ConsoleSpeakerWithDecoratorImpl extends ConsoleSpeaker {
    @InjectByType
    private ConsoleSpeaker consoleSpeaker;

    @Override
    public void speak(String str) {
        long startTime = System.nanoTime();
        consoleSpeaker.speak(str);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
}
