package net.mc.tools.models.muteNotification.request;

public class MuteNotificationRequestModel {

    private boolean isResetAll;

    private String label;

    public boolean getIsResetAll ()
    {
        return isResetAll;
    }

    public void setIsResetAll (boolean isResetAll)
    {
        this.isResetAll = isResetAll;
    }

    public String getLabel ()
    {
        return label;
    }

    public void setLabel (String label)
    {
        this.label = label;
    }
}
