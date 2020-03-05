package net.mc.tools.models.bulkInvite.request;


import java.util.Arrays;

public class BulkInviteByDataRequestModel {

   private String[] emails;

    private Message message;

    private SentBy sentBy;

    private MessageData messageData;

    public String[] getEmails ()
    {
        return emails;
    }

    public void setEmails (String[] emails)
    {
        this.emails = emails;
    }

    public Message getMessage ()
    {
        return message;
    }

    public void setMessage (Message message)
    {
        this.message = message;
    }

    public SentBy getSentBy ()
    {
        return sentBy;
    }

    public void setSentBy (SentBy sentBy)
    {
        this.sentBy = sentBy;
    }

    public MessageData getMessageData ()
    {
        return messageData;
    }

    public void setMessageData (MessageData messageData)
    {
        this.messageData = messageData;
    }
}
