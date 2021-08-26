package my_spring.robot;

public class ConsoleSpeakerWithDecoratorImpl extends ConsoleSpeaker {
    @Override
    public void speak(String str) {
        long startTime = System.nanoTime();
        super.speak(str);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
}
