package net.mc.tools.models.orders.response;

public class Orders
{

    private String createdAt;

    private String shop;

    private String sellerId;

    private String totalPrice;

    private String moneyFormat;

    private String _id;

    private String shopifyOrderId;

    private String fulfillmentStatus;

    private String status;

    private String updatedAt;

    public String getCreatedAt ()
    {
        return createdAt;
    }

    public void setCreatedAt (String createdAt)
    {
        this.createdAt = createdAt;
    }

    public String getShop ()
    {
        return shop;
    }

    public void setShop (String shop)
    {
        this.shop = shop;
    }

    public String getSellerId ()
    {
        return sellerId;
    }

    public void setSellerId (String sellerId)
    {
        this.sellerId = sellerId;
    }

    public String getTotalPrice ()
    {
        return totalPrice;
    }

    public void setTotalPrice (String totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public String getMoneyFormat ()
    {
        return moneyFormat;
    }

    public void setMoneyFormat (String moneyFormat)
    {
        this.moneyFormat = moneyFormat;
    }

    public String get_id ()
    {
        return _id;
    }

    public void set_id (String _id)
    {
        this._id = _id;
    }

    public String getShopifyOrderId ()
    {
        return shopifyOrderId;
    }

    public void setShopifyOrderId (String shopifyOrderId)
    {
        this.shopifyOrderId = shopifyOrderId;
    }

    public String getFulfillmentStatus ()
    {
        return fulfillmentStatus;
    }

    public void setFulfillmentStatus (String fulfillmentStatus)
    {
        this.fulfillmentStatus = fulfillmentStatus;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public String getUpdatedAt ()
    {
        return updatedAt;
    }

    public void setUpdatedAt (String updatedAt)
    {
        this.updatedAt = updatedAt;
    }
}
