package net.mc.tools.models.updateVendorFieldsForSeller.Reponse;

public class UpdateVendorFieldsForSellerResponse
{
    private Data data;

    private String status;

    public Data getData ()
    {
        return data;
    }

    public void setData (Data data)
    {
        this.data = data;
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
