package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.removePaymentDetailsForSellerAndVendor.RemovePaymentDetailsForSellerAndVendorRequest.RemovePaymentDetailsForSellerAndVendorRequest;
import net.mc.tools.models.respnseForAllModel.ErrorResponseCommonForAll;
import net.mc.tools.models.respnseForAllModel.ResponseCommonForAll;
import net.mc.tools.models.token.TokenMessageRequestModel;
import net.mc.tools.services.auth.RemovePaymentDetailsForSellerAndVendorService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RemovePaymentDetailsForSellerAndVendorService.gson;

public class RemovePaymentDetailsForSellerAndVendorSteps
{
    private static Response response;
    private static ResponseCommonForAll responseCommonForAll;
    private static ErrorResponseCommonForAll errorResponseCommonForAll;
    private static int i=-1;
    private static String applyToken=LoginSteps.token;

    @Then("^user enter the payment method and request to remove the that payment method in form of clicking on disconnect button$")
    public void user_enter_the_payment_method_and_request_to_remove_the_that_payment_method_in_form_of_clicking_on_disconnect_button(List<RemovePaymentDetailsForSellerAndVendorRequest> removePaymentDetailsForSellerAndVendorRequestList) throws Exception
    {

        response = RemovePaymentDetailsForSellerAndVendorService.RemovePaymentDetailsWithToken(removePaymentDetailsForSellerAndVendorRequestList,applyToken);
    }

    @Then("^user should be able to remove payment method successfully that he requested$")
    public void user_should_be_able_to_remove_payment_method_successfully_that_he_requested() throws Exception
    {

        Assert.assertTrue(response.getStatusCode()==200);
        responseCommonForAll=gson().fromJson(response.body().prettyPrint(),ResponseCommonForAll.class);
        Assert.assertEquals("true",responseCommonForAll.getData());
        Assert.assertEquals("ok",responseCommonForAll.getStatus());
    }

    @Then("^user should not be able to remove payment method that he requested and user should get a validation message as a$")
    public void user_should_not_be_able_to_remove_payment_method_that_he_requested_and_user_should_get_a_validation_message_as_a(List<String> errorMessage) throws Exception
    {
        i++;
        Assert.assertTrue(response.getStatusCode()>=400);
        errorResponseCommonForAll=gson().fromJson( response.body().prettyPrint(),ErrorResponseCommonForAll.class);
        Assert.assertEquals("error",errorResponseCommonForAll.getStatus());
        Assert.assertEquals(errorMessage.get(i),errorResponseCommonForAll.getError());
        Assert.assertTrue(errorResponseCommonForAll.getData()==null);
    }

    @When("^user make a request to remove payment method with Incorrect/blank token field in form of without login credentials$")
    public void user_make_a_request_to_remove_payment_method_with_Incorrect_blank_token_field_in_form_of_without_login_credentials(List<TokenMessageRequestModel> tokenMessageRequestModelList) throws Exception
    {
        applyToken=tokenMessageRequestModelList.get(0).gettoken();
    }


}
