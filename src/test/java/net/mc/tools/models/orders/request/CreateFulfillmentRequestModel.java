package net.mc.tools.models.orders.request;

public class CreateFulfillmentRequestModel {

    private String[] fulfillments;

    private String sellerId;

    private String id;

    private String shopifyOrderId;

    public String[] getFulfillments ()
    {
        return fulfillments;
    }

    public void setFulfillments (String[] fulfillments)
    {
        this.fulfillments = fulfillments;
    }

    public String getSellerId ()
    {
        return sellerId;
    }

    public void setSellerId (String sellerId)
    {
        this.sellerId = sellerId;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
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
}
