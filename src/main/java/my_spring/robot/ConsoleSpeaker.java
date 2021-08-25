package my_spring.robot;

public class ConsoleSpeaker implements Speaker {
    @Override
    public void speak(String str) {
        System.out.println(str);
    }
}
