package real_spring.never_use_switch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import real_spring.never_use_switch.send_handlers.MessageSender;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class MessageDistributor {
    @Autowired
    private Map<MessageChannel, MessageSender> channel2SendHandler;

    public void distribute(Message message) {
        MessageSender messageSender = channel2SendHandler.get(message.getMessageChannel());
        if (messageSender == null) {
            throw new UnsupportedOperationException("There is no any sender for " + message.getMessageChannel() + " channel");
        }

        messageSender.send(message);
    }
}
