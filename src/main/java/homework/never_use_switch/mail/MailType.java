package homework.never_use_switch.mail;

import homework.never_use_switch.mail.handlers.HappyBirthdayMailSendHandler;
import homework.never_use_switch.mail.handlers.MailSendHandler;
import homework.never_use_switch.mail.handlers.WelcomeMailSendHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MailType {
    WELCOME(1, new WelcomeMailSendHandler()),
    HAPPY_BIRTHDAY(2, new HappyBirthdayMailSendHandler());

    private final int mailTypeCode;
    private final MailSendHandler mailSendHandler;

    public MailSendHandler getMailSendHandler() {
        return mailSendHandler;
    }

    public static MailType findByMailTypeCode(int mailTypeCode) {
        for (MailType mailType : values()) {
            if (mailType.mailTypeCode == mailTypeCode) {
                return mailType;
            }
        }

        throw new IllegalArgumentException("There is no such mail type code");
    }
}
