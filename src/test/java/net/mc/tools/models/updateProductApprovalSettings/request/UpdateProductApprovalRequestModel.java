package net.mc.tools.models.updateProductApprovalSettings.request;

public class UpdateProductApprovalRequestModel {

    private boolean approveAll;

    private boolean approveSelected;

    private boolean reviewAll;

    private boolean isProductSync;

    public boolean getApproveAll ()
    {
        return approveAll;
    }

    public void setApproveAll (boolean approveAll)
    {
        this.approveAll = approveAll;
    }

    public boolean getApproveSelected ()
    {
        return approveSelected;
    }

    public void setApproveSelected (boolean approveSelected)
    {
        this.approveSelected = approveSelected;
    }

    public boolean getReviewAll ()
    {
        return reviewAll;
    }

    public void setReviewAll (boolean reviewAll)
    {
        this.reviewAll = reviewAll;
    }

    public boolean getIsProductSync ()
    {
        return isProductSync;
    }

    public void setIsProductSync (boolean isProductSync)
    {
        this.isProductSync = isProductSync;
    }
}
