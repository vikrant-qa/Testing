package net.mc.tools.models.shipping.request;

public class UpdateShippingOfferRequestModel {

    private String condition;

    private String[] destinationCode;

    private String productQuantity;

    private String[] productId;

    private String price;

    private String isCumulative;

    private String priceType;

    private String shippingBandId;

    private String description;

    private String _id;

    private String productPrice;

    public String getCondition ()
    {
        return condition;
    }

    public void setCondition (String condition)
    {
        this.condition = condition;
    }

    public String[] getDestinationCode ()
    {
        return destinationCode;
    }

    public void setDestinationCode (String[] destinationCode)
    {
        this.destinationCode = destinationCode;
    }

    public String getProductQuantity ()
    {
        return productQuantity;
    }

    public void setProductQuantity (String productQuantity)
    {
        this.productQuantity = productQuantity;
    }

    public String[] getProductId ()
    {
        return productId;
    }

    public void setProductId (String[] productId)
    {
        this.productId = productId;
    }

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public String getIsCumulative ()
    {
        return isCumulative;
    }

    public void setIsCumulative (String isCumulative)
    {
        this.isCumulative = isCumulative;
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

    public String get_id ()
    {
        return _id;
    }

    public void set_id (String _id)
    {
        this._id = _id;
    }

    public String getProductPrice ()
    {
        return productPrice;
    }

    public void setProductPrice (String productPrice)
    {
        this.productPrice = productPrice;
    }
}
