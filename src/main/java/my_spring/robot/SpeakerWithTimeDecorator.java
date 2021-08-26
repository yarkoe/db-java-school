package my_spring.robot;

import lombok.Setter;
import my_spring.object_factory.ObjectFactory;

public class SpeakerWithTimeDecorator implements Speaker {
    @Setter
    private Speaker speaker = ObjectFactory.getInstance().createObject(ConsoleSpeaker.class);

    @Override
    public void speak(String str) {
        long startTime = System.nanoTime();
        speaker.speak(str);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
}
