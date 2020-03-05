package net.mc.tools.models.fetchListOfProducts.fetchListOfProductsRequest;

public class FetchListOfProductsRequestModel
{
    private String filter;

    private String search;

    private String sortName;

    private String perPage;

    private String sortOrder;

    private String page;

    private String userId;

    private String[] searchFilter;

    public String getFilter ()
    {
        return filter;
    }

    public void setFilter (String filter)
    {
        this.filter = filter;
    }

    public String getSearch ()
    {
        return search;
    }

    public void setSearch (String search)
    {
        this.search = search;
    }

    public String getSortName ()
    {
        return sortName;
    }

    public void setSortName (String sortName)
    {
        this.sortName = sortName;
    }

    public String getPerPage ()
    {
        return perPage;
    }

    public void setPerPage (String perPage)
    {
        this.perPage = perPage;
    }

    public String getSortOrder ()
    {
        return sortOrder;
    }

    public void setSortOrder (String sortOrder)
    {
        this.sortOrder = sortOrder;
    }

    public String getPage ()
    {
        return page;
    }

    public void setPage (String page)
    {
        this.page = page;
    }

    public String getUserId ()
    {
        return userId;
    }

    public void setUserId (String userId)
    {
        this.userId = userId;
    }

    public String[] getSearchFilter ()
    {
        return searchFilter;
    }

    public void setSearchFilter (String[] searchFilter)
    {
        this.searchFilter = searchFilter;
    }
}
