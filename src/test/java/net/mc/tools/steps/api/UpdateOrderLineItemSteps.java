package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.helpers.HelperClass;
import net.mc.tools.models.orders.request.ArchiveOrderRequestModel;
import net.mc.tools.models.orders.request.UpdateOrderLineItemRequestModel;
import net.mc.tools.models.orders.response.ArchiveOrderResponseModel;
import net.mc.tools.models.orders.response.UpdateOrderLineItemErrorResponseModel;
import net.mc.tools.models.orders.response.UpdateOrderLineItemResponseModel;
import net.mc.tools.models.token.TokenMessageRequestModel;
import net.mc.tools.services.auth.ArchiveOrdersService;
import net.mc.tools.services.auth.UpdateOrderLineItemService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class UpdateOrderLineItemSteps {

    private Response jsonResponse;
    private UpdateOrderLineItemResponseModel updateOrderLineItemResponseModel;
    private UpdateOrderLineItemErrorResponseModel updateOrderLineItemErrorResponseModel;
    static int i = 0;
    private static List<TokenMessageRequestModel> tokenMessageRequestModelList;
    private static List<UpdateOrderLineItemRequestModel> updateOrderLineItemRequestModels;

    @When("^User enters details of order line item that needs to be update for token check$")
    public void userEnterDetailsOfLineItemTrackingthatneedstobeupdatefortokencheck(List<UpdateOrderLineItemRequestModel> updateOrderLineItemRequestModels)
    {
        this.updateOrderLineItemRequestModels=updateOrderLineItemRequestModels;
    }


    @When("^User enters details of order line item that needs to be update$")
    public void userEnterDetailsOfLineItemTracking(List<UpdateOrderLineItemRequestModel> updateOrderLineItemRequestModels)
    {
        jsonResponse = UpdateOrderLineItemService.requestWithToken(updateOrderLineItemRequestModels,LoginSteps.token);
    }


    @When("^user make a request to update order line item with Incorrect/blank token field in form of without login credentials$")
    public void usermakearequesttoupdateorderlineitemwithIncorrectblanktokenfieldinformofwithoutlogincredentials(List<TokenMessageRequestModel> tokenMessageRequestModelList)
    {
        jsonResponse = UpdateOrderLineItemService.requestWithToken(updateOrderLineItemRequestModels,tokenMessageRequestModelList.get(0).gettoken());

    }
    @Then("^User should be able to update order line item$")
    public void userShouldBeAbleToUpdateLineItemTracking()
    {
        Assert.assertTrue(jsonResponse.getStatusCode() == 200);
        updateOrderLineItemResponseModel = gson().fromJson(jsonResponse.body().prettyPrint(), UpdateOrderLineItemResponseModel.class);
        Assert.assertEquals("true", updateOrderLineItemResponseModel.getData());
        Assert.assertEquals("ok", updateOrderLineItemResponseModel.getStatus());
    }

    @Then("^User should not be able to update order line item and user should gets a validate error message$")
    public void userShouldNotBeAbleToUpdateLineItemTracking(List<String> message)
    {
        HelperClass.ErrorValidationPage(jsonResponse,message);
    }


}
