package net.mc.tools.models.passwordReset.response;

public class PasswordResetResponseModel {

    private String data;

    private String status;

    public String getData ()
    {
        return data;
    }

    public void setData (String data)
    {
        this.data = data;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }
}
