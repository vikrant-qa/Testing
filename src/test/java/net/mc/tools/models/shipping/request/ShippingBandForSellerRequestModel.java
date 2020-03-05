package net.mc.tools.models.shipping.request;

public class ShippingBandForSellerRequestModel {

    private String price;

    private String isUpdateAllowed;

    private String name;

    private String priceType;

    private String description;

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public String getIsUpdateAllowed ()
    {
        return isUpdateAllowed;
    }

    public void setIsUpdateAllowed (String isUpdateAllowed)
    {
        this.isUpdateAllowed = isUpdateAllowed;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getPriceType ()
    {
        return priceType;
    }

    public void setPriceType (String priceType)
    {
        this.priceType = priceType;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }
}
