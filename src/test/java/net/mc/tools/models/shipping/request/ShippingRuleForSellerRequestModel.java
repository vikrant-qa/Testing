package net.mc.tools.models.shipping.request;

public class ShippingRuleForSellerRequestModel {
	
	private String condition;

    private String[] destinationCodes ;

    private String[] productIds;

    private String price;

    private String priceType;

    private String shippingBandId;

    private String description;

    private String isShippingDisabled;

    public String getCondition ()
    {
        return condition;
    }

    public void setCondition (String condition)
    {
        this.condition = condition;
    }

    public String[] getDestinationCodes  ()
    {
        return destinationCodes ;
    }

    public void setDestinationCodes  (String[] destinationCodes )
    {
        this.destinationCodes  = destinationCodes ;
    }

    public String[] getProductIds ()
    {
        return productIds;
    }

    public void setProductIds (String[] productIds)
    {
        this.productIds = productIds;
    }

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public String getPriceType ()
    {
        return priceType;
    }

    public void setPriceType (String priceType)
    {
        this.priceType = priceType;
    }

    public String getShippingBandId ()
    {
        return shippingBandId;
    }

    public void setShippingBandId (String shippingBandId)
    {
        this.shippingBandId = shippingBandId;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getIsShippingDisabled ()
    {
        return isShippingDisabled;
    }

    public void setIsShippingDisabled (String isShippingDisabled)
    {
        this.isShippingDisabled = isShippingDisabled;
    }

}
