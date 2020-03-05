package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.shipping.request.DeleteShippingOfferRequestModel;
import net.mc.tools.models.shipping.request.UpdateShippingOfferRequestModel;
import net.mc.tools.models.shipping.response.DeleteShippingOfferErrorResponseModel;
import net.mc.tools.models.shipping.response.DeleteShippingOfferResponseModel;
import net.mc.tools.models.shipping.response.UpdateShippingOfferErrorResponseModel;
import net.mc.tools.models.shipping.response.UpdateShippingOfferResponseModel;
import net.mc.tools.services.auth.DeleteShippingOfferService;
import net.mc.tools.services.auth.UpdateShippingOfferService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class UpdateShippingOfferSteps {

    public static  String token = null;
    private Response response;
    private UpdateShippingOfferResponseModel updateShippingOfferResponseModel;
    private UpdateShippingOfferErrorResponseModel updateShippingOfferErrorResponseModel;
    private static int i;

    @When("^User enters shipping details to update$")
    public void userEnterUpdateShippingOfferId(List<UpdateShippingOfferRequestModel> updateShippingOfferRequestModels)  {

        response = UpdateShippingOfferService.req(updateShippingOfferRequestModels,LoginSteps.token);

    }

    @Then("^User should be able to update shipping offer for seller$")
    public void userSuccessfullyUpdateShippingOffer()  {
        Assert.assertTrue(response.getStatusCode() == 200);
        updateShippingOfferResponseModel = gson().fromJson(response.body().prettyPrint(), UpdateShippingOfferResponseModel.class);
        Assert.assertEquals("ok" , updateShippingOfferResponseModel.getStatus());
        Assert.assertEquals("true", updateShippingOfferResponseModel.getData());
    }

    @Then("^User should not be able to update shipping offer for seller and get validation erro message$")
    public void userValidateErrorMsgUpdateOffer(List<String> message)  {
        Assert.assertTrue(response.getStatusCode() == 422);
        updateShippingOfferErrorResponseModel = gson().fromJson(response.body().prettyPrint(), UpdateShippingOfferErrorResponseModel.class);
        Assert.assertEquals("error" , updateShippingOfferErrorResponseModel.getStatus());
        Assert.assertTrue(updateShippingOfferErrorResponseModel.getData() == null);
        Assert.assertEquals(message.get(i), updateShippingOfferErrorResponseModel.getError());
        i++;
    }
}