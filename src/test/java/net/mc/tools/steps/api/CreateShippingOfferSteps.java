package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.shipping.request.CreateShippingOfferRequestModel;
import net.mc.tools.models.shipping.request.ShippingRuleForSellerRequestModel;
import net.mc.tools.models.shipping.response.CreateShippingOfferErrorResponseModel;
import net.mc.tools.models.shipping.response.CreateShippingOfferResponseModel;
import net.mc.tools.models.shipping.response.ShippingRuleForSellerErrorResponseModel;
import net.mc.tools.models.shipping.response.ShippingRuleForSellerResponseModel;
import net.mc.tools.services.auth.CreateShippingOfferService;
import net.mc.tools.services.auth.ShippingRuleForSellerService;
import net.mc.tools.utilities.RandomGenerator;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class CreateShippingOfferSteps {

    public static  String token = null;
    private Response response;
    private CreateShippingOfferResponseModel createShippingOfferResponseModel;
    private CreateShippingOfferErrorResponseModel createShippingOfferErrorResponseModel;
    private static int i = 0;

    @When("^user enters details for create shipping offer for seller$")
    public void userEnterDetailsForCreateShippingOffer(List<CreateShippingOfferRequestModel> createShippingOfferRequestModels)  {
        response = CreateShippingOfferService.req(createShippingOfferRequestModels, LoginSteps.token);

    }

    @Then("^User should be able to create shipping offer for seller$")
    public void userSuccessfullyCreateShippingOffer()  {
        Assert.assertTrue(response.getStatusCode() == 200);
        createShippingOfferResponseModel = gson().fromJson(response.body().prettyPrint(), CreateShippingOfferResponseModel.class);
        Assert.assertEquals("ok" , createShippingOfferResponseModel.getStatus());
        Assert.assertEquals("true", createShippingOfferResponseModel.getData());
    }

    @Then("^User should not be able to create offer for seller and get error message$")
    public void userValidateErrorMsgForCreateShippingOffer(List<String> message)  {
        Assert.assertTrue(response.getStatusCode() == 422);
        createShippingOfferErrorResponseModel = gson().fromJson(response.body().prettyPrint(), CreateShippingOfferErrorResponseModel.class);
        Assert.assertEquals("error" , createShippingOfferErrorResponseModel.getStatus());
        Assert.assertTrue(createShippingOfferErrorResponseModel.getData() == null);
        Assert.assertEquals(message.get(i), createShippingOfferErrorResponseModel.getError());
        i++;
    }
}