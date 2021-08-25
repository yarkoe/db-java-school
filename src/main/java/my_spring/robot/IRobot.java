package my_spring.robot;

public class IRobot {
    private final Speaker speaker = new ConsoleSpeaker();
    private final Cleaner cleaner = new CleanerImpl();

    public void cleanRoom() {
        speaker.speak("Я начал работать");
        cleaner.clean();
        speaker.speak("Я закончил работать");
    }
}
