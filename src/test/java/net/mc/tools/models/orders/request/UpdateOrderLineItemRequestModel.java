package net.mc.tools.models.orders.request;

public class UpdateOrderLineItemRequestModel {

    private String lineItemId;

    private String orderId;

    private String trackingCompany;

    private String trackingNumber;

    private String dueDays;

    public String getLineItemId ()
    {
        return lineItemId;
    }

    public void setLineItemId (String lineItemId)
    {
        this.lineItemId = lineItemId;
    }

    public String getOrderId ()
    {
        return orderId;
    }

    public void setOrderId (String orderId)
    {
        this.orderId = orderId;
    }

    public String getTrackingCompany ()
    {
        return trackingCompany;
    }

    public void setTrackingCompany (String trackingCompany)
    {
        this.trackingCompany = trackingCompany;
    }

    public String getTrackingNumber ()
    {
        return trackingNumber;
    }

    public void setTrackingNumber (String trackingNumber)
    {
        this.trackingNumber = trackingNumber;
    }

    public String getDueDays ()
    {
        return dueDays;
    }

    public void setDueDays (String dueDays)
    {
        this.dueDays = dueDays;
    }
}
