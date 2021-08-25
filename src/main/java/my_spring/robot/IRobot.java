package my_spring.robot;

import lombok.NoArgsConstructor;
import my_spring.object_factory.annotation.Inject;

@NoArgsConstructor
public class IRobot {
    @Inject
    private Speaker speaker;
    @Inject
    private Cleaner cleaner;

    public void cleanRoom() {
        speaker.speak("Я начал работать");
        cleaner.clean();
        speaker.speak("Я закончил работать");
    }
}
