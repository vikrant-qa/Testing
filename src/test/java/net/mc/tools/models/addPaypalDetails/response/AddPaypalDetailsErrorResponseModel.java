package net.mc.tools.models.addPaypalDetails.response;

public class AddPaypalDetailsErrorResponseModel {

    private String data;

    private String error;

    private String status;

    public String getData ()
    {
        return data;
    }

    public void setData (String data)
    {
        this.data = data;
    }

    public String getError ()
    {
        return error;
    }

    public void setError (String error)
    {
        this.error = error;
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
