package net.mc.tools.models.updateUserSetting.response;

public class Password {

    private String bcrypt;

    public String getBcrypt ()
    {
        return bcrypt;
    }

    public void setBcrypt (String bcrypt)
    {
        this.bcrypt = bcrypt;
    }
}
