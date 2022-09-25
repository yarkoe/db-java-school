package real_spring.never_use_switch.send_handlers;

import org.springframework.stereotype.Component;
import real_spring.never_use_switch.Message;
import real_spring.never_use_switch.MessageChannel;

@Component
public class SMSMessageSender implements MessageSender {
    @Override
    public void send(Message message) {
        System.out.println("Sent via SMS: " + message.getContent());
    }

    @Override
    public MessageChannel getMessageChannel() {
        return MessageChannel.SMS;
    }
}
