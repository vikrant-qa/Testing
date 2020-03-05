package net.mc.tools.models.fetchUserData.FetchUserDataResponse;

public class FetchUserDataErrorResponseModel
{
    private String data;
    private String status;
    private String error;


    public String get_data()
    {
        return data;
    }

    public String get_status()
    {
        return status;
    }

    public void set_data(String Data)
    {
        this.data=Data;
    }
    public void set_status(String Status)
    {
        this.status=Status;
    }

    public String get_error()
    {
        return error;
    }

    public void set_error(String Error)
    {
        this.error=Error;
    }
}
