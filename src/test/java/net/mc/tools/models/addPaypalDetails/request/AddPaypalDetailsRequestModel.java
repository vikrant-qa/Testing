package net.mc.tools.models.addPaypalDetails.request;

public class AddPaypalDetailsRequestModel {

    private String clientId;

    private String emailId;

    private String secret;

    private boolean isActive;

    public String getClientId ()
    {
        return clientId;
    }

    public void setClientId (String clientId)
    {
        this.clientId = clientId;
    }

    public String getEmailId ()
    {
        return emailId;
    }

    public void setEmailId (String emailId)
    {
        this.emailId = emailId;
    }

    public String getSecret ()
    {
        return secret;
    }

    public void setSecret (String secret)
    {
        this.secret = secret;
    }

    public boolean getIsActive ()
    {
        return isActive;
    }

    public void setIsActive (boolean isActive)
    {
        this.isActive = isActive;
    }
}
