package net.mc.tools.steps.api;

import com.google.gson.Gson;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.token.TokenMessageRequestModel;
import net.mc.tools.models.updateprofileofSupplier.request.UpdateprofileofSupplierRequestModel;
import net.mc.tools.models.updateprofileofSupplier.response.UpdateprofileofSupplierErrorResponseModel;
import net.mc.tools.models.updateprofileofSupplier.response.UpdateprofileofSupplierResponseModel;
import net.mc.tools.services.auth.UpdateprofileofSupplierService;

import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class UpdateprofileofSupplierSteps
{
    private static Response updateresponse;
    UpdateprofileofSupplierResponseModel updateprofileofSupplierResponseModel;
    UpdateprofileofSupplierErrorResponseModel updateprofileofSupplierErrorResponseModel;
    private static int i=0,j=0,k=0;
    private static List<UpdateprofileofSupplierRequestModel> updateprofileList;

    @Then("^User make a request to change the profile of their associated Vendor$")
    public void user_make_a_request_to_change_the_profile_of_their_associated_Vendor(List<UpdateprofileofSupplierRequestModel> list) throws Exception
    {
        if(list.get(0).getfirstName().equals(null))
        {
            list.get(0).setfirstName("");
        }
        System.out.println(" BrandName is --  ("+list.get(0).getbrandName()+")first Name is --   ("+list.get(0).getfirstName()+") Last Name is    ("+list.get(0).getlastName()+")Phone number is   ("+list.get(0).getphoneNumber()+")Id is--("+list.get(0).getid()+")Id is--("+list.get(0).getid()+")");

        updateresponse = UpdateprofileofSupplierService.UpdateprofileRequest(list,LoginSteps.token);
    }
    @Then("^User is able to change the profile successfully and should get a message as a Profile updated successfully$")
    public void user_is_able_to_change_the_profile_successfully_and_should_get_a_message_as_a_Profile_updated_successfully() throws Exception
    {
        Assert.assertTrue(updateresponse.statusCode()==200);
        updateprofileofSupplierResponseModel=gson().fromJson(updateresponse.body().prettyPrint(),UpdateprofileofSupplierResponseModel.class);
        Assert.assertEquals("true",updateprofileofSupplierResponseModel.getdata());
        Assert.assertEquals("ok",updateprofileofSupplierResponseModel.getStatus());
    }

    @Then("^user will not able to change profile and user should get validation messages$")
    public void user_will_not_able_to_change_profile_and_user_should_get_validation_messages(List<String> message) throws Exception
    {
        updateresponse.body().prettyPrint();
        Assert.assertTrue(updateresponse.statusCode()>400);
        updateprofileofSupplierErrorResponseModel=gson().fromJson(updateresponse.body().prettyPrint(),UpdateprofileofSupplierErrorResponseModel.class);
        Assert.assertEquals(message.get(i),updateprofileofSupplierErrorResponseModel.getError());
        Assert.assertEquals("error",updateprofileofSupplierErrorResponseModel.getStatus());
        Assert.assertTrue(updateprofileofSupplierErrorResponseModel.getdata()==null);
        i++;
    }

    @When("^user make a request to change profile of vendor with Incorrect/blank token field in form of without login credentials$")
    public void user_make_a_request_to_change_profile_of_vendor_with_Incorrect_blank_token_field_in_form_of_without_login_credentials(List<TokenMessageRequestModel> tokenMessage1) throws Exception
    {
        System.out.println("   Pass Token is :  ("+tokenMessage1.get(0).gettoken()+")     ");
        updateresponse = UpdateprofileofSupplierService.UpdateprofileRequest(updateprofileList, tokenMessage1.get(0).gettoken());
    }

    @When("^User make a request to change the profile of their associated Vendor with Incorrect Token$")
    public void user_make_a_request_to_change_the_profile_of_their_associated_Vendor_with_Incorrect_Token(List<UpdateprofileofSupplierRequestModel> list) throws Exception
    {
        updateprofileList=list;
    }

    @Then("^user will not able to change profile and user should get validation messages for incorrect/blank token$")
    public void user_will_not_able_to_change_profile_and_user_should_get_validation_messages_for_incorrect_blank_token() throws Exception
    {

        Assert.assertTrue(updateresponse.statusCode()>400);
        updateprofileofSupplierErrorResponseModel=gson().fromJson(updateresponse.body().prettyPrint(),UpdateprofileofSupplierErrorResponseModel.class);
        Assert.assertEquals("Invalid token provided",updateprofileofSupplierErrorResponseModel.getError());
        Assert.assertEquals("error",updateprofileofSupplierErrorResponseModel.getStatus());
        Assert.assertTrue(updateprofileofSupplierErrorResponseModel.getdata()==null);
        j++;

    }
}
