package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.register.request.RegisterRequestModel;
import net.mc.tools.models.register.request.ResendVerificationMailRequestModel;
import net.mc.tools.models.register.request.VerifyEmailRequestModel;
import net.mc.tools.models.register.response.RegisterErrorResponseModel;
import net.mc.tools.models.register.response.RegisterResponseModel;
import net.mc.tools.models.register.response.VerifyEmailErrorResponseModel;
import net.mc.tools.models.register.response.VerifyEmailResponseModel;
import net.mc.tools.models.respnseForAllModel.ErrorResponseCommonForAll;
import net.mc.tools.models.token.TokenMessageRequestModel;
import net.mc.tools.services.auth.RegisterService;
import net.mc.tools.utilities.RandomGenerator;
import org.apache.commons.collections.set.SynchronizedSortedSet;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class RegisterSteps {

    private static Response json_Response,verifyEmailResponse,resendVerificationEmailResponse;
    private RegisterResponseModel registerResponseModel;
    private VerifyEmailResponseModel verifyEmailResponseModel;
    private VerifyEmailErrorResponseModel verifyEmailErrorResponseModel;
    private RegisterErrorResponseModel registerErrorResponseModel;
    private static ErrorResponseCommonForAll errorResponseCommonForAll;
    private static String emailID,tokenToBeUsed;
    private static List<RegisterRequestModel> registerRequestModels;
    private static int i=0;

    @When("^New user enters the emaliId and password field for registration$")
    public void new_user_enters_the_emaliId_and_password_field_for_registration(List<RegisterRequestModel> registerRequestModels1) throws Exception
    {
        if (!registerRequestModels1.get(0).getEmail().isEmpty()){
            registerRequestModels1.get(0).setEmail(registerRequestModels1.get(0).getEmail()+RandomGenerator.randomAlphanumeric(5)+"@mailinator.com");
        }
      this.registerRequestModels=registerRequestModels1;
    }

    @When("^User make a request to get registered into the system$")
    public void user_make_a_request_to_get_registered_into_the_system() throws Exception
    {
        System.out.println("The requester EmailId is -( "+registerRequestModels.get(0).getEmail()+" ) - and the password is -( "+registerRequestModels.get(0).getPassword()+" )");
        json_Response=RegisterService.createNewUser(registerRequestModels);
    }

    @Then("^User should be registered successfully into the system$")
    public void userShouldBeRegisteredSuccessfullyIntoTheSystem()
    {
        Assert.assertTrue(json_Response.getStatusCode() == 200);
        registerResponseModel = gson().fromJson(json_Response.body().prettyPrint(), RegisterResponseModel.class);
        Assert.assertEquals("ok", registerResponseModel.getStatus());
        Assert.assertTrue(registerResponseModel.getData().getToken() != null);
        tokenToBeUsed=registerResponseModel.getData().getToken();
    }



    @When("^new user enters the registered emaliId and password field for registration$")
    public void new_user_enters_the_registered_emaliId_and_password_field_for_registration(List<RegisterRequestModel> registerRequestModels2) throws Exception
    {
        this.registerRequestModels=registerRequestModels2;
    }

    @When("^user enters the emaliId and password field for registration$")
    public void user_enters_the_emaliId_and_password_field_for_registration(List<RegisterRequestModel> registerRequestModels2) throws Exception
    {
        this.registerRequestModels=registerRequestModels2;
    }

    @When("^User make a request to get register into the system$")
    public void user_make_a_request_to_get_register_into_the_system() throws Exception
    {
        System.out.println("The requester EmailId is -( "+registerRequestModels.get(0).getEmail()+" ) - and the password is -( "+registerRequestModels.get(0).getPassword()+" )");
        json_Response=RegisterService.createNewUser(registerRequestModels);
    }



    @Then("^The user will not be able to register on marketcube app and the user should get a validation message$")
    public void the_user_will_not_be_able_to_register_on_marketcube_app_and_the_user_should_get_a_validation_message(List<String> errorMessage) throws Exception
    {
        try {
            Assert.assertTrue(json_Response.getStatusCode() >= 400);
            errorResponseCommonForAll = gson().fromJson(json_Response.body().prettyPrint(), ErrorResponseCommonForAll.class);
            Assert.assertEquals("error", errorResponseCommonForAll.getStatus());
            Assert.assertEquals(errorMessage.get(i), errorResponseCommonForAll.getError());
            Assert.assertTrue(errorResponseCommonForAll.getData() == null);
        }
        finally
        {
         i++;
         if(errorMessage.size()==i)
         {
             i=0;
             System.out.println("Now the value of i is changed : --- ("+i+")");
         }
        }
    }



    @When("^new vendor confirms the token by clicking on a link that has been sent to its registered email$")
    public void new_vendor_confirms_the_token_by_clicking_on_a_link_that_has_been_sent_to_its_registered_email(List<VerifyEmailRequestModel> verifyEmailRequestModels) throws Exception
    {
        verifyEmailRequestModels.get(0).setToken(tokenToBeUsed);
        verifyEmailResponse=RegisterService.verifyEmail(verifyEmailRequestModels);
    }

    @Then("^New Vendor should be registered successfully into the system and Vendor should get message as a Your Email is Verified Successfully\\.$")
    public void vendor_should_be_registered_successfully_into_the_system_and_Vendor_should_get_message_as_a_Your_Email_is_Verified_Successfully() throws Exception
    {
        verifyEmailResponse.body().prettyPrint();
      Assert.assertTrue(verifyEmailResponse.statusCode()==200);
      verifyEmailResponseModel=gson().fromJson(verifyEmailResponse.body().prettyPrint(),VerifyEmailResponseModel.class);
      Assert.assertEquals("true",verifyEmailResponseModel.get_data());
        Assert.assertEquals("ok",verifyEmailResponseModel.get_status());

    }


    @When("^new vendor enters the token to verify email$")
    public void new_vendor_enters_the_token_to_verify_email(List<VerifyEmailRequestModel> verifyEmailRequestModels) throws Exception
    {
        verifyEmailResponse=RegisterService.verifyEmail(verifyEmailRequestModels);
    }

    @Then("^vendor should not be able to register into the system and vendor should get a validation messages$")
    public void vendor_should_not_be_able_to_register_into_the_system_and_vendor_should_get_a_validation_messages(List<String> errorMessage) throws Exception
    {
        try {
            Assert.assertTrue(verifyEmailResponse.getStatusCode() >= 400);
            errorResponseCommonForAll = gson().fromJson(verifyEmailResponse.body().prettyPrint(), ErrorResponseCommonForAll.class);
            Assert.assertEquals("error", errorResponseCommonForAll.getStatus());
            Assert.assertEquals(errorMessage.get(i), errorResponseCommonForAll.getError());
            Assert.assertTrue(errorResponseCommonForAll.getData() == null);
        }
        finally
        {
            i++;
            if(errorMessage.size()==i)
            {
                i=0;
                System.out.println("Now the value of i is changed : --- ("+i+")");
            }
        }

    }













    @When("^New Vendor request to get registered into the system by resend verification mail link$")
    public void new_Vendor_request_to_get_registered_into_the_system_by_resend_verification_mail_link(List<ResendVerificationMailRequestModel> list) throws Exception
    {
        list.get(0).setemail(emailID);
        resendVerificationEmailResponse=RegisterService.resendVerificationEmail(list);

    }

    @Then("^New Vendor should get message as a Mail Sent Successfully\\.$")
    public void new_Vendor_should_get_message_as_a_Mail_Sent_Successfully() throws Exception
    {
        Assert.assertTrue(resendVerificationEmailResponse.statusCode()==200);
        registerResponseModel = gson().fromJson(resendVerificationEmailResponse.body().prettyPrint(), RegisterResponseModel.class);
        Assert.assertEquals("ok", registerResponseModel.getStatus());
        Assert.assertTrue(registerResponseModel.getData().getToken() != null);
    }



}
