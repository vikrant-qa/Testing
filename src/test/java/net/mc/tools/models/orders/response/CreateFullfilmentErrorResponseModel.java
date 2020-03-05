package net.mc.tools.models.orders.response;

public class CreateFullfilmentErrorResponseModel {

   private String error;

    private String status;

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
