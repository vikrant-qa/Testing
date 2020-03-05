package net.mc.tools.models.fetchUserData.FetchUserDataResponse;

public class FetchUserDataResponseModel
{
    private User user;

    private String status;

    public User getuser() {

        return user;
    }

    public void setuser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
