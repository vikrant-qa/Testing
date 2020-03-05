package net.mc.tools.models.shipping.request;

public class ManageShippingDetailsRequestModel {

    private String amount;

    private String isAllowAllVendor;

    private String[] vendorIds;

    private String term;

    private String type;

    public String getAmount ()
    {
        return amount;
    }

    public void setAmount (String amount)
    {
        this.amount = amount;
    }

    public String getIsAllowAllVendor ()
    {
        return isAllowAllVendor;
    }

    public void setIsAllowAllVendor (String isAllowAllVendor)
    {
        this.isAllowAllVendor = isAllowAllVendor;
    }

    public String[] getVendorIds ()
    {
        return vendorIds;
    }

    public void setVendorIds (String[] vendorIds)
    {
        this.vendorIds = vendorIds;
    }

    public String getTerm ()
    {
        return term;
    }

    public void setTerm (String term)
    {
        this.term = term;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }
}
