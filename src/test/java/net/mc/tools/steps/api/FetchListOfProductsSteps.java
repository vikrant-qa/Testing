package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.helpers.HelperClass;
import net.mc.tools.models.fetchListOfProducts.fetchListOfProductsRequest.FetchListOfProductsRequestModel;
import net.mc.tools.models.fetchListOfProducts.fetchListOfProductsResponse.FetchListOfProductsResponseModel;
import net.mc.tools.models.respnseForAllModel.ErrorResponseCommonForAll;
import net.mc.tools.models.token.TokenMessageRequestModel;
import net.mc.tools.services.auth.FetchListOfProductsService;
import net.mc.tools.services.auth.RegisterService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.FetchListOfProductsService.gson;


public class FetchListOfProductsSteps
{
    private  static List<FetchListOfProductsRequestModel> fetchListOfProductsRequestModelList;
    private static Response jsonResponse;
    private static FetchListOfProductsResponseModel fetchListOfProductsResponseModel;
    private static ErrorResponseCommonForAll errorResponseCommonForAll;
    private static int i=0;

    @Then("^user enters the requesterID for product list$")
    public void user_enters_the_requesterID_for_product_list(List<FetchListOfProductsRequestModel> fetchListOfProductsRequestModelList1) throws Exception
    {
        this.fetchListOfProductsRequestModelList=fetchListOfProductsRequestModelList1;
    }

    @Then("^user make a request to fetch list of products$")
    public void user_make_a_request_to_fetch_list_of_products() throws Exception
    {
        jsonResponse= FetchListOfProductsService.FetchListOfProductRequestWithToken(fetchListOfProductsRequestModelList,LoginSteps.token);
    }

    @Then("^User should be able to fetch product list that he requested$")
    public void user_should_be_able_to_fetch_product_list_that_he_requested() throws Exception
    {
        jsonResponse.body().prettyPrint();
        Assert.assertTrue(jsonResponse.getStatusCode() == 200);
        fetchListOfProductsResponseModel = gson().fromJson(jsonResponse.body().prettyPrint(), FetchListOfProductsResponseModel.class);
        Assert.assertTrue(fetchListOfProductsResponseModel.getProducts() != null);
        Assert.assertEquals("ok", fetchListOfProductsResponseModel.getStatus());
        Assert.assertTrue(fetchListOfProductsResponseModel.getCount() != null);
    }

    @Then("^User should be able to fetch product list that system admin requested$")
    public void user_should_be_able_to_fetch_product_list_that_system_admin_requested() throws Exception
    {
        jsonResponse.body().prettyPrint();
        Assert.assertTrue(jsonResponse.getStatusCode() == 200);

    }


    @Then("^User should not be able to fetch products list that he requested and user should get validation message$")
    public void User_should_not_be_able_to_fetch_products_list_that_he_requested_and_user_should_get_validation_message(List<String> errorMessage) throws Exception
    {

        HelperClass.ErrorValidationPage(jsonResponse,errorMessage);
    }

    @When("^user make a request for list of products with Incorrect/blank token field in form of without login credentials$")
    public void user_make_a_request_for_list_of_products_with_Incorrect_blank_token_field_in_form_of_without_login_credentials(List<TokenMessageRequestModel> tokenMessageRequestModelList) throws Exception
    {
        System.out.println(" tokenMessage ---("+tokenMessageRequestModelList.get(0).gettoken()+")");
        jsonResponse= FetchListOfProductsService.FetchListOfProductRequestWithToken(fetchListOfProductsRequestModelList,tokenMessageRequestModelList.get(0).gettoken());

    }
}
