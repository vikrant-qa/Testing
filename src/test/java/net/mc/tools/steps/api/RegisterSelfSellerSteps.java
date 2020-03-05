package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.register.request.RegisterRequestModel;
import net.mc.tools.models.register.response.RegisterErrorResponseModel;
import net.mc.tools.models.register.response.RegisterResponseModel;
import net.mc.tools.models.register.response.VerifyEmailErrorResponseModel;
import net.mc.tools.models.register.response.VerifyEmailResponseModel;
import net.mc.tools.models.registerSelfSeller.registerSelfSellerRequest.RegisterSelfSellerRequestModel;
import net.mc.tools.models.respnseForAllModel.ErrorResponseCommonForAll;
import net.mc.tools.services.auth.RegisterSelfSellerService;
import net.mc.tools.services.auth.RegisterService;
import net.mc.tools.utilities.RandomGenerator;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class RegisterSelfSellerSteps
{
    private static Response json_Response,verifyEmailResponse,resendVerificationEmailResponse;
    private RegisterResponseModel registerResponseModel;
    private ErrorResponseCommonForAll errorResponseCommonForAll;
    private static List<RegisterSelfSellerRequestModel> registerSelfSellerRequestModels;
    private static int i=0;
    private static String emailID,tokenToBeUsed;

    @When("^New user enters the emaliId and password field for registration for seller$")
    public void new_user_enters_the_emaliId_and_password_field_for_registration_for_seller(List<RegisterSelfSellerRequestModel> registerRequestModels1) throws Exception
    {
        if (!registerRequestModels1.get(0).getEmail().isEmpty()){
            registerRequestModels1.get(0).setEmail(registerRequestModels1.get(0).getEmail()+ RandomGenerator.randomAlphanumeric(5)+"@mailinator.com");
        }
        this.registerSelfSellerRequestModels=registerRequestModels1;
    }

    @When("^User make a request to get registered into the system for seller$")
    public void user_make_a_request_to_get_registered_into_the_system_for_seller() throws Exception
    {
        System.out.println("The requester EmailId is -( "+registerSelfSellerRequestModels.get(0).getEmail()+" ) - and the password is -( "+registerSelfSellerRequestModels.get(0).getPassword()+" )");
        json_Response= RegisterSelfSellerService.createNewSeller(registerSelfSellerRequestModels);
    }

    @Then("^User should be registered successfully into the system for seller$")
    public void userShouldBeRegisteredSuccessfullyIntoTheSystem_for_seller()
    {
        Assert.assertTrue(json_Response.getStatusCode() == 200);
        registerResponseModel = gson().fromJson(json_Response.body().prettyPrint(), RegisterResponseModel.class);
        Assert.assertEquals("ok", registerResponseModel.getStatus());
        Assert.assertTrue(registerResponseModel.getData().getToken() != null);
        tokenToBeUsed=registerResponseModel.getData().getToken();
    }

    @Then("^The user will not be able to register on marketcube app for seller and the user should get a validation message$")
    public void the_user_will_not_be_able_to_register_on_marketcube_app_for_seller_and_the_user_should_get_a_validation_message(List<String> errorMessage) throws Exception
    {
        System.out.println("Before assertion used check what response we get-------------------------");
        json_Response.body().prettyPrint();
        System.out.println("********************************************************************************");
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


    @When("^seller enters the registered emaliId and password field for registration$")
    public void seller_enters_the_registered_emaliId_and_password_field_for_registration(List<RegisterSelfSellerRequestModel> registerRequestModels2) throws Exception
    {
        this.registerSelfSellerRequestModels=registerRequestModels2;
    }

    @When("^New user enters the emaliId and password field for seller registration$")
    public void new_user_enters_the_emaliId_and_password_field_for_seller_registration(List<RegisterSelfSellerRequestModel> registerRequestModels1) throws Exception
    {
        this.registerSelfSellerRequestModels=registerRequestModels1;
    }
}
