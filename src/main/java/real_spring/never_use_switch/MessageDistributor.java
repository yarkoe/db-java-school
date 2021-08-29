package real_spring.never_use_switch;

import org.springframework.stereotype.Component;
import real_spring.never_use_switch.send_handlers.MessageSender;

import javax.annotation.Resource;
import java.util.Map;

@Component
public class MessageDistributor {
    @Resource(name="messageChannel2MessageSender")
    private Map<MessageChannel, MessageSender> channel2SendHandler;

    public void distribute(Message message) {
        MessageSender messageSender = channel2SendHandler.get(message.getMessageChannel());
        if (messageSender == null) {
            throw new UnsupportedOperationException("There is no any sender for " + message.getMessageChannel() + " channel");
        }

        messageSender.send(message);
    }
}
