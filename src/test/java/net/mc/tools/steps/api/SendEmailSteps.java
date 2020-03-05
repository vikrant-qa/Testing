package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.sendEmailModel.request.SendEmailRequestModel;
import net.mc.tools.models.sendEmailModel.response.SendEmailErrorResponseModel;
import net.mc.tools.models.sendEmailModel.response.SendEmailResoponseModel;
import net.mc.tools.services.auth.SendEmailService;
import org.junit.Assert;
import static net.mc.tools.services.auth.RegisterService.gson;

import java.util.List;

public class SendEmailSteps
{
    private Response response;
    private SendEmailResoponseModel sendEmailResoponse;
    private SendEmailErrorResponseModel sendEmailErrorResponse;

    @When("^user enter the email-id,subject and message field with valid data$")
    public void user_enter_the_email_id_subject_and_message_field_with_valid_data(List<SendEmailRequestModel> sendEmailRequest) throws Exception
    {
     response= SendEmailService.sendemail(sendEmailRequest);

    }

    @Then("^Email sent successfully and user should get message as ok$")
    public void email_sent_successfully_and_user_should_get_message_as_ok() throws Exception
    {

        Assert.assertTrue(response.getStatusCode() == 200);
        sendEmailResoponse=gson().fromJson(response.body().prettyPrint(),SendEmailResoponseModel.class);
        Assert.assertEquals("true",sendEmailResoponse.getdata());
        Assert.assertEquals("ok",sendEmailResoponse.getStatus());


    }

    @When("^User enter the email-id,Subject and Message field as a blank$")
    public void user_enter_the_email_id_Subject_and_Message_field_as_a_blank(List<SendEmailRequestModel> sendEmailRequest) throws Exception
    {
        response= SendEmailService.sendemail(sendEmailRequest);
    }

    @Then("^Email not sent successfully and user got message error received$")
    public void email_not_sent_successfully_and_user_got_message_error_received() throws Exception
    {
        response.body().prettyPrint();
        Assert.assertTrue(response.getStatusCode() == 422);
        sendEmailErrorResponse=gson().fromJson(response.body().prettyPrint(),SendEmailErrorResponseModel.class);
        Assert.assertEquals("error",sendEmailErrorResponse.getStatus());
    }
}
