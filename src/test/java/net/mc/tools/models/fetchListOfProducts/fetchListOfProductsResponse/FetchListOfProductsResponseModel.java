package net.mc.tools.models.fetchListOfProducts.fetchListOfProductsResponse;

public class FetchListOfProductsResponseModel
{
    private String count;

    private Products[] products;

    private String status;

    public String getCount ()
    {
        return count;
    }

    public void setCount (String count)
    {
        this.count = count;
    }

    public Products[] getProducts ()
    {
        return products;
    }

    public void setProducts (Products[] products)
    {
        this.products = products;
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
