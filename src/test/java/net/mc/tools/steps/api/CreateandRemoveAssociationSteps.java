package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.createandRemoveAssociation.CreateandRemoveAssociationRequest.CreateAssociationRequest;
import net.mc.tools.models.createandRemoveAssociation.CreateandRemoveAssociationRequest.RemoveAssociationRequest;
import net.mc.tools.models.createandRemoveAssociation.CreateandRemoveAssociationResponse.CreateandRemoveAssociationErrorResponse;
import net.mc.tools.models.createandRemoveAssociation.CreateandRemoveAssociationResponse.CreateandRemoveAssociationResponse;
import net.mc.tools.models.token.TokenMessageRequestModel;
import net.mc.tools.services.auth.CreateandRemoveAssociationService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.CreateandRemoveAssociationService.gson;

public class CreateandRemoveAssociationSteps
{
    private static Response responseAssociation;
    private CreateAssociationRequest createAssociationRequest;
    private RemoveAssociationRequest removeAssociationRequest;
    private static CreateandRemoveAssociationResponse createandRemoveAssociationResponse;
    private static CreateandRemoveAssociationErrorResponse createandRemoveAssociationErrorResponse;
    private static List<CreateAssociationRequest> createAssociationRequestList;
    private static List<RemoveAssociationRequest> removeAssociationRequests;
    private static int i=0,j=0,k=0;

    @Then("^user select the vendor and seller by way of entering the vendor id and seller id for create association$")
    public void user_select_the_vendor_and_seller_by_way_of_entering_the_vendor_id_and_seller_id_for_create_association(List<CreateAssociationRequest> list) throws Exception
    {
        createAssociationRequestList=list;
    }


    @Then("^user make a request to create a association between vendor and seller$")
    public void user_make_a_request_to_create_a_association_between_vendor_and_seller() throws Exception
    {
        responseAssociation= CreateandRemoveAssociationService.createAssociationrequestWithToken(createAssociationRequestList,LoginSteps.token);
    }


    @Then("^user should be able to create a association and user should get a message as a Association Created$")
    public void user_should_be_able_to_create_a_association_and_user_should_get_a_message_as_a_Association_Created() throws Exception
    {
        responseAssociation.body().prettyPrint();
        Assert.assertTrue(responseAssociation.statusCode()==200);
        createandRemoveAssociationResponse=gson().fromJson(responseAssociation.body().prettyPrint(),CreateandRemoveAssociationResponse.class);
        Assert.assertEquals("true",createandRemoveAssociationResponse.getData());
        Assert.assertEquals("ok",createandRemoveAssociationResponse.getStatus());
    }
    @Then("^user select the vendor and seller by way of entering the vendor id and seller id for remove association$")
    public void user_select_the_vendor_and_seller_by_way_of_entering_the_vendor_id_and_seller_id_for_remove_association(List<RemoveAssociationRequest> List1) throws Exception
    {
        removeAssociationRequests=List1;
        System.out.println("Vendor Object Id is "+removeAssociationRequests.get(0).get_id()+"Seller Object Id is "+removeAssociationRequests.get(0).getseller());
    }


    @Then("^user make a request to remove a association between vendor and seller$")
    public void user_make_a_request_to_remove_a_association_between_vendor_and_seller() throws Exception
    {
      responseAssociation=CreateandRemoveAssociationService.removeAssociationrequestWithToken(removeAssociationRequests,LoginSteps.token);
    }

    @Then("^user should be able to remove a association and user should get a message as a Associations removed successfully$")
    public void user_should_be_able_to_remove_a_association_and_user_should_get_a_message_as_a_Associations_removed_successfully() throws Exception
    {
        Assert.assertTrue(responseAssociation.statusCode()==200);
        createandRemoveAssociationResponse=gson().fromJson(responseAssociation.body().prettyPrint(),CreateandRemoveAssociationResponse.class);
        Assert.assertEquals("true",createandRemoveAssociationResponse.getData());
        Assert.assertEquals("ok",createandRemoveAssociationResponse.getStatus());
    }

    @Then("^user should not be able to remove a association and user should get a message as a Invalid user provided$")
    public void user_should_not_be_able_to_remove_a_association_and_user_should_get_a_message_as_a_Invalid_user_provided() throws Exception
    {
        Assert.assertTrue(responseAssociation.getStatusCode()>=400);
        createandRemoveAssociationErrorResponse=gson().fromJson(responseAssociation.body().prettyPrint(),CreateandRemoveAssociationErrorResponse.class);
        Assert.assertEquals("error",createandRemoveAssociationErrorResponse.getStatus());
        Assert.assertEquals("Invalid user provided",createandRemoveAssociationErrorResponse.getError());
        Assert.assertTrue(createandRemoveAssociationErrorResponse.getData()==null);
    }
    @Then("^user should not be able to create a association and user should get a message as a User is not authorized to perform this action$")
    public void user_should_not_be_able_to_create_a_association_and_user_should_get_a_message_as_a_User_is_not_authorized_to_perform_this_action() throws Exception
    {
        Assert.assertTrue(responseAssociation.getStatusCode()>=400);
        createandRemoveAssociationErrorResponse=gson().fromJson(responseAssociation.body().prettyPrint(),CreateandRemoveAssociationErrorResponse.class);
        Assert.assertEquals("error",createandRemoveAssociationErrorResponse.getStatus());
        Assert.assertEquals("User is not authorized to perform this action",createandRemoveAssociationErrorResponse.getError());
        Assert.assertTrue(createandRemoveAssociationErrorResponse.getData()==null);
    }

    @Then("^user should not be able to create a association without follow any field validation then user should get a validation message$")
    public void user_should_not_be_able_to_create_a_association_without_vendor_or_seller_and_user_should_get_a_validation_message(List<String> errorList) throws Exception
    {
        Assert.assertTrue(responseAssociation.getStatusCode()>=400);
        createandRemoveAssociationErrorResponse=gson().fromJson(responseAssociation.body().prettyPrint(),CreateandRemoveAssociationErrorResponse.class);
        Assert.assertEquals("error",createandRemoveAssociationErrorResponse.getStatus());
        Assert.assertEquals(errorList.get(i),createandRemoveAssociationErrorResponse.getError());
        Assert.assertTrue(createandRemoveAssociationErrorResponse.getData()==null);
        i++;
    }

    @Then("^user should not be able to remove a association without follow any field validation then user should get a  validation message$")
    public void user_should_not_be_able_to_remove_a_association_without_vendor_or_seller_and_user_should_get_a_validation_message(List<String> errorList) throws Exception
    {
        Assert.assertTrue(responseAssociation.getStatusCode()>=400);
        createandRemoveAssociationErrorResponse=gson().fromJson(responseAssociation.body().prettyPrint(),CreateandRemoveAssociationErrorResponse.class);
        Assert.assertEquals("error",createandRemoveAssociationErrorResponse.getStatus());
        Assert.assertEquals(errorList.get(j),createandRemoveAssociationErrorResponse.getError());
        Assert.assertTrue(createandRemoveAssociationErrorResponse.getData()==null);
        j++;
    }

    @Given("^user make a request to create a association between vendor and seller while they already have a Association$")
    public void user_make_a_request_to_create_a_association_between_vendor_and_seller_while_they_already_have_a_Association() throws Exception
    {
        responseAssociation= CreateandRemoveAssociationService.createAssociationrequestWithToken(createAssociationRequestList,LoginSteps.token);

    }

    @Then("^user should not be able to create a association and user should get a validation message as a Association already exists$")
    public void user_should_not_be_able_to_create_a_association_and_user_should_get_a_validation_message_as_a_Association_already_exists() throws Exception
    {
        Assert.assertTrue(responseAssociation.getStatusCode()>=400);
        createandRemoveAssociationErrorResponse=gson().fromJson(responseAssociation.body().prettyPrint(),CreateandRemoveAssociationErrorResponse.class);
        Assert.assertEquals("error",createandRemoveAssociationErrorResponse.getStatus());
        Assert.assertEquals("Association already exists",createandRemoveAssociationErrorResponse.getError());
        Assert.assertTrue(createandRemoveAssociationErrorResponse.getData()==null);
    }

    @When("^user make a request to remove association with Incorrect/blank token field in form of without login credentials$")
    public void user_make_a_request_to_remove_association_with_Incorrect_blank_token_field_in_form_of_without_login_credentials(List<TokenMessageRequestModel> tokenmessage) throws Exception
    {
        System.out.println("   Pass Token is :  ("+tokenmessage.get(0).gettoken()+")     ");
        responseAssociation=CreateandRemoveAssociationService.removeAssociationrequestWithToken(removeAssociationRequests,tokenmessage.get(0).gettoken());
        k++;
    }

    @Then("^user should not be able to remove a association without follow any field validation then user should get a  validation message for Incorrect/blank token$")
    public void user_should_not_be_able_to_remove_a_association_without_follow_any_field_validation_then_user_should_get_a_validation_message_for_Incorrect_blank_token(List<String> Message) throws Exception
    {
        Assert.assertTrue(responseAssociation.getStatusCode()>=400);
        createandRemoveAssociationErrorResponse=gson().fromJson(responseAssociation.body().prettyPrint(),CreateandRemoveAssociationErrorResponse.class);
        Assert.assertEquals("error",createandRemoveAssociationErrorResponse.getStatus());
        Assert.assertEquals("Invalid token provided",createandRemoveAssociationErrorResponse.getError());
        Assert.assertTrue(createandRemoveAssociationErrorResponse.getData()==null);

    }

}
