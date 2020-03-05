package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.login.request.LoginRequestModel;
import net.mc.tools.models.login.response.LoginErrorResponseModel;
import net.mc.tools.models.login.response.LoginResponseModel;
import net.mc.tools.services.auth.LoginService;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class LoginSteps
{

    public static String token=null;
    public static Response json_Response;
    private LoginResponseModel loginResponseModel;
    private LoginErrorResponseModel loginErrorResponseModel;
    public static Logger log= LoggerFactory.getLogger(LoginSteps.class);

    @When("^User enters email and password$")
    public void userIsEntersValidEmailAndPassword(List<LoginRequestModel> loginRequest)
    {
        json_Response = LoginService.login(loginRequest);
    }

    @Then("^user should be able to login to the system$")
    public void userShouldBeAbleToLoginToTheSystem()  {
        Assert.assertTrue(json_Response.getStatusCode() == 200);
        loginResponseModel = gson().fromJson(json_Response.body().prettyPrint(), LoginResponseModel.class);
        Assert.assertEquals("ok" , loginResponseModel.getStatus());
        Assert.assertEquals("true", loginResponseModel.getData().getData());
        Assert.assertTrue(loginResponseModel.getData().getToken() != null);
        token=loginResponseModel.getData().getToken();
        System.out.println("value of token is "+token);
    }

    @Then("^user should not be able to login to system$")
    public void userShouldNotBeAbleToLoginToTheSystem()  {
        Assert.assertTrue(json_Response.getStatusCode() == 422);
        loginErrorResponseModel = gson().fromJson(json_Response.body().prettyPrint(), LoginErrorResponseModel.class);
        Assert.assertEquals("error" , loginErrorResponseModel.getStatus());
        Assert.assertTrue(loginErrorResponseModel.getData() == null);
        Assert.assertEquals("Incorrect credentials provided", loginErrorResponseModel.getError());

    }

    @Then("^user should get the validation message$")
    public void userShouldGetValidationMessage()  {
        Assert.assertTrue(json_Response.getStatusCode() == 422);
        loginErrorResponseModel = gson().fromJson(json_Response.body().prettyPrint(), LoginErrorResponseModel.class);
        Assert.assertEquals("error" , loginErrorResponseModel.getStatus());
        Assert.assertTrue(loginErrorResponseModel.getData() == null);
        Assert.assertEquals("Email is required.", loginErrorResponseModel.getError());
    }

    @Then("^user should not be able to login to system with one field as blank$")
    public void user_should_not_be_able_to_login_to_system_with_one_field_as_blank()
    {
        Assert.assertTrue(json_Response.getStatusCode() == 422);
        loginErrorResponseModel = gson().fromJson(json_Response.body().prettyPrint(), LoginErrorResponseModel.class);
        Assert.assertEquals("error" , loginErrorResponseModel.getStatus());
        Assert.assertTrue(loginErrorResponseModel.getData() == null);
        Assert.assertEquals("Incorrect credentials provided", loginErrorResponseModel.getError());
    }

    @When("^User is able to log into application$")
    public void user_IsEntersValidEmailAndPassword(List<LoginRequestModel> loginRequestModel)
    {
        json_Response = LoginService.login(loginRequestModel);
        System.out.println("User id is : "+loginRequestModel.get(0).getEmail()+" Password is: "+loginRequestModel.get(0).getPassword());
    }

    @Then("^user should be able to login to the system and store token$")
    public void user_ShouldBeAbleToLoginToTheSystem()
     {
         try
         {
             if(json_Response.getStatusCode() == 200)
             {
                 Assert.assertTrue(json_Response.getStatusCode() == 200);
                 loginResponseModel = gson().fromJson(json_Response.body().prettyPrint(), LoginResponseModel.class);
                 Assert.assertEquals("ok", loginResponseModel.getStatus());
                 Assert.assertEquals("true", loginResponseModel.getData().getData());
                 Assert.assertTrue(loginResponseModel.getData().getToken() != null);
                 token = loginResponseModel.getData().getToken();
                 System.out.println("Now : User is able to use the system");
             }
             else
             {
               System.out.println("User is unable to login in the system");
             }
          }
         catch (Exception e)
         {
           e.printStackTrace();
         }
     }
}
