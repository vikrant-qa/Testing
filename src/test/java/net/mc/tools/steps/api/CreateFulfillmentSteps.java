package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;

import net.mc.tools.models.login.response.LoginResponseModel;
import net.mc.tools.models.orders.request.CreateFulfillmentRequestModel;
import net.mc.tools.models.orders.response.CreateFullfilmentErrorResponseModel;
import net.mc.tools.models.orders.response.CreateFullfilmentResponseModel;
import net.mc.tools.services.auth.CreateFulfillmentService;
import org.junit.Assert;

import static net.mc.tools.services.auth.RegisterService.gson;

public class CreateFulfillmentSteps {

    static String token = "c9d9e4695eb4245a0b5e1655bd146d3efd87b5b5fcff3cf49f10172177a7ddc3be224fe0e072e065080977462a76186812b5f45c11ca75e9065b03d8c843eed9";
    private Response response;
    private LoginResponseModel loginResponseModel;
    private CreateFullfilmentResponseModel createFullfilmentResponseModel;
    private CreateFullfilmentErrorResponseModel createFullfilmentErrorResponseModel;

    @When("^User enter details  for  create fulfillment for seller$")
    public void enterDetailsForFulfillment(List<CreateFulfillmentRequestModel> createFulfillmentRequestModelList){
        response = CreateFulfillmentService.requestWithToken(createFulfillmentRequestModelList,LoginSteps.token);
    }

    @Then("^User should be able to create fulfillment successfully for seller$")
    public void verifySuccessOfFulfillment(){
        Assert.assertTrue(response.getStatusCode() == 200);
        createFullfilmentResponseModel = gson().fromJson(response.body().prettyPrint(), CreateFullfilmentResponseModel.class);
        Assert.assertEquals("ok" , createFullfilmentResponseModel.getStatus());
        Assert.assertEquals(true, createFullfilmentResponseModel.getData());
    }

    @Then("^User should not be able to create fulfillment successfully for seller$")
    public void verifyUnuccessOfFulfillment(List<String> message){
        Assert.assertTrue(response.getStatusCode() == 403);
        createFullfilmentErrorResponseModel = gson().fromJson(response.body().prettyPrint(), CreateFullfilmentErrorResponseModel.class);
        Assert.assertEquals("error" , createFullfilmentErrorResponseModel.getStatus());
        Assert.assertEquals(message.get(0), createFullfilmentErrorResponseModel.getError());
    }
}
