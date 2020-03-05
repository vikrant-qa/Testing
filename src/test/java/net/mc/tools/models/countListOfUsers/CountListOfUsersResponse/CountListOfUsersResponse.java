package net.mc.tools.models.countListOfUsers.CountListOfUsersResponse;

public class CountListOfUsersResponse
{
    private String status;
    private int data;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
