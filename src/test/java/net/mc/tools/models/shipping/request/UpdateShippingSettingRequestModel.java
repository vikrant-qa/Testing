package net.mc.tools.models.shipping.request;

public class UpdateShippingSettingRequestModel {

    private String amount;

    private String[] vendorShipping;

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

    public String[] getVendorShipping ()
    {
        return vendorShipping;
    }

    public void setVendorShipping (String[] vendorShipping)
    {
        this.vendorShipping = vendorShipping;
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
