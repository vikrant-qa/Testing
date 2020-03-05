package net.mc.tools.models.updateMarkupOfProduct.request;

public class UpdateMarkupRequestModel {

    private String sellerId;

    private AdvancedValues[] advancedValues;

    private String price;

    private String ruleBy;

    private String type;

    public String getSellerId ()
    {
        return sellerId;
    }

    public void setSellerId (String sellerId)
    {
        this.sellerId = sellerId;
    }

    public AdvancedValues[] getAdvancedValues ()
    {
        return advancedValues;
    }

    public void setAdvancedValues (AdvancedValues[] advancedValues)
    {
        this.advancedValues = advancedValues;
    }

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public String getRuleBy ()
    {
        return ruleBy;
    }

    public void setRuleBy (String ruleBy)
    {
        this.ruleBy = ruleBy;
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
