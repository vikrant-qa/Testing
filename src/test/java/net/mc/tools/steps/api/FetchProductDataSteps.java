package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.helpers.HelperClass;
import net.mc.tools.models.fetchProductData.fetchProductDataRequest.FetchProductDataRequestModel;
import net.mc.tools.models.fetchProductData.fetchProductDataResponse.FetchProductDataResponseModel;
import net.mc.tools.models.token.TokenMessageRequestModel;
import net.mc.tools.services.auth.FetchProductDataService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.FetchProductDataService.gson;

public class FetchProductDataSteps
{
    List<FetchProductDataRequestModel> fetchProductDataRequestModelList;
    private static Response jsonResponse;
    private static FetchProductDataResponseModel fetchProductDataResponseModel;

    @When("^user enters the Object id of product and Object id of user who is sending the request$")
    public void user_enters_the_Object_id_of_product_and_Object_id_of_user_who_is_sending_the_request(List<FetchProductDataRequestModel> fetchProductDataRequestModelList1) throws Exception
    {
      this.fetchProductDataRequestModelList=fetchProductDataRequestModelList1;
    }

    @When("^user make a request to fetch details of desired product$")
    public void user_make_a_request_to_fetch_details_of_desired_product() throws Exception
    {
      jsonResponse= FetchProductDataService.req(fetchProductDataRequestModelList,LoginSteps.token);
    }


    @When("^user make a request for product details with Incorrect/blank token field in form of without login credentials$")
    public void user_make_a_request_for_product_details_with_Incorrect_blank_token_field_in_form_of_without_login_credentials(List<TokenMessageRequestModel> tokenMessageRequestModelList) throws Exception
    {
        jsonResponse= FetchProductDataService.req(fetchProductDataRequestModelList,tokenMessageRequestModelList.get(0).gettoken());
    }

    @Then("^user should be able to fetch details of desired product$")
    public void user_should_be_able_to_fetch_details_of_desired_product() throws Exception
    {
        jsonResponse.body().prettyPrint();
        Assert.assertTrue(jsonResponse.getStatusCode()==200);
       fetchProductDataResponseModel=gson().fromJson(jsonResponse.body().prettyPrint(),FetchProductDataResponseModel.class);
       Assert.assertEquals("ok",fetchProductDataResponseModel.getStatus());
       Assert.assertTrue(fetchProductDataResponseModel.getProduct().get_id().equals(fetchProductDataRequestModelList.get(0).getId())
               || !fetchProductDataResponseModel.getProduct().getVendor().isEmpty()
               || !fetchProductDataResponseModel.getProduct().getVendorId().isEmpty()
               || !fetchProductDataResponseModel.getProduct().getTitle().isEmpty()
               || !fetchProductDataResponseModel.getProduct().getAddedBy().isEmpty()
               || !fetchProductDataResponseModel.getProduct().getCreatedAt().isEmpty()
               || !fetchProductDataResponseModel.getProduct().getUpdatedAt().isEmpty());
    }


    @Then("^user should not be able to fetch details of desired product that he requested and user shuld get a validation message$")
    public void user_should_not_be_able_to_fetch_details_of_desired_product_that_he_requested_and_user_shuld_get_a_validation_message(List<String> errorMessage) throws Exception
    {
        HelperClass.ErrorValidationPage(jsonResponse,errorMessage);
    }

}
