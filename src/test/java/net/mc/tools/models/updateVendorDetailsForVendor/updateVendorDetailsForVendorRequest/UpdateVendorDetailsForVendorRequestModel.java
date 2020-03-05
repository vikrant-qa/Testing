package net.mc.tools.models.updateVendorDetailsForVendor.updateVendorDetailsForVendorRequest;

public class UpdateVendorDetailsForVendorRequestModel
{
    private String sellerId;
    private String vendorId;
    private String brandName;

    public void setBrandName(String brandName)
    {
        this.brandName = brandName;
    }

    public void setSellerId(String sellerId)
    {
        this.sellerId = sellerId;
    }

    public void setVendorId(String vendorId)
    {
        this.vendorId = vendorId;
    }

    public String getSellerId()
    {
       return sellerId;
    }

    public String getVendorId()
    {
        return vendorId;
    }

    public String getBrandName()
    {
        return brandName;
    }
}
