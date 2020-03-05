package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.shipping.request.UpdateShippingBandRequestModel;
import net.mc.tools.models.shipping.request.UpdateShippingOfferRequestModel;
import net.mc.tools.models.shipping.response.UpdateShippingBandErrorResponseModel;
import net.mc.tools.models.shipping.response.UpdateShippingBandResponseModel;
import net.mc.tools.models.shipping.response.UpdateShippingOfferErrorResponseModel;
import net.mc.tools.models.shipping.response.UpdateShippingOfferResponseModel;
import net.mc.tools.services.auth.UpdateShippingBandService;
import net.mc.tools.services.auth.UpdateShippingOfferService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class UpdateShippingBandSteps {

    public static  String token = null;
    private Response response;
    private UpdateShippingBandResponseModel updateShippingBandResponseModel;
    private UpdateShippingBandErrorResponseModel updateShippingBandErrorResponseModel;
    private static int i;

    @When("^User enters shipping band details to update$")
    public void userEnterUpdateShippingOfferId(List<UpdateShippingBandRequestModel> updateShippingOfferRequestModels)  {

        response = UpdateShippingBandService.req(updateShippingOfferRequestModels,LoginSteps.token);

    }

    @Then("^User should be able to update shipping band for seller$")
    public void userSuccessfullyUpdateShippingOffer()  {
        Assert.assertTrue(response.getStatusCode() == 200);
        updateShippingBandResponseModel = gson().fromJson(response.body().prettyPrint(), UpdateShippingBandResponseModel.class);
        Assert.assertEquals("ok" , updateShippingBandResponseModel.getStatus());
        Assert.assertEquals("true", updateShippingBandResponseModel.getData());
    }

    @Then("^User should not be able to update shipping band for seller and validate error message$")
    public void userValidateErrorMsgUpdateOffer(List<String> message)  {
        Assert.assertTrue(response.getStatusCode() == 422);
        updateShippingBandErrorResponseModel = gson().fromJson(response.body().prettyPrint(), UpdateShippingBandErrorResponseModel.class);
        Assert.assertEquals("error" , updateShippingBandErrorResponseModel.getStatus());
        Assert.assertTrue(updateShippingBandErrorResponseModel.getData() == null);
        Assert.assertEquals(message.get(i), updateShippingBandErrorResponseModel.getError());
        i++;
    }
}