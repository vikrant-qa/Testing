package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.respnseForAllModel.ErrorResponseCommonForAll;
import net.mc.tools.models.token.TokenMessageRequestModel;
import net.mc.tools.models.updateVendorFieldsForSeller.Reponse.UpdateVendorFieldsForSellerResponse;
import net.mc.tools.models.updateVendorFieldsForSeller.Request.UpdateVendorFieldsForSellerRequest;
import net.mc.tools.services.auth.UpdateVendorFieldsForSellerService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.UpdateVendorFieldsForSellerService.gson;

public class UpdateVendorFieldsForSellerSteps
{
    private static Response updateResponse;
    private static List<UpdateVendorFieldsForSellerRequest> updateVendorFieldsForSellerRequestList;
    private static ErrorResponseCommonForAll errorResponseCommonForAll;
    private static TokenMessageRequestModel tokenMessageRequestModel;
    private static UpdateVendorFieldsForSellerResponse updateVendorFieldsForSellerResponse;
    private static int i=0;

    @Then("^user click enable or disable button to update for Brand information, Shipping information and Payment information fields$")
    public void user_click_enable_or_disable_button_to_update_for_Brand_information_Shipping_information_and_Payment_information_fields(List<UpdateVendorFieldsForSellerRequest> updateVendorFieldsForSellerRequestList) throws Exception
    {
     this.updateVendorFieldsForSellerRequestList=updateVendorFieldsForSellerRequestList;
    }

    @Then("^user make a request to update the vendor fields by way of click on submit button$")
    public void user_make_a_request_to_update_the_vendor_fields_by_way_of_click_on_submit_button() throws Exception
    {
     updateResponse= UpdateVendorFieldsForSellerService.UpdateVendorFieldsForSeller_with_Token(updateVendorFieldsForSellerRequestList,LoginSteps.token);
    }

    @Then("^user should be able to update the vendor fields that he requested$")
    public void user_should_be_able_to_update_the_vendor_fields_that_he_requested() throws Exception
    {
        //for(1=0;i<=coustomfiel.length)
        //Assert.assertTrue(updateResponse.getIspayment[0]);
        updateResponse.body().prettyPrint();
        Assert.assertTrue(updateResponse.getStatusCode()==200);
        updateVendorFieldsForSellerResponse=gson().fromJson(updateResponse.body().prettyPrint(),UpdateVendorFieldsForSellerResponse.class);
        Assert.assertEquals("ok",updateVendorFieldsForSellerResponse.getStatus());
        Assert.assertEquals(updateVendorFieldsForSellerRequestList.get(0).getIsPayment(),updateVendorFieldsForSellerResponse.getData().getIsPayment());
        Assert.assertEquals(updateVendorFieldsForSellerRequestList.get(0).getIsBranding(),updateVendorFieldsForSellerResponse.getData().getIsBranding());
        Assert.assertEquals(updateVendorFieldsForSellerRequestList.get(0).getIsShipping(),updateVendorFieldsForSellerResponse.getData().getIsShipping());

    }
    @Then("^user should not be able to update the vendor field the he requested and the user should get a verification error message$")
    public void user_should_not_be_able_to_update_the_vendor_field_the_he_requested_and_the_user_should_get_a_verification_error_message(List<String> errorMessage) throws Exception
    {
        Assert.assertTrue(updateResponse.getStatusCode()>=400);
        errorResponseCommonForAll=gson().fromJson(updateResponse.body().prettyPrint(),ErrorResponseCommonForAll.class);
        Assert.assertEquals("error",errorResponseCommonForAll.getStatus());
        Assert.assertTrue(errorResponseCommonForAll.getData()==null);
        Assert.assertEquals(errorMessage.get(0),errorResponseCommonForAll.getError());
    }

    @When("^user make a request to update the vendor fields with Incorrect or blank token field in form of without login credentials$")
    public void user_make_a_request_to_update_the_vendor_fields_with_Incorrect_or_blank_token_field_in_form_of_without_login_credentials(List<TokenMessageRequestModel> tokenMessageRequestModelList) throws Exception
    {

        System.out.println(" tokenMessage ---("+tokenMessageRequestModelList.get(0).gettoken()+")");
        updateResponse= UpdateVendorFieldsForSellerService.UpdateVendorFieldsForSeller_with_Token(updateVendorFieldsForSellerRequestList,tokenMessageRequestModelList.get(0).gettoken());

    }



}
