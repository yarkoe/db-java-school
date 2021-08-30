package real_spring.never_use_switch;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import real_spring.never_use_switch.send_handlers.MessageSender;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.function.Function.*;
import static java.util.stream.Collectors.*;

@Configuration
@ComponentScan(basePackages = "real_spring.never_use_switch")
public class MessageConfig {
    @Bean
    public Map<MessageChannel, MessageSender> senderMap(List<MessageSender> messageSenders) {
        return messageSenders.stream().collect(toMap(MessageSender::getMessageChannel, identity()));
    }

    @Bean
    public Faker dataFaker() {
        return new Faker();
    }
}
