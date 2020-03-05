package net.mc.tools.models.orders.request;

public class CountListOfOrdersRequestModel {

    private String filter;

    private String userId;

    public String getFilter ()
    {
        return filter;
    }

    public void setFilter (String filter)
    {
        this.filter = filter;
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
