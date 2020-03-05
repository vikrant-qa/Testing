package net.mc.tools.models.deleteProductImage.deleteProductImageRequestModel;

public class DeleteProductImageRequest
{
    private String productId;
    private String url;
    private String seller;
    private String vendor;

    public String getProductId() {
        return productId;
    }

    public String getSeller() {
        return seller;
    }

    public String getUrl() {
        return url;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}
