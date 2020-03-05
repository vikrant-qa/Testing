package net.mc.tools.models.countListOfProducts.countListOfProductsResponse;

public class CountListOfProductsResponseModel
{
    private int data;
    private String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public int getData() {
        return data;
    }
}
