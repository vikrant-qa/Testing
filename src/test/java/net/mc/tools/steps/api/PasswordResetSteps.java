package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.passwordReset.request.PasswordResetRequestModel;
import net.mc.tools.models.passwordReset.request.TokenGenerateRequestModel;
import net.mc.tools.models.passwordReset.response.PasswordResetErrorResponseModel;
import net.mc.tools.models.passwordReset.response.PasswordResetResponseModel;
import net.mc.tools.models.passwordReset.response.TokenGenerateResponseModel;
import net.mc.tools.services.auth.PasswordResetService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class PasswordResetSteps {

    private static Response resetResponse,tokenResponse;
    private TokenGenerateResponseModel tokenGenerateResponseModel;
    private PasswordResetResponseModel passwordResetResponseModel;
    private PasswordResetErrorResponseModel passwordResetErrorResponseModel;
    private String token = null;
    private static  int i=0;

    @When("^User enter the registered email and generate the token$")
    public void userRequestToGetRegisteredIntoTheSystem(List<TokenGenerateRequestModel> tokenGenerateRequestModel) {
        if (!tokenGenerateRequestModel.get(0).getEmail().isEmpty()){
            tokenGenerateRequestModel.get(0).setEmail(tokenGenerateRequestModel.get(0).getEmail());
        }

        tokenResponse = PasswordResetService.getToken(tokenGenerateRequestModel);

    }

    @When("^User should be able to change password with new passowrd$")
    public void userTryToChangePassword(List<PasswordResetRequestModel> passwordResetRequestModel)
    {
        if (passwordResetRequestModel.get(0).getToken()== null){
            passwordResetRequestModel.get(0).setToken(token);
        }

        resetResponse = PasswordResetService.resetPassword(passwordResetRequestModel);
    }

    @Then("^User entered new password and try to login with expired token$")
    public void userShouldNotBeAbleToChangePassword(List<PasswordResetRequestModel> passwordResetRequestModel) {
        if (passwordResetRequestModel.get(0).getToken()== null){
            passwordResetRequestModel.get(0).setToken("5767868679676");
        }
        resetResponse = PasswordResetService.resetPassword(passwordResetRequestModel);
    }

    @Then("^user should get error message$")
    public void userGetErrorMessageForExpiredToken(){
        passwordResetErrorResponseModel = gson().fromJson(resetResponse.body().prettyPrint(), PasswordResetErrorResponseModel.class);
        Assert.assertTrue(resetResponse.getStatusCode() == 422);
        Assert.assertEquals("Token Expired", passwordResetErrorResponseModel.getError());
        Assert.assertEquals("error", passwordResetErrorResponseModel.getStatus());
        Assert.assertTrue(passwordResetErrorResponseModel.getData() == null);
    }


    @When("^User enter the incorrect/wrong email and wants to create a token$")
    public void user_enter_the_incorrect_wrong_email_and_wants_to_create_a_token(List<TokenGenerateRequestModel> tokenGenerateRequestModel) throws Exception
    {
        if (!tokenGenerateRequestModel.get(0).getEmail().isEmpty()){
            tokenGenerateRequestModel.get(0).setEmail(tokenGenerateRequestModel.get(0).getEmail());
        }

        tokenResponse = PasswordResetService.getToken(tokenGenerateRequestModel);
    }

    @Then("^user should get validation error message$")
    public void user_should_get_validation_error_message(List<String> message) throws Exception
    {
        if(tokenResponse.getStatusCode()>=400)
        {
            Assert.assertTrue(tokenResponse.getStatusCode() == 422);
            passwordResetErrorResponseModel = gson().fromJson(tokenResponse.body().prettyPrint(), PasswordResetErrorResponseModel.class);
            Assert.assertEquals(message.get(i), passwordResetErrorResponseModel.getError());
            Assert.assertEquals("error", passwordResetErrorResponseModel.getStatus());
            Assert.assertTrue(passwordResetErrorResponseModel.getData() == null);
            i++;
        }
    }
    @Then("^user should not be able to reset password$")
    public void userGetErrorMessageForInvalidToken(List<PasswordResetRequestModel> passwordResetRequestModel){
        if (passwordResetRequestModel.get(0).getToken()== null){
            passwordResetRequestModel.get(0).setToken(token);
        }

        resetResponse = PasswordResetService.resetPassword(passwordResetRequestModel);
        passwordResetResponseModel = gson().fromJson(resetResponse.body().prettyPrint(), PasswordResetResponseModel.class);

        passwordResetErrorResponseModel = gson().fromJson(resetResponse.body().prettyPrint(), PasswordResetErrorResponseModel.class);
        Assert.assertTrue(resetResponse.getStatusCode() == 422);
        Assert.assertEquals("Token Expired", passwordResetErrorResponseModel.getError());
        Assert.assertEquals("error", passwordResetErrorResponseModel.getStatus());
        Assert.assertTrue(passwordResetErrorResponseModel.getData() == null);
    }
    @Then("^Token has been created successfully and user should get a message as a Mail Sent Successfully$")
    public void ThenTokenhasbeencreatedsuccessfullyandusershouldgetamessageasaMailSentSuccessfully()
    {
        Assert.assertTrue(tokenResponse.getStatusCode() == 200);
        tokenGenerateResponseModel = gson().fromJson(tokenResponse.body().prettyPrint(), TokenGenerateResponseModel.class);
        Assert.assertEquals("ok",tokenGenerateResponseModel.getStatus());
        Assert.assertTrue(tokenGenerateResponseModel.getData().getToken()!=null);
        token = tokenGenerateResponseModel.getData().getToken();
    }

    @And("^User password changed successfully and user should get a message as a Password Changed Successfully$")
    public void UserpasswordchangedsuccessfullyandusershouldgetamessageasaPasswordChangedSuccessfully()
    {
        Assert.assertTrue(resetResponse.getStatusCode() == 200);
        passwordResetResponseModel = gson().fromJson(resetResponse.body().prettyPrint(), PasswordResetResponseModel.class);

    }


}