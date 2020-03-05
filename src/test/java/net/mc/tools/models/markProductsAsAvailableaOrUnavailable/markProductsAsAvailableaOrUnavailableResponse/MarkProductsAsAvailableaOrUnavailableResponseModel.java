package net.mc.tools.models.markProductsAsAvailableaOrUnavailable.markProductsAsAvailableaOrUnavailableResponse;

public class MarkProductsAsAvailableaOrUnavailableResponseModel
{
    private Boolean data;
    private String status;

    public void setData(Boolean data) {
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public Boolean getData() {
        return data;
    }
}
