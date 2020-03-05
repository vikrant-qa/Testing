package net.mc.tools.models.IdFetchOrderDataRow.IdFetchOrderDataRowResponse;

public class IdFetchOrderDataRowResponseModel
{
    private Order order;

    private String status;

    public Order getOrder ()
    {
        return order;
    }

    public void setOrder (Order order)
    {
        this.order = order;
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
