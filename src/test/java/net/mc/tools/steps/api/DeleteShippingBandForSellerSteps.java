package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.shipping.request.DeleteShippingBandRequestModel;
import net.mc.tools.models.shipping.request.ShippingRuleForSellerRequestModel;
import net.mc.tools.models.shipping.response.DeleteShippingBandErrorResponseModel;
import net.mc.tools.models.shipping.response.DeleteShippingBandResponseModel;
import net.mc.tools.models.shipping.response.ShippingRuleForSellerErrorResponseModel;
import net.mc.tools.models.shipping.response.ShippingRuleForSellerResponseModel;
import net.mc.tools.services.auth.DeleteShippingBandService;
import net.mc.tools.services.auth.ShippingRuleForSellerService;
import net.mc.tools.utilities.RandomGenerator;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class DeleteShippingBandForSellerSteps {

    public static  String token = null;
    private Response response;
    private DeleteShippingBandResponseModel deleteShippingBandResponseModel;
    private DeleteShippingBandErrorResponseModel deleteShippingBandErrorResponseModel;

    @When("^User enters shippingBandId$")
    public void userEnterShippingBandId(List<DeleteShippingBandRequestModel> deleteShippingBandRequestModel)  {

        response = DeleteShippingBandService.req(deleteShippingBandRequestModel, LoginSteps.token);

    }

    @Then("^User should be able to delete shipping band for seller$")
    public void userSuccessfullyDeleteShippingBand()  {
        Assert.assertTrue(response.getStatusCode() == 200);
        deleteShippingBandResponseModel = gson().fromJson(response.body().prettyPrint(), DeleteShippingBandResponseModel.class);
        Assert.assertEquals("ok" , deleteShippingBandResponseModel.getStatus());
        Assert.assertEquals("true", deleteShippingBandResponseModel.getData());
    }

    @Then("^User should not be able to delete shipping band for seller$")
    public void userValidateErrorMsg()  {
        Assert.assertTrue(response.getStatusCode() == 422);
        deleteShippingBandErrorResponseModel = gson().fromJson(response.body().prettyPrint(), DeleteShippingBandErrorResponseModel.class);
        Assert.assertEquals("error" , deleteShippingBandErrorResponseModel.getStatus());
        Assert.assertTrue(deleteShippingBandErrorResponseModel.getData() == null);
        Assert.assertEquals("ShippingBandId is required.", deleteShippingBandErrorResponseModel.getError());
    }
}