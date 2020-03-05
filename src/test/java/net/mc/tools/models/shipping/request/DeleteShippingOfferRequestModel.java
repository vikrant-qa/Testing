package net.mc.tools.models.shipping.request;

public class DeleteShippingOfferRequestModel {

    private String shippingOfferId;

    public String getShippingBandId ()
    {
        return shippingOfferId;
    }

    public void setShippingBandId (String shippingOfferId)
    {
        this.shippingOfferId = shippingOfferId;
    }
}
