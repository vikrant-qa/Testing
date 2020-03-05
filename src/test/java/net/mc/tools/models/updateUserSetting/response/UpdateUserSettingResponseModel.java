package net.mc.tools.models.updateUserSetting.response;

public class UpdateUserSettingResponseModel {

    private net.mc.tools.models.updateUserSetting.response.data data;

    private String status;

    public net.mc.tools.models.updateUserSetting.response.data getData ()
    {
        return data;
    }

    public void setData (net.mc.tools.models.updateUserSetting.response.data data)
    {
        this.data = data;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }
}
