package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.fetchListOfUsers.FetchListOfUsersRequest.FetchListOfUsersRequestModel;
import net.mc.tools.models.fetchListOfUsers.FetchListOfUsersResponse.FetchListOfUsersErrorResponseModel;
import net.mc.tools.models.fetchListOfUsers.FetchListOfUsersResponse.FetchListOfUsersResponseModel;
import net.mc.tools.models.orders.response.FetchListOfOrdersErrorResponseModel;
import net.mc.tools.models.orders.response.FetchListOfOrdersResponseModel;
import net.mc.tools.models.token.TokenMessageRequestModel;
import net.mc.tools.services.auth.FetchListOfUsersService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.FetchListOfUsersService.gson;

public class FetchListOfUsersSteps
{
    private static Response getResponse;
    private static List<FetchListOfUsersRequestModel> fetchListOfUsersRequestModel;
    private FetchListOfUsersResponseModel fetchListOfUsersResponseModel;
    private FetchListOfUsersErrorResponseModel fetchListOfUsersErrorResponseModel;
    private static int i=-1,j=-1,k=-1;

    @Then("^user enter the requesterID and userType$")
    public void user_enter_the_requesterID_and_userType(List<FetchListOfUsersRequestModel> fetchListOfUsersRequestModel) throws Exception
    {
       this.fetchListOfUsersRequestModel=fetchListOfUsersRequestModel;
    }

    @Then("^user make a request to fetch list of seller$")
    public void user_make_a_request_to_fetch_list_of_seller() throws Exception
    {
        getResponse= FetchListOfUsersService.FetchListOfUsersWithToken(fetchListOfUsersRequestModel,LoginSteps.token);
        getResponse.body().prettyPrint();
    }

    @Then("^user should be able to gets all list of seller that he requested$")
    public void user_should_be_able_to_gets_all_list_of_seller_that_he_requested() throws Exception
    {
        getResponse.body().prettyPrint();
        Assert.assertTrue(getResponse.getStatusCode()==200);
    }
    @Then("^user make a request to fetch list of vendor$")
    public void user_make_a_request_to_fetch_list_of_vendor() throws Exception
    {
        getResponse= FetchListOfUsersService.FetchListOfUsersWithToken(fetchListOfUsersRequestModel,LoginSteps.token);
        getResponse.body().prettyPrint();
    }

    @Then("^user should be able to gets all list of vendor that he requested$")
    public void user_should_be_able_to_gets_all_list_of_vendor_that_he_requested() throws Exception
    {
        getResponse.body().prettyPrint();
        Assert.assertTrue(getResponse.getStatusCode()==200);
    }

    @Then("^user should not be able to gets any list of seller that he requested and user should get validation messages$")
    public void user_should_not_be_able_to_gets_any_list_of_seller_that_he_requested_and_user_should_get_validation_messages(List<String> errorMessage) throws Exception
    {
        i++;
        Assert.assertTrue(getResponse.getStatusCode()>=400);
        fetchListOfUsersErrorResponseModel=gson().fromJson( getResponse.body().prettyPrint(), FetchListOfUsersErrorResponseModel.class);
        Assert.assertEquals("error",fetchListOfUsersErrorResponseModel.get_status());
        Assert.assertTrue(fetchListOfUsersErrorResponseModel.get_data()==null);
        Assert.assertEquals(errorMessage.get(i),fetchListOfUsersErrorResponseModel.get_error());

    }

    @Then("^user should not be able to gets any list of vendor that he requested and user should get validation messages$")
    public void user_should_not_be_able_to_gets_any_list_of_vendor_that_he_requested_and_user_should_get_validation_messages(List<String> errorMessage) throws Exception
    {
        k++;
        Assert.assertTrue(getResponse.getStatusCode()>=400);
        fetchListOfUsersErrorResponseModel=gson().fromJson( getResponse.body().prettyPrint(), FetchListOfUsersErrorResponseModel.class);
        Assert.assertEquals("error",fetchListOfUsersErrorResponseModel.get_status());
        Assert.assertTrue(fetchListOfUsersErrorResponseModel.get_data()==null);
        Assert.assertEquals(errorMessage.get(k),fetchListOfUsersErrorResponseModel.get_error());

    }

    @Then("^so user as a vendor should not be able to gets any list of vendor or seller that he requested and user should get validation message$")
    public void so_user_as_a_vendor_should_not_be_able_to_gets_any_list_of_vendor_or_seller_that_he_requested_and_user_should_get_validation_message(List<String> errorMessage) throws Exception
    {
        System.out.println("    Then so user as a vendor should not be able to gets any list of vendor or seller that he requested and user should get validation message\n");
        j++;
        Assert.assertTrue(getResponse.getStatusCode()>=400);
        fetchListOfUsersErrorResponseModel=gson().fromJson( getResponse.body().prettyPrint(), FetchListOfUsersErrorResponseModel.class);
        Assert.assertEquals("error",fetchListOfUsersErrorResponseModel.get_status());
        Assert.assertTrue(fetchListOfUsersErrorResponseModel.get_data()==null);
        Assert.assertEquals(errorMessage.get(j),fetchListOfUsersErrorResponseModel.get_error());

    }

    @When("^user make a request for list of seller or vendor with Incorrect/blank token field in form of without login credentials$")
    public void user_make_a_request_for_list_of_seller_or_vendor_with_Incorrect_blank_token_field_in_form_of_without_login_credentials(List<TokenMessageRequestModel> tokenMessageRequestModelList) throws Exception
    {
        System.out.println(" tokenMessage ---("+tokenMessageRequestModelList.get(0).gettoken()+")");
        getResponse= FetchListOfUsersService.FetchListOfUsersWithToken(fetchListOfUsersRequestModel,tokenMessageRequestModelList.get(0).gettoken());
        getResponse.body().prettyPrint();

    }

    @Then("^user should not be able to gets any list of vendor or seller that he requested then user should get a  validation message for Incorrect/blank token$")
    public void user_should_not_be_able_to_gets_any_list_of_vendor_or_seller_that_he_requested_then_user_should_get_a_validation_message_for_Incorrect_blank_token(List<String> errorMessage) throws Exception
    {
        Assert.assertTrue(getResponse.getStatusCode()>=400);
        fetchListOfUsersErrorResponseModel=gson().fromJson( getResponse.body().prettyPrint(), FetchListOfUsersErrorResponseModel.class);
        Assert.assertEquals("error",fetchListOfUsersErrorResponseModel.get_status());
        Assert.assertTrue(fetchListOfUsersErrorResponseModel.get_data()==null);
        Assert.assertEquals(errorMessage.get(0),fetchListOfUsersErrorResponseModel.get_error());
    }


}
