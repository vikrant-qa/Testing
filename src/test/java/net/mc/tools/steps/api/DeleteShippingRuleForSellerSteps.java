package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.shipping.request.DeleteShippingBandRequestModel;
import net.mc.tools.models.shipping.request.DeleteShippingRuleRequestModel;
import net.mc.tools.models.shipping.response.DeleteShippingBandErrorResponseModel;
import net.mc.tools.models.shipping.response.DeleteShippingBandResponseModel;
import net.mc.tools.models.shipping.response.DeleteShippingRuleErrorResponseModel;
import net.mc.tools.models.shipping.response.DeleteShippingRuleResponseModel;
import net.mc.tools.services.auth.DeleteShippingBandService;
import net.mc.tools.services.auth.DeleteShippingRuleService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class DeleteShippingRuleForSellerSteps {

    public static  String token = null;
    private Response response;
    private DeleteShippingRuleResponseModel deleteShippingRuleResponseModel;
    private DeleteShippingRuleErrorResponseModel deleteShippingRuleErrorResponseModel;

    @When("^User enters shippingRuleId$")
    public void userEnterShippingRuleId(List<DeleteShippingRuleRequestModel> deleteShippingRuleRequestModel)  {

        response = DeleteShippingRuleService.req(deleteShippingRuleRequestModel,LoginSteps.token);

    }

    @Then("^User should be able to delete shipping rule for seller$")
    public void userSuccessfullyDeleteShippingRule()  {
        Assert.assertTrue(response.getStatusCode() == 200);
        deleteShippingRuleResponseModel = gson().fromJson(response.body().prettyPrint(), DeleteShippingRuleResponseModel.class);
        Assert.assertEquals("ok" , deleteShippingRuleResponseModel.getStatus());
        Assert.assertEquals("true", deleteShippingRuleResponseModel.getData());
    }

    @Then("^User should not be able to delete shipping rule for seller$")
    public void userValidateRuleErrorMsg()  {
        Assert.assertTrue(response.getStatusCode() == 422);
        deleteShippingRuleErrorResponseModel = gson().fromJson(response.body().prettyPrint(), DeleteShippingRuleErrorResponseModel.class);
        Assert.assertEquals("error" , deleteShippingRuleErrorResponseModel.getStatus());
        Assert.assertTrue(deleteShippingRuleErrorResponseModel.getData() == null);
        Assert.assertEquals("ShippingRuleId is required.", deleteShippingRuleErrorResponseModel.getError());
    }
}