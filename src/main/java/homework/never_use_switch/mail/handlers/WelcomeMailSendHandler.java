package homework.never_use_switch.mail.handlers;

public class WelcomeMailSendHandler implements MailSendHandler {
    @Override
    public void send(String ownerName) {
        System.out.println("Welcome mail was sent by " + ownerName);
    }
}
