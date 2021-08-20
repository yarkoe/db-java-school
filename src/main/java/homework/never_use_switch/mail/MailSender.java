package homework.never_use_switch.mail;

public class MailSender {
    public void send(MailInfo mailInfo) {
        mailInfo.getMailType().getMailSendHandler().send(mailInfo.getOwnerName());
    }
}
