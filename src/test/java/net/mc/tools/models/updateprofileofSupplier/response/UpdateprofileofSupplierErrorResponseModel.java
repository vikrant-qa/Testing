package net.mc.tools.models.updateprofileofSupplier.response;

public class UpdateprofileofSupplierErrorResponseModel
{
    private String error;

    private String status;

    private String data;
    public String getdata() {
        return data;
    }

    public void setdata(String data) {
        this.data = data;
    }


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
