package net.mc.tools.models.fetchListOfUsers.FetchListOfUsersRequest;

public class FetchListOfUsersRequestModel
{
    private String userId;

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


}
