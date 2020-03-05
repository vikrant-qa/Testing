package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.shipping.request.ManageShippingDetailsRequestModel;
import net.mc.tools.models.shipping.request.ShippingRuleForSellerRequestModel;
import net.mc.tools.models.shipping.response.ManageShippingDetailsErrorResponseModel;
import net.mc.tools.models.shipping.response.ManageShippingDetailsResponseModel;
import net.mc.tools.models.shipping.response.ShippingRuleForSellerErrorResponseModel;
import net.mc.tools.models.shipping.response.ShippingRuleForSellerResponseModel;
import net.mc.tools.services.auth.ManageShippingDetailsService;
import net.mc.tools.services.auth.ShippingRuleForSellerService;
import net.mc.tools.utilities.RandomGenerator;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class ManageShippingDetailsSteps {

    public static  String token = null;
    private Response response;
    private ManageShippingDetailsResponseModel manageShippingDetailsResponseModel;
    private ManageShippingDetailsErrorResponseModel manageShippingDetailsErrorResponseModel;
    private static int i = 0;

    @When("^user enters manage shipping details$")
    public void userEnterManageShippingDetails(List<ManageShippingDetailsRequestModel> manageShippingDetailsRequestModels)  {
        	
            response = ManageShippingDetailsService.req(manageShippingDetailsRequestModels,LoginSteps.token);

    }

    @Then("^User should be able to manage shipping details successfully$")
    public void userSuccessfullyManageShippingDetails()  {
        Assert.assertTrue(response.getStatusCode() == 200);
        manageShippingDetailsResponseModel = gson().fromJson(response.body().prettyPrint(), ManageShippingDetailsResponseModel.class);
        Assert.assertEquals("ok" , manageShippingDetailsResponseModel.getStatus());
        Assert.assertEquals("true", manageShippingDetailsResponseModel.getData());
    }

    @Then("^User validates error messages for manage shipping details$")
    public void userValidateErrorMsgForCreateShippingRule(List<String> message)  {
        Assert.assertTrue(response.getStatusCode() == 422);
        manageShippingDetailsErrorResponseModel = gson().fromJson(response.body().prettyPrint(), ManageShippingDetailsErrorResponseModel.class);
        Assert.assertEquals("error" , manageShippingDetailsErrorResponseModel.getStatus());
        Assert.assertTrue(manageShippingDetailsErrorResponseModel.getData() == null);
        Assert.assertEquals(message.get(i), manageShippingDetailsErrorResponseModel.getError());
        i++;
    }
}