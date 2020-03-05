package net.mc.tools.models.orders.request;

public class UpdateOrderRequestModel {

    private String note;

    private String sellerId;

    private String[] id;

    private String shopifyOrderId;

    private String[] shipping_address;

    private String email;

    public String getNote ()
    {
        return note;
    }

    public void setNote (String note)
    {
        this.note = note;
    }

    public String getSellerId ()
    {
        return sellerId;
    }

    public void setSellerId (String sellerId)
    {
        this.sellerId = sellerId;
    }

    public String[] getId ()
    {
        return id;
    }

    public void setId (String[] id)
    {
        this.id = id;
    }

    public String getShopifyOrderId ()
    {
        return shopifyOrderId;
    }

    public void setShopifyOrderId (String shopifyOrderId)
    {
        this.shopifyOrderId = shopifyOrderId;
    }

    public String[] getShipping_address ()
    {
        return shipping_address;
    }

    public void setShipping_address (String[] shipping_address)
    {
        this.shipping_address = shipping_address;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }
}
