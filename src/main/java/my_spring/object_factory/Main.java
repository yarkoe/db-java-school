package my_spring.object_factory;

import my_spring.robot.Cleaner;
import my_spring.robot.CleanerImpl;
import my_spring.robot.Speaker;

public class Main {

    public static void main(String[] args) {
        ObjectFactory objectFactory = ObjectFactory.getInstance();

        Speaker speaker = objectFactory.createObject(Speaker.class);
        speaker.speak("Hello");
    }
}
