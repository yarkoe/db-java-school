package real_spring.never_use_switch.send_handlers;

import real_spring.never_use_switch.Message;

public class PhoneMessageSender implements MessageSender {
    @Override
    public void send(Message message) {
        System.out.println("Sent via phone: " + message.getContent());
    }
}
