package net.mc.tools.models.orders.request;

public class BulkActionsRequestModel {

    private String isSystemAdmin;

    private String sellerId;

    private String[] ids;

    private String key;

    public String getIsSystemAdmin ()
    {
        return isSystemAdmin;
    }

    public void setIsSystemAdmin (String isSystemAdmin)
    {
        this.isSystemAdmin = isSystemAdmin;
    }

    public String getSellerId ()
    {
        return sellerId;
    }

    public void setSellerId (String sellerId)
    {
        this.sellerId = sellerId;
    }

    public String[] getIds ()
    {
        return ids;
    }

    public void setIds (String[] ids)
    {
        this.ids = ids;
    }

    public String getKey ()
    {
        return key;
    }

    public void setKey (String key)
    {
        this.key = key;
    }
}
