package net.mc.tools.models.registerSupplier.response;

public class RegisterSupplierErrorResponseModel {

    private String error;

    private String status;

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
