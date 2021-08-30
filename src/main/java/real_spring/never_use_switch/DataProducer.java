package real_spring.never_use_switch;

import com.github.javafaker.Faker;
import homework.lab3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataProducer {
    @Autowired
    private Faker faker;

    public  Message generateMessage() {
        return Message.builder()
                .messageChannel(RandomUtils.getRandomElement(Arrays.asList(MessageChannel.values())))
                .content(faker.witcher().quote())
                .build();
    }

}
