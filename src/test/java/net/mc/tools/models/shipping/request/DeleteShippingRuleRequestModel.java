package net.mc.tools.models.shipping.request;

public class DeleteShippingRuleRequestModel {

    private String shippingRuleId;

    public String getShippingBandId ()
    {
        return shippingRuleId;
    }

    public void setShippingBandId (String shippingRuleId)
    {
        this.shippingRuleId = shippingRuleId;
    }
}
