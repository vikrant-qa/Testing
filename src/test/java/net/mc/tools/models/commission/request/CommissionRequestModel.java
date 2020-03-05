package net.mc.tools.models.commission.request;

public class CommissionRequestModel {

    private String commission;

    private String commissionType;

    public String getCommission ()
    {
        return commission;
    }

    public void setCommission (String commission)
    {
        this.commission = commission;
    }

    public String getCommissionType ()
    {
        return commissionType;
    }

    public void setCommissionType (String commissionType)
    {
        this.commissionType = commissionType;
    }
}
