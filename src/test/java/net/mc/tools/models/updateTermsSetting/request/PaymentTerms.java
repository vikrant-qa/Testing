package net.mc.tools.models.updateTermsSetting.request;

public class PaymentTerms {

    private String days;

    private String type;

    public String getDays ()
    {
        return days;
    }

    public void setDays (String days)
    {
        this.days = days;
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
