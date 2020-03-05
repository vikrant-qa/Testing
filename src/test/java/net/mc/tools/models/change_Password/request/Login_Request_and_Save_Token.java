package net.mc.tools.models.change_Password.request;

public class Login_Request_and_Save_Token
{
    private String email;

    private String password;

    public String get_email()
    {
        return email;
    }


    public String get_password()
    {
        return password;
    }

    public void set_email(String email)
    {
        this.email=email;
    }

    public void set_password(String password)
    {
        this.password=password;
    }
}
