package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.orders.request.BulkActionsRequestModel;
import net.mc.tools.models.orders.request.CountListOfOrdersRequestModel;
import net.mc.tools.models.orders.response.BulkActionsResponseModel;
import net.mc.tools.models.orders.response.CountListOfOrdersResponseModel;
import net.mc.tools.models.respnseForAllModel.ErrorResponseCommonForAll;
import net.mc.tools.models.token.TokenMessageRequestModel;
import net.mc.tools.services.auth.BulkActionsService;
import net.mc.tools.services.auth.CountListOfOrdersService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class CountListOfOrdersSteps {

    private static Response jsonResponse;
    private static CountListOfOrdersResponseModel countListOfOrdersResponseModel;
    private static ErrorResponseCommonForAll errorResponseCommonForAll;
    private static String token_Used;

    @When("^User enters details to count of list orders$")
    public void userEnterDetailsToGetCountOfList(List<CountListOfOrdersRequestModel> countListOfOrdersRequestModels)
    {
        jsonResponse = CountListOfOrdersService.requestWithToken(countListOfOrdersRequestModels,LoginSteps.token);
    }

    @Then("^User should be able to count list of orders that he requested$")
    public void User_should_be_able_to_count_list_of_orders_that_he_requested()
    {
        Assert.assertTrue(jsonResponse.getStatusCode() == 200);
        countListOfOrdersResponseModel = gson().fromJson(jsonResponse.body().prettyPrint(), CountListOfOrdersResponseModel.class);
        Assert.assertTrue(!countListOfOrdersResponseModel.getData().isEmpty());
        Assert.assertEquals("ok", countListOfOrdersResponseModel.getStatus());
    }

    @Then("^User should not be able to count list of orders that he requested$")
    public void User_should_not_be_able_to_count_list_of_orders_that_he_requested()
    {
        Assert.assertTrue(jsonResponse.getStatusCode() >= 400);
        errorResponseCommonForAll = gson().fromJson(jsonResponse.body().prettyPrint(), ErrorResponseCommonForAll.class);
        Assert.assertTrue(errorResponseCommonForAll.getData()==null);
        Assert.assertEquals("error", errorResponseCommonForAll.getStatus());
    }


    @When("^user passing the Incorrect/blank token data field in form of without login credentials$")
    public void user_passing_the_Incorrect_blank_token_data_field_in_form_of_without_login_credentials(List<TokenMessageRequestModel> tokenMessage) throws Exception
    {
        System.out.println(" tokenMessage ---("+tokenMessage.get(0).gettoken()+")");
        token_Used=tokenMessage.get(0).gettoken();
    }

    @When("^User enters details to count of list orders for token$")
    public void User_enters_details_to_count_of_list_orders_for_token(List<CountListOfOrdersRequestModel> countListOfOrdersRequestModels)
    {
        jsonResponse = CountListOfOrdersService.requestWithToken(countListOfOrdersRequestModels,token_Used);
    }

    @Then("^User should not be able to count list of orders that he requested then user should get a  validation message for Incorrect/blank token$")
    public void user_should_not_be_able_to_count_list_of_orders_that_he_requested_then_user_should_get_a_validation_message_for_Incorrect_blank_token() throws Exception
    {
        Assert.assertTrue(jsonResponse.getStatusCode() >= 400);
        errorResponseCommonForAll = gson().fromJson(jsonResponse.body().prettyPrint(), ErrorResponseCommonForAll.class);
        Assert.assertEquals("Invalid token provided",errorResponseCommonForAll.getError());
        Assert.assertEquals("error", errorResponseCommonForAll.getStatus());
    }
}
