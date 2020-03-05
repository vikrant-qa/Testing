package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.orders.request.BulkActionsRequestModel;
import net.mc.tools.models.orders.response.BulkActionsResponseModel;
import net.mc.tools.models.updateUserSetting.response.UpdateUserSettingErrorResponseModel;
import net.mc.tools.models.updateUserSetting.response.UpdateUserSettingResponseModel;
import net.mc.tools.services.auth.BulkActionsService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class BulkActionsSteps {

    private Response response;
    private BulkActionsResponseModel bulkActionsResponseModel;
    String[] str = new String[1];

    @When("^user enters line item id$")
    public void userEnterOrderLineItemsDetails(List<String> id)  {
        str[0] = id.get(0);
    }

    @And("^user enters details of order line items$")
    public void getLineItemID(List<BulkActionsRequestModel> bulkActionsRequestModels){
        bulkActionsRequestModels.get(0).setIds(str);
        response = BulkActionsService.requestWithToken(bulkActionsRequestModels,LoginSteps.token);
    }

    @Then("^User should be able to perform bulk actions$")
    public void userShouldBeAbleToDoBulkActions()  {
        Assert.assertTrue(response.getStatusCode() == 200);
        bulkActionsResponseModel = gson().fromJson(response.body().prettyPrint(), BulkActionsResponseModel.class);
        Assert.assertEquals("true", bulkActionsResponseModel.getData());
        Assert.assertEquals("ok", bulkActionsResponseModel.getStatus());
    }
}
