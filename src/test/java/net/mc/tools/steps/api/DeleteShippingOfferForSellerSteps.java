package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.shipping.request.DeleteShippingBandRequestModel;
import net.mc.tools.models.shipping.request.DeleteShippingOfferRequestModel;
import net.mc.tools.models.shipping.response.DeleteShippingBandErrorResponseModel;
import net.mc.tools.models.shipping.response.DeleteShippingBandResponseModel;
import net.mc.tools.models.shipping.response.DeleteShippingOfferErrorResponseModel;
import net.mc.tools.models.shipping.response.DeleteShippingOfferResponseModel;
import net.mc.tools.services.auth.DeleteShippingBandService;
import net.mc.tools.services.auth.DeleteShippingOfferService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class DeleteShippingOfferForSellerSteps {

    public static  String token = null;
    private Response response;
    private DeleteShippingOfferResponseModel deleteShippingOfferResponseModel;
    private DeleteShippingOfferErrorResponseModel deleteShippingOfferErrorResponseModel;

    @When("^User enters shippingOfferId$")
    public void userEnterShippingOfferId(List<DeleteShippingOfferRequestModel> deleteShippingOfferRequestModelList)  {

        response = DeleteShippingOfferService.req(deleteShippingOfferRequestModelList,LoginSteps.token);

    }

    @Then("^User should be able to delete shipping offer for seller$")
    public void userSuccessfullyDeleteShippingOffer()  {
        Assert.assertTrue(response.getStatusCode() == 200);
        deleteShippingOfferResponseModel = gson().fromJson(response.body().prettyPrint(), DeleteShippingOfferResponseModel.class);
        Assert.assertEquals("ok" , deleteShippingOfferResponseModel.getStatus());
        Assert.assertEquals("true", deleteShippingOfferResponseModel.getData());
    }

    @Then("^User should not be able to delete shipping offer for seller$")
    public void userValidateErrorMsgOffer()  {
        Assert.assertTrue(response.getStatusCode() == 422);
        deleteShippingOfferErrorResponseModel = gson().fromJson(response.body().prettyPrint(), DeleteShippingOfferErrorResponseModel.class);
        Assert.assertEquals("error" , deleteShippingOfferErrorResponseModel.getStatus());
        Assert.assertTrue(deleteShippingOfferErrorResponseModel.getData() == null);
        Assert.assertEquals("ShippingOfferId is required.", deleteShippingOfferErrorResponseModel.getError());
    }
}