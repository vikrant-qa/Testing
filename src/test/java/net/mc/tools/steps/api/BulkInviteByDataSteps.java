package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.bulkInvite.request.BulkInviteByDataRequestModel;
import net.mc.tools.models.bulkInvite.request.Message;
import net.mc.tools.models.bulkInvite.request.MessageData;
import net.mc.tools.models.bulkInvite.request.SentBy;
import net.mc.tools.models.bulkInvite.response.BulkInviteByDataErrorResponseModel;
import net.mc.tools.models.respnseForAllModel.ErrorResponseCommonForAll;
import net.mc.tools.models.respnseForAllModel.ResponseCommonForAll;
import net.mc.tools.models.token.TokenMessageRequestModel;
import net.mc.tools.services.auth.BulkInviteByDataService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class BulkInviteByDataSteps {

    private Response json_Response;
    private ResponseCommonForAll responseCommonForAll;
    private BulkInviteByDataErrorResponseModel bulkInviteByDataErrorResponseModel;
    private BulkInviteByDataRequestModel object = new BulkInviteByDataRequestModel();
    private static ErrorResponseCommonForAll errorResponseCommonForAll;
    private String[] email;
    List<Message> message;
    List<MessageData> messageData;
    List<SentBy> sentby;
    private static int i=0;


    @When("^user enters email ids")
    public void userEnterDetailsOfEmails(List<String> emailList )
    {
      email  = emailList.toArray(new String[emailList.size()]);
    }

    @And("^user enters details of Message")
    public void userEnterDetailsOfMessage(List<Message> message)
    {
        this.message = message;
    }

    @And("^user enter details of messageData for list")
    public void userEnterDetailsOfMessagedata(List<MessageData> messageData)
    {
        this.messageData = messageData;
    }

    @And("^user enter details of sentBy")
    public void userEnterDetailsOfSentBy(List<SentBy> sentBy)
    {
        this.sentby = sentBy;
    }

    @Then("^invite should be sent$")
    public void inviteShouldBeSent()
    {
        Assert.assertTrue(json_Response.getStatusCode() == 200);
        responseCommonForAll = gson().fromJson(json_Response.body().prettyPrint(), ResponseCommonForAll.class);
        Assert.assertEquals("ok" , responseCommonForAll.getStatus());
        Assert.assertTrue(responseCommonForAll.getData()==true);
    }


    @Then("^invite should not be sent and user should get validation message$")
    public void invite_should_not_be_sent_and_user_should_get_validation_message(List<String> errorMessage)
    {
        System.out.println("first i value is "+i);
        json_Response.body().prettyPrint();
            try
            {
                System.out.println(errorMessage.get(i));
                Assert.assertTrue(json_Response.getStatusCode() >= 400);
                errorResponseCommonForAll=gson().fromJson(json_Response.body().prettyPrint(),ErrorResponseCommonForAll.class);
                Assert.assertEquals("error",errorResponseCommonForAll.getStatus());
                Assert.assertEquals(errorMessage.get(i),errorResponseCommonForAll.getError());
                Assert.assertTrue(errorResponseCommonForAll.getData()==null);
            }finally
            {
                i++;
                if(errorMessage.size()==i)
                {
                  i=0;
                  System.out.println("i value in updated at last"+i);
                }
            }

    }

    @And("^user make a request to send bulk invite to vendor by data")
    public void user_make_a_request_to_send_bulk_invite_to_vendor_by_data()
    {
        object_Initialisation_method();
        json_Response=BulkInviteByDataService.bulkInviteByData(object,LoginSteps.token);
    }

    @When("^user make a request to send bulk invitation to vendor by data with incorrect or blank token field in form of without login credentials$")
    public void user_make_a_request_to_send_bulk_invitation_to_vendor_by_data_with_incorrect_or_blank_token_field_in_form_of_without_login_credentials(List<TokenMessageRequestModel> tokenMessageRequestModelList) throws Exception
    {
        object_Initialisation_method();
        System.out.println(" tokenMessage ---("+tokenMessageRequestModelList.get(0).gettoken()+")");
        json_Response=BulkInviteByDataService.bulkInviteByData(object,tokenMessageRequestModelList.get(0).gettoken());
    }

    public void object_Initialisation_method()
    {

        if(email[0].isEmpty())
        {
            object.setEmails(null);
        }
        else
        {
            object.setEmails(email);
        }

        if(message.get(0).getMessage().isEmpty()&&message.get(0).getSubject().isEmpty())
        {
            object.setMessage(null);
        }else
        {
            object.setMessage(message.get(0));
        }

        if(sentby.get(0).getType().isEmpty()&&sentby.get(0).getUserid().isEmpty())
        {
            object.setSentBy(null);
        }else
        {
            object.setSentBy(sentby.get(0));
        }

        if(messageData.get(0).getStoreName().isEmpty()&&messageData.get(0).getUrl().isEmpty())
        {
            object.setSentBy(null);
        }else
        {
            object.setMessageData(messageData.get(0));
        }
    }


}