package net.mc.tools.models.orders.request;

public class ArchiveOrderRequestModel {

    private String sellerId;

    private String vendorId;

    public String getSellerId ()
    {
        return sellerId;
    }

    public void setSellerId (String sellerId)
    {
        this.sellerId = sellerId;
    }

    public String getVendorId ()
    {
        return vendorId;
    }

    public void setVendorId (String vendorId)
    {
        this.vendorId = vendorId;
    }
}
