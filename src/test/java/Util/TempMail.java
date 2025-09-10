package Util;


import java.util.UUID;

public class TempMail {
    public UUID inboxId;
    public String emailAddress;

    public TempMail(UUID inboxId, String emailAddress) {
        this.inboxId = inboxId;
        this.emailAddress = emailAddress;
    }


}
