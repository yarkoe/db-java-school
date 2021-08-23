package homework.never_use_switch.mail;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class MailInfo {
    @NonNull
    private final String ownerName;
    @NonNull
    private MailType mailType;

    MailInfo(@NonNull String ownerName, @NonNull MailType mailType) {
        this.ownerName = ownerName;
        this.mailType = mailType;
    }

    public static MailInfoBuilder builder() {
        return new MailInfoBuilder();
    }

    public static class MailInfoBuilder {
        private String ownerName;
        private MailType mailType;

        MailInfoBuilder() {
        }

        public MailInfoBuilder ownerName(@NonNull String ownerName) {
            this.ownerName = ownerName;
            return this;
        }

        public MailInfoBuilder mailType(int mailTypeCode) {

            this.mailType = MailType.findByMailTypeCode(mailTypeCode);
            return this;
        }

        public MailInfo build() {
            return new MailInfo(ownerName, mailType);
        }

        public String toString() {
            return "MailInfo.MailInfoBuilder(ownerName=" + this.ownerName + ", mailType=" + this.mailType + ")";
        }
    }
}
