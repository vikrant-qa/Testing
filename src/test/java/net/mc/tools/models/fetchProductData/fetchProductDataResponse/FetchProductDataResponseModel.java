package net.mc.tools.models.fetchProductData.fetchProductDataResponse;

public class FetchProductDataResponseModel
{
    private Product product;

    private String status;

    public Product getProduct ()
    {
        return product;
    }

    public void setProduct (Product product)
    {
        this.product = product;
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
