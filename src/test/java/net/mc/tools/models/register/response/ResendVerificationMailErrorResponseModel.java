package net.mc.tools.models.register.response;

public class ResendVerificationMailErrorResponseModel
{
    private String data;
    private String error;
    private String status;

    public String get_data()
    {
        return data;
    }
    public String get_error()
    {
        return error;
    }

    public String get_status()
    {
        return status;
    }

    public void set_data(String Data)
    {
        this.data=Data;
    }
    public void set_error(String error)
    {
        this.error=error;
    }
    public void set_status(String Status)
    {
        this.status=Status;
    }
}
