package net.mc.tools.models.countListOfUsers.CountListOfUsersRequest;

public class CountListOfUsersRequestModel
{
    private String filter;
    private String userRole;

    public String getFilter()
    {
        return filter;
    }
    public void setFilter(String filter)
    {
        this.filter=filter;
    }
    public String getuserRole()
    {
        return userRole;
    }
    public void setuserRole(String userRole)
    {
        this.userRole=userRole;
    }

}
