package homework.never_use_switch.mail.handlers;

public class HappyBirthdayMailSendHandler implements MailSendHandler {
    @Override
    public void send(String ownerName) {
        System.out.println("Happy Birthday mail was sent by " + ownerName);
    }
}
