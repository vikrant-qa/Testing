package net.mc.tools.models.manageDiscount.request;

public class ManageDiscountRequestModel {

    private AdvancedValues[] advancedValues;

    private String price;

    private String ruleBy;

    private String type;

    private String userId;

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

    public String getUserId ()
    {
        return userId;
    }

    public void setUserId (String userId)
    {
        this.userId = userId;
    }
}
