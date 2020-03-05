package net.mc.tools.models.fetchListOfProducts.fetchListOfProductsResponse;

public class Images
{
    private String shopifyImageId;

    private String imageUrl;

    private String position;

    private String url;

    public String getShopifyImageId ()
    {
        return shopifyImageId;
    }

    public void setShopifyImageId (String shopifyImageId)
    {
        this.shopifyImageId = shopifyImageId;
    }

    public String getImageUrl ()
    {
        return imageUrl;
    }

    public void setImageUrl (String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    public String getPosition ()
    {
        return position;
    }

    public void setPosition (String position)
    {
        this.position = position;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }
}
