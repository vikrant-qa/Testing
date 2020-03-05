package net.mc.tools.models.orders.response;

public class FetchListOfOrdersResponseModel {

    private String count;

    private Orders[] orders;

    private String status;

    public String getCount ()
    {
        return count;
    }

    public void setCount (String count)
    {
        this.count = count;
    }

    public Orders[] getOrders ()
    {
        return orders;
    }

    public void setOrders (Orders[] orders)
    {
        this.orders = orders;
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
