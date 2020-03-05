package net.mc.tools.models.updateUserSetting.request;

public class UpdateUserSettingRequestModel {

    private String isAcceptOrder;

    private String id;

    public String getIsAcceptOrder ()
    {
        return isAcceptOrder;
    }

    public void setIsAcceptOrder (String isAcceptOrder)
    {
        this.isAcceptOrder = isAcceptOrder;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }
}
