package real_spring.never_use_switch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import real_spring.never_use_switch.send_handlers.MessageSender;
import real_spring.never_use_switch.send_handlers.PhoneMessageSender;
import real_spring.never_use_switch.send_handlers.SMSMessageSender;

import java.util.EnumMap;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = "real_spring.never_use_switch")
public class MessageConfig {
    @Bean
    public Map<MessageChannel, MessageSender> messageChannel2MessageSender() {
        Map<MessageChannel, MessageSender> channel2Sender = new EnumMap<>(MessageChannel.class);

        channel2Sender.put(MessageChannel.SMS, new SMSMessageSender());
        channel2Sender.put(MessageChannel.PHONE, new PhoneMessageSender());

        return channel2Sender;
    }
}
