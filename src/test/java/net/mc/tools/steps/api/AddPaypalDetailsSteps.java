package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.addPaypalDetails.request.AddPaypalDetailsRequestModel;
import net.mc.tools.models.addPaypalDetails.response.AddPaypalDetailsErrorResponseModel;
import net.mc.tools.models.addPaypalDetails.response.AddPaypalDetailsResponseModel;
import net.mc.tools.services.auth.AddPaypalDetailsService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class AddPaypalDetailsSteps
{

    private String message;
    private static int i = 0;
    private Response response;
    private AddPaypalDetailsResponseModel addPaypalDetailsResponseModel;
    private AddPaypalDetailsErrorResponseModel addPaypalDetailsErrorResponseModel;

    @When("^user enters paypal detais for seller or vendor$")
    public void userAddPaypalDetails(List<AddPaypalDetailsRequestModel> addPaypalDetailsRequestModel)  {
            response = AddPaypalDetailsService.requestWithToken(addPaypalDetailsRequestModel,LoginSteps.token);
    }

    @Then("^user should be able to add paypal  details for any seller or vendor$")
    public void paypalDetailsShouldBeAdd()
    {
        Assert.assertTrue(response.getStatusCode() == 200);
        addPaypalDetailsResponseModel = gson().fromJson(response.body().prettyPrint(), AddPaypalDetailsResponseModel.class);
        Assert.assertEquals("ok" , addPaypalDetailsResponseModel.getStatus());
        Assert.assertEquals("true", addPaypalDetailsResponseModel.getData());

    }

    @And("^enter validation error message for paypal$")
    public void enterMessage(List<String> message){
        this.message = message.get(i);
        i++;
    }
    @Then("^user should not be able to add paypal  details for any seller or vendor$")
    public void paypalDetailsShouldNotBeAdd()  {
        Assert.assertTrue(response.getStatusCode() == 422);
        addPaypalDetailsErrorResponseModel = gson().fromJson(response.body().prettyPrint(), AddPaypalDetailsErrorResponseModel.class);
        Assert.assertEquals("error" , addPaypalDetailsErrorResponseModel.getStatus());
        Assert.assertEquals(message, addPaypalDetailsErrorResponseModel.getError());
        Assert.assertTrue(addPaypalDetailsErrorResponseModel.getData() == null);

    }
}
