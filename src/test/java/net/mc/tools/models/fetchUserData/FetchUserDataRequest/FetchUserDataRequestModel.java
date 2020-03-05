package net.mc.tools.models.fetchUserData.FetchUserDataRequest;

public class FetchUserDataRequestModel
{
    private String userId;

    private String id;

    private String userType;

    public String getuserId ()
    {
        return userId;
    }

    public void setuserId (String userId)
    {
        this.userId = userId;
    }

    public String getuserType()
    {
        return userType;
    }

    public void setuserType (String userType)
    {
        this.userType = userType;
    }

    public String getid ()
    {
        return id;
    }

    public void setid (String id)
    {
        this.id = id;
    }

}
