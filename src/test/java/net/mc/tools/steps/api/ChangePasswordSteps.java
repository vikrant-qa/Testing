package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.change_Password.reponse.Change_Password_Error_Response;
import net.mc.tools.models.change_Password.reponse.Change_Password_Response;
import net.mc.tools.models.change_Password.request.Change_Password_Request;
import net.mc.tools.models.login.response.LoginResponseModel;
import net.mc.tools.services.auth.ChangePasswordService;
import org.junit.Assert;

import java.util.List;


public class ChangePasswordSteps
{
    LoginSteps loginSteps;
    UpdateCommissionSteps updateCommissionSteps;
    private Response var_Response;
    private Change_Password_Response var_change_password_response;
    private Change_Password_Error_Response var_change_password_error_response;
    private LoginResponseModel var_login_response;
    private  Boolean flag=true;
    private static  int i=0;


    @When("^User enter the valid old Password and valid new password$")
    public void user_enter_the_valid_old_Password_and_valid_new_password(List<Change_Password_Request> Password_request) throws Exception
    {
        if(Password_request.get(0).get_token()==null)
        {
            Password_request.get(0).set_token(LoginSteps.token);
        }

        System.out.println(Password_request.get(0).get_password());
        System.out.println(Password_request.get(0).get_token());
        System.out.println(Password_request.get(0).get_newPassword());

        var_Response= ChangePasswordService.Change_Password_Request_with_Token(Password_request,LoginSteps.token);

    }



    @Then("^Password change successfully and user got message ok recieved$")
    public void password_change_successfully_and_user_got_message_ok_recieved() throws Exception
    {

        Assert.assertTrue(var_Response.getStatusCode()==200);
        var_change_password_response= ChangePasswordService.gson_method().fromJson(var_Response.body().prettyPrint(), Change_Password_Response.class);
        Assert.assertEquals("ok",var_change_password_response.get_status());
        Assert.assertEquals("true",var_change_password_response.get_data());


    }


    @When("^User enter the wrong/incorrect Password details for change password request$")
    public void user_enter_the_wrong_incorrect_Password_details_for_change_password_request(List<Change_Password_Request> password_request) throws Exception
    {
        if (password_request.get(0).get_token()==null)
        {
            password_request.get(0).set_token(LoginSteps.token);
        }

        loginSteps.log.info(password_request.get(0).get_newPassword());
        loginSteps.log.info(password_request.get(0).get_password());
        loginSteps.log.info(password_request.get(0).get_token());

        var_Response=ChangePasswordService.Change_Password_Request_with_Token(password_request,LoginSteps.token);

    }

    @Then("^user will not able to change password and user should get validation messages$")
    public void user_will_not_able_to_change_password_and_user_should_get_validation_messages(List<String> message) throws Exception
    {

        if(var_Response.getStatusCode()>=400)
        {
            Assert.assertTrue(var_Response.statusCode()>=400);
            var_change_password_error_response=ChangePasswordService.gson_method().fromJson(var_Response.body().prettyPrint(),Change_Password_Error_Response.class);
            Assert.assertEquals("error",var_change_password_error_response.get_status());
            Assert.assertEquals(null,var_change_password_error_response.get_data());
            loginSteps.log.info(var_change_password_error_response.get_error());
            Assert.assertEquals(message.get(i),var_change_password_error_response.get_error());
            i++;
        }
    }


}
