package net.mc.tools.models.updateVendorFieldsForSeller.Request;

public class UpdateVendorFieldsForSellerRequest
{
    private String isShipping;
    private String isBranding;
    private String isPayment;

    public void setIsShipping(String isShipping)
    {
        this.isShipping=isShipping;
    }

    public void setIsBranding(String isBranding)
    {
        this.isBranding=isBranding;
    }
    public void setIsPayment(String isPayment)
    {
        this.isPayment=isPayment;
    }

    public String getIsShipping()
    {
     return isShipping;
    }
    public String getIsBranding()
    {
        return isBranding;
    }

    public String getIsPayment()
    {
        return isPayment;
    }
}
