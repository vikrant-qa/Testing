package net.mc.tools.models.sendEmailModel.request;

public class SendEmailRequestModel
{
    private String message;
    private String subject;
    private String email;

    public String getmessage() {
        return message;
    }

    public void setmessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getsubject() {
        return subject;
    }

    public void setsubject(String subject) {
        this.subject = subject;
    }
}
