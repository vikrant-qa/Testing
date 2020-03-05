package net.mc.tools.models.change_Password.reponse;

public class Change_Password_Response
{
    private String data;
    private String status;

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
}
