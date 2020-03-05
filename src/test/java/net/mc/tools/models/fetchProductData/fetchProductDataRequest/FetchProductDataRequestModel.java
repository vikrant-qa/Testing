package net.mc.tools.models.fetchProductData.fetchProductDataRequest;

public class FetchProductDataRequestModel
{
    private String id;
    private String userId;

    public void setId(String id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }
}
