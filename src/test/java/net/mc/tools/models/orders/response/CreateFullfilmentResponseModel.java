package net.mc.tools.models.orders.response;

public class CreateFullfilmentResponseModel {

    private boolean data;

    private String status;

    public boolean getData ()
    {
        return data;
    }

    public void setData (boolean data)
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
