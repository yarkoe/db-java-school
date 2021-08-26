package my_spring.robot;

import lombok.Setter;

public class SpeakerWithTimeDecorator implements Speaker {
    @Setter
    private Speaker speaker = new ConsoleSpeaker();

    @Override
    public void speak(String str) {
        long startTime = System.nanoTime();
        speaker.speak(str);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
}
