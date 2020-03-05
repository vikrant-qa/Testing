package net.mc.tools.models.fetchProductData.fetchProductDataResponse;

public class Product
{
    private Images[] images;

    private String primaryImageUrl;

    private String addedBy;

    private String vendorId;

    private String description;

    private String handle;

    private String[] variants;

    private String title;

    private String createdAt;

    private String approved;

    private String vendor;

    private String _id;

    private String status;

    private String updatedAt;

    public Images[] getImages ()
    {
        return images;
    }

    public void setImages (Images[] images)
    {
        this.images = images;
    }

    public String getPrimaryImageUrl ()
    {
        return primaryImageUrl;
    }

    public void setPrimaryImageUrl (String primaryImageUrl)
    {
        this.primaryImageUrl = primaryImageUrl;
    }

    public String getAddedBy ()
    {
        return addedBy;
    }

    public void setAddedBy (String addedBy)
    {
        this.addedBy = addedBy;
    }

    public String getVendorId ()
    {
        return vendorId;
    }

    public void setVendorId (String vendorId)
    {
        this.vendorId = vendorId;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getHandle ()
    {
        return handle;
    }

    public void setHandle (String handle)
    {
        this.handle = handle;
    }

    public String[] getVariants ()
    {
        return variants;
    }

    public void setVariants (String[] variants)
    {
        this.variants = variants;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getCreatedAt ()
    {
        return createdAt;
    }

    public void setCreatedAt (String createdAt)
    {
        this.createdAt = createdAt;
    }

    public String getApproved ()
    {
        return approved;
    }

    public void setApproved (String approved)
    {
        this.approved = approved;
    }

    public String getVendor ()
    {
        return vendor;
    }

    public void setVendor (String vendor)
    {
        this.vendor = vendor;
    }

    public String get_id ()
    {
        return _id;
    }

    public void set_id (String _id)
    {
        this._id = _id;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public String getUpdatedAt ()
    {
        return updatedAt;
    }

    public void setUpdatedAt (String updatedAt)
    {
        this.updatedAt = updatedAt;
    }

}
