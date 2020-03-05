package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.orders.request.UpdateOrderLineItemRequestModel;
import net.mc.tools.models.orders.request.UpdateOrderRequestModel;
import net.mc.tools.models.orders.response.UpdateOrderErrorResponseModel;
import net.mc.tools.models.orders.response.UpdateOrderLineItemErrorResponseModel;
import net.mc.tools.models.orders.response.UpdateOrderLineItemResponseModel;
import net.mc.tools.models.orders.response.UpdateOrderResponseModel;
import net.mc.tools.services.auth.UpdateOrderLineItemService;
import net.mc.tools.services.auth.UpdateOrderService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class UpdateOrderSteps {

    private Response response;
    private UpdateOrderResponseModel updateOrderResponseModel;
    private UpdateOrderErrorResponseModel updateOrderErrorResponseModel;
    static String[] s = new String[1];
    static int i = 0;

    @When("^user enters unique id of order$")
    public void userEnterDetailsOfOrder(List<String> id)  {
        s[0] = id.get(1);

    }

    @And("^User enters details of order to be updated$")
    public void enterUserid(List<UpdateOrderRequestModel> updateOrderRequestModels){
        updateOrderRequestModels.get(0).setId(s);
        response = UpdateOrderService.requestWithToken(updateOrderRequestModels, LoginSteps.token);
    }
    @Then("^User should be able to update order$")
    public void userShouldBeAbleToUpdateOrder()  {
        Assert.assertTrue(response.getStatusCode() == 200);
        updateOrderResponseModel = gson().fromJson(response.body().prettyPrint(), UpdateOrderResponseModel.class);
        Assert.assertTrue(updateOrderResponseModel.getData() != null);
        Assert.assertEquals("ok", updateOrderResponseModel.getStatus());
    }

    @Then("^User should not be able to update order$")
    public void userShouldNotBeAbleToUpdateOrder(List<String> message)  {
        Assert.assertTrue(response.getStatusCode() == 422);
        updateOrderErrorResponseModel = gson().fromJson(response.body().prettyPrint(), UpdateOrderErrorResponseModel.class);
        Assert.assertTrue(updateOrderErrorResponseModel.getData() == null);
        Assert.assertEquals("error", updateOrderErrorResponseModel.getStatus());
        Assert.assertEquals(message.get(i), updateOrderErrorResponseModel.getError());
        i++;
    }
}
