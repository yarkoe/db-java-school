package my_spring.robot;

import lombok.NoArgsConstructor;
import my_spring.object_factory.annotation.field.InjectByType;
import my_spring.object_factory.annotation.proxy.Benchmark;
import my_spring.object_factory.annotation.proxy.SayHi;

@SayHi
@Benchmark
@NoArgsConstructor
public class IRobot {
    @InjectByType
    private Speaker speaker;
    @InjectByType
    private Cleaner cleaner;

    public void init() {
        System.out.println("INIT");
    }

    public void cleanRoom() {
        speaker.welcome("Привет!");
        speaker.speak("Я начал работать");
        cleaner.clean();
        speaker.speak("Я закончил работать");
        speaker.sayGoodbye("Прощай!");
    }
}
