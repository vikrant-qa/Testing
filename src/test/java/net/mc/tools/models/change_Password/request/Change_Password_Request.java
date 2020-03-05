package net.mc.tools.models.change_Password.request;

public class Change_Password_Request
{
 private String newPassword;
 private String password;
 private String token;
    public String get_newPassword()
    {
        return newPassword;
    }
    public String get_password()
    {
        return password;
    }
    public void set_newPassword(String newPassword)

    {
        this.newPassword=newPassword;
    }
    public void set_password(String password)

    {
        this.password=password;
    }

    public String get_token()
    {
        return token;
    }
    public void set_token(String token)

    {
        this.token=token;
    }
}
