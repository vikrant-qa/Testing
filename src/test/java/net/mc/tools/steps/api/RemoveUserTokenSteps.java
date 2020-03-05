package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.removeUserToken.request.RemoveUserTokenStepsRequestModel;
import net.mc.tools.models.removeUserToken.response.RemoveUserTokenStepsErrorResponseModel;
import net.mc.tools.models.removeUserToken.response.RemoveUserTokenStepsResponseModel;
import net.mc.tools.models.token.TokenMessageRequestModel;
import net.mc.tools.services.auth.RemoveUserTokenService;
import org.junit.Assert;
import static net.mc.tools.services.auth.RegisterService.gson;

import java.util.List;

public class RemoveUserTokenSteps
{
    private UpdateCommissionSteps updateCommissionSteps;
    private static Response removeTokenResponse;
    private RemoveUserTokenStepsResponseModel removeUserTokenStepsResponseModel;
    private RemoveUserTokenStepsErrorResponseModel removeUserTokenStepsErrorResponseModel;
    private List<RemoveUserTokenStepsRequestModel> list1;
    private static int i=0;


    @When("^user remove valid token by clicking Logout button$")
    public void user_remove_valid_token_by_clicking_Logout_button(List<RemoveUserTokenStepsRequestModel> list) throws Exception
    {
        System.out.println(list.get(0).getdata()+"    "+list.get(0).getstatus());
      removeTokenResponse= RemoveUserTokenService.removeUserToken(list,LoginSteps.token);

    }

    @Then("^user should get comes out of the system successfully$")
    public void user_should_get_comes_out_of_the_system_successfully() throws Exception
    {
        Assert.assertTrue(removeTokenResponse.getStatusCode() == 200);
        removeUserTokenStepsResponseModel = gson().fromJson(removeTokenResponse.body().prettyPrint(), RemoveUserTokenStepsResponseModel.class);
        Assert.assertEquals("ok" , removeUserTokenStepsResponseModel.getStatus());
        Assert.assertEquals("true", removeUserTokenStepsResponseModel.getdata());

    }
    @When("^user wants to remove Incorrect/Wrong token by clicking Logout button$")
    public void user_wants_to_remove_Incorrect_Wrong_token_by_clicking_Logout_button(List<RemoveUserTokenStepsRequestModel> list) throws Exception
    {
        System.out.println(list.get(0).getdata()+"    "+list.get(0).getstatus());
        removeTokenResponse= RemoveUserTokenService.removeUserToken(list,"tyshhjsjjjsjjsjjsj");

    }
    @When("^user wants to remove valid token by clicking Logout button$")
    public void user_wants_to_remove_valid_token_by_clicking_Logout_button(List<RemoveUserTokenStepsRequestModel> list) throws Exception
    {
        list1=list;
    }

    @Then("^user make a request to remove token with Incorrect/blank token field in form of without login credentials$")
    public void user_make_a_request_to_remove_token_with_Incorrect_blank_token_field_in_form_of_without_login_credentials(List<TokenMessageRequestModel> tokenRequest) throws Exception
    {
        removeTokenResponse= RemoveUserTokenService.removeUserToken(list1,tokenRequest.get(0).gettoken());

    }

    @Then("^user should not be able to remove token without follow any field validation then user should get a  validation message for Incorrect/blank token$")
    public void user_should_not_be_able_to_remove_token_without_follow_any_field_validation_then_user_should_get_a_validation_message_for_Incorrect_blank_token(List<String> tokenmessage) throws Exception
    {
        Assert.assertTrue(removeTokenResponse.getStatusCode() >= 400);
        removeUserTokenStepsErrorResponseModel = gson().fromJson(removeTokenResponse.body().prettyPrint(), RemoveUserTokenStepsErrorResponseModel.class);
        Assert.assertEquals("error" , removeUserTokenStepsErrorResponseModel.getStatus());
        Assert.assertEquals(tokenmessage.get(0), removeUserTokenStepsErrorResponseModel.getError());
    }


}
