package real_spring.never_use_switch.send_handlers;

import real_spring.never_use_switch.Message;
import real_spring.never_use_switch.MessageChannel;

import java.awt.*;

public interface MessageSender {
    void send(Message message);
    MessageChannel getMessageChannel();
}
