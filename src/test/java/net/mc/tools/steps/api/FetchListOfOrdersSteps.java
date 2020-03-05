package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.orders.request.FetchListOfOrdersRequestModel;
import net.mc.tools.models.orders.response.FetchListOfOrdersErrorResponseModel;
import net.mc.tools.models.orders.response.FetchListOfOrdersResponseModel;
import net.mc.tools.models.respnseForAllModel.ErrorResponseCommonForAll;
import net.mc.tools.models.token.TokenMessageRequestModel;
import net.mc.tools.services.auth.FetchListOfOrdersService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class FetchListOfOrdersSteps {

    private Response jsonResponse;
    private static FetchListOfOrdersResponseModel fetchListOfOrdersResponseModel;
    private static FetchListOfOrdersErrorResponseModel fetchListOfOrdersErrorResponseModel;
    private static String[] s = new String[1];
    private static int i = 0;
    private static ErrorResponseCommonForAll errorResponseCommonForAll;
    private static List<FetchListOfOrdersRequestModel> fetchListOfOrdersRequestModelList;

    @Then("^user enters the requesterID for order list$")
    public void user_enters_the_requesterID_for_order_list(List<FetchListOfOrdersRequestModel> fetchListOfOrdersRequestModelList1) throws Exception
    {
      this.fetchListOfOrdersRequestModelList=fetchListOfOrdersRequestModelList1;
    }

    @Then("^user make a request to fetch list of orders$")
    public void user_make_a_request_to_fetch_list_of_orders() throws Exception
    {
        jsonResponse=FetchListOfOrdersService.FetchListOfOrdersRrequestWithToken(fetchListOfOrdersRequestModelList,LoginSteps.token);
    }

    @Then("^User should be able to fetch order list that he requested$")
    public void user_should_be_able_to_fetch_order_list_that_he_requested() throws Exception
    {
        Assert.assertTrue(jsonResponse.getStatusCode() == 200);
        fetchListOfOrdersResponseModel = gson().fromJson(jsonResponse.body().prettyPrint(), FetchListOfOrdersResponseModel.class);
        Assert.assertTrue(fetchListOfOrdersResponseModel.getOrders() != null);
        Assert.assertEquals("ok", fetchListOfOrdersResponseModel.getStatus());
        Assert.assertTrue(fetchListOfOrdersResponseModel.getCount() != null);
    }


    @Then("^User should not be able to fetch order list that he requested and user should get validation message$")
    public void User_should_not_be_able_to_fetch_order_list_that_he_requested_and_user_should_get_validation_message(List<String> errorMessage) throws Exception
    {
        jsonResponse.body().prettyPrint();
        try
        {
            if (jsonResponse.getStatusCode() >= 400)
            {
                errorResponseCommonForAll = gson().fromJson(jsonResponse.body().prettyPrint(), ErrorResponseCommonForAll.class);
                Assert.assertEquals("error", errorResponseCommonForAll.getStatus());
                Assert.assertTrue(errorResponseCommonForAll.getData() == null);
                Assert.assertEquals(errorMessage.get(i), errorResponseCommonForAll.getError());
            } else {
                System.out.println("********************Actual error message is not find and log bug for this************************* ");
                Assert.assertTrue(jsonResponse.getStatusCode() >= 400);
            }
        }
        catch (Exception error)
        {
            error.printStackTrace();
            System.out.println("********************Actual error message is not find and log bug for this************************* ");
        }
        finally
        {
            i++;
            if (errorMessage.size()==i)
            {
                i=0;
                System.out.println("Now value of i is updated : "+i);
            }
        }

    }
    @When("^user make a request for list of orders with Incorrect/blank token field in form of without login credentials$")
    public void user_make_a_request_for_list_of_orders_with_Incorrect_blank_token_field_in_form_of_without_login_credentials(List<TokenMessageRequestModel> tokenMessageRequestModelList) throws Exception
    {
        System.out.println(" tokenMessage ---("+tokenMessageRequestModelList.get(0).gettoken()+")");
        jsonResponse= FetchListOfOrdersService.FetchListOfOrdersRrequestWithToken(fetchListOfOrdersRequestModelList,tokenMessageRequestModelList.get(0).gettoken());

    }






































    @When("^user enters search filter$")
    public void userEnterDetailsOfOrder(List<String> id)
    {
        s[0] = id.get(1);

    }

    @And("^User enters details of order to be fetched$")
    public void enterUserid(List<FetchListOfOrdersRequestModel> fetchListOfOrdersRequestModels){
        fetchListOfOrdersRequestModels.get(0).setSearchFilter(s);
        jsonResponse = FetchListOfOrdersService.requestWithToken(fetchListOfOrdersRequestModels,LoginSteps.token);
    }
    @Then("^User should be able to fetch order$")
    public void userShouldBeAbleToUpdateOrder()  {
        Assert.assertTrue(jsonResponse.getStatusCode() == 200);
        fetchListOfOrdersResponseModel = gson().fromJson(jsonResponse.body().prettyPrint(), FetchListOfOrdersResponseModel.class);
        Assert.assertTrue(fetchListOfOrdersResponseModel.getOrders() != null);
        Assert.assertEquals("ok", fetchListOfOrdersResponseModel.getStatus());
        Assert.assertTrue(fetchListOfOrdersResponseModel.getCount() != null);
    }

    @Then("^User should be able to validate fetch order validation messages$")
    public void userShouldNotBeAbleToUpdateOrder(List<String> message)  {
        Assert.assertTrue(jsonResponse.getStatusCode() == 422);
        fetchListOfOrdersErrorResponseModel = gson().fromJson(jsonResponse.body().prettyPrint(), FetchListOfOrdersErrorResponseModel.class);
        Assert.assertTrue(fetchListOfOrdersErrorResponseModel.getData() == null);
        Assert.assertEquals("error", fetchListOfOrdersErrorResponseModel.getStatus());
        Assert.assertEquals(message.get(i), fetchListOfOrdersErrorResponseModel.getError());
        i++;
    }
}
