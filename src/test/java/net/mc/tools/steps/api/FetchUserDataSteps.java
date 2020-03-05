package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.helpers.HelperClass;
import net.mc.tools.models.fetchListOfUsers.FetchListOfUsersResponse.FetchListOfUsersErrorResponseModel;
import net.mc.tools.models.fetchUserData.FetchUserDataRequest.FetchUserDataRequestModel;
import net.mc.tools.models.fetchUserData.FetchUserDataResponse.FetchUserDataErrorResponseModel;
import net.mc.tools.models.fetchUserData.FetchUserDataResponse.FetchUserDataResponseModel;
import net.mc.tools.models.token.TokenMessageRequestModel;
import net.mc.tools.services.auth.FetchListOfUsersService;
import net.mc.tools.services.auth.FetchUserDataService;
import org.junit.Assert;

import static net.mc.tools.services.auth.FetchListOfUsersService.gson;
import static net.mc.tools.services.auth.FetchUserDataService.gson_method;

import java.util.List;


public class FetchUserDataSteps
{
    private static Response response;
    private FetchUserDataRequestModel fetchUserDataRequestModel;
    private FetchUserDataResponseModel fetchUserDataResponseModel;
    private FetchUserDataErrorResponseModel fetchUserDataErrorResponseModel;
    private List<FetchUserDataRequestModel> FetchUserDataRequestModelList;
    private static int i=-1,j=0;

    @Then("^user enter the requesterID , sellerId and userType$")
    public void user_enter_the_requesterID_sellerId_and_userType(List<FetchUserDataRequestModel> FetchUserDataRequestModelList) throws Exception
    {
        this.FetchUserDataRequestModelList=FetchUserDataRequestModelList;
    }
    @Then("^user enter the requesterID , vendorId and userType$")
    public void user_enter_the_requesterID_vendorId_and_userType(List<FetchUserDataRequestModel> FetchUserDataRequestModelList) throws Exception
    {
        this.FetchUserDataRequestModelList=FetchUserDataRequestModelList;
    }

    @Then("^user make a request to fetch details of seller$")
    public void user_make_a_request_to_fetch_details_of_seller() throws Exception
    {
       response= FetchUserDataService.FetchUserDatawithToken(FetchUserDataRequestModelList,LoginSteps.token);

    }

    @Then("^user make a request to fetch details of vendor$")
    public void user_make_a_request_to_fetch_details_of_vendor() throws Exception
    {
        response= FetchUserDataService.FetchUserDatawithToken(FetchUserDataRequestModelList,LoginSteps.token);
    }

    @Then("^user should be able to gets all the details of a person that he requested$")
    public void user_should_be_able_to_gets_all_the_details_of_a_person_that_he_requested() throws Exception
    {
        Assert.assertTrue(response.getStatusCode()==200);
        fetchUserDataResponseModel=gson_method().fromJson(response.body().prettyPrint(),FetchUserDataResponseModel.class);
        System.out.println(fetchUserDataResponseModel.getStatus());
    }

    @Then("^user should not be able to get all the details of a person that he requested$")
    public void user_should_not_be_able_to_get_all_the_details_of_a_person_that_he_requested() throws Exception
    {
       response.body().prettyPrint();
       Assert.assertTrue(response.getStatusCode()>=400);
    }

    @Then("^user should not be able to get all the details of a person that he requested and user should get validation messages$")
    public void user_should_not_be_able_to_get_all_the_details_of_a_person_that_he_requested_and_user_should_get_validation_messages(List<String> errorMessage) throws Exception
    {
        HelperClass.ErrorValidationPage(response,errorMessage);
    }

    @When("^user make a request for seller or vendor details with Incorrect/blank token field in form of without login credentials$")
    public void user_make_a_request_for_seller_or_vendor_details_with_Incorrect_blank_token_field_in_form_of_without_login_credentials(List<TokenMessageRequestModel> tokenMessageRequestModelList) throws Exception
    {
        System.out.println(" tokenMessage ---("+tokenMessageRequestModelList.get(0).gettoken()+")");
        response= FetchUserDataService.FetchUserDatawithToken(FetchUserDataRequestModelList,tokenMessageRequestModelList.get(0).gettoken());
        response.body().prettyPrint();
    }

    @Then("^user should not be able to gets any vendor or seller details that he requested then user should get a  validation message for Incorrect/blank token$")
    public void user_should_not_be_able_to_gets_any_vendor_or_seller_details_that_he_requested_then_user_should_get_a_validation_message_for_Incorrect_blank_token(List<String> errorMessage) throws Exception
    {
        Assert.assertTrue(response.getStatusCode() >= 400);
        fetchUserDataErrorResponseModel = gson().fromJson(response.body().prettyPrint(), FetchUserDataErrorResponseModel.class);
        Assert.assertEquals("error", fetchUserDataErrorResponseModel.get_status());
        Assert.assertTrue(fetchUserDataErrorResponseModel.get_data() == null);
        Assert.assertEquals(errorMessage.get(0), fetchUserDataErrorResponseModel.get_error());

    }


}
