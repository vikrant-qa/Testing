package net.mc.tools.models.countListOfUsers.CountListOfUsersRequest;

public class CountListOfUsersRequest
{
    private Filter filter;
    private UserRole userRole;

    public Filter getFilter()
    {
        return filter;
    }
    public void setFilter(Filter filter)
    {
        this.filter=filter;
    }
    public UserRole getuserRole()
    {
        return userRole;
    }
    public void setuserRole(UserRole userRole)
    {
        this.userRole=userRole;
    }

}
