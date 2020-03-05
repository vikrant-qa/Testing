package net.mc.tools.models.updateTermsSetting.request;

public class UpdateTermsSettingForSellerRequestModel {

    private String isReturn;

    private String returnPeriod;

    private PaymentTerms paymentTerms;

    public String getIsReturn ()
    {
        return isReturn;
    }

    public void setIsReturn (String isReturn)
    {
        this.isReturn = isReturn;
    }

    public String getReturnPeriod ()
    {
        return returnPeriod;
    }

    public void setReturnPeriod (String returnPeriod)
    {
        this.returnPeriod = returnPeriod;
    }

    public PaymentTerms getPaymentTerms ()
    {
        return paymentTerms;
    }

    public void setPaymentTerms (PaymentTerms paymentTerms)
    {
        this.paymentTerms = paymentTerms;
    }
}
