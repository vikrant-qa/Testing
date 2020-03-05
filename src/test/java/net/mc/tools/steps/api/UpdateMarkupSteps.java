package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.updateMarkupOfProduct.request.AdvancedValues;
import net.mc.tools.models.updateMarkupOfProduct.request.UpdateMarkupRequestModel;
import net.mc.tools.models.updateMarkupOfProduct.response.UpdateMarkupErrorResponseModel;
import net.mc.tools.models.updateMarkupOfProduct.response.UpdateMarkupResponseModel;
import net.mc.tools.services.auth.UpdateMarkupService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class UpdateMarkupSteps {

    private Response response;
    private UpdateMarkupResponseModel updateMarkupResponseModel;
    private UpdateMarkupErrorResponseModel updateMarkupErrorResponseModel;
    private List<UpdateMarkupRequestModel> updateMarkupRequestModel;
    private AdvancedValues val = new AdvancedValues();
    private AdvancedValues[] v = new AdvancedValues[1];
    private static int i=0;

    @When("^enter details and send request to update markup$")
    public void userEnterMarkupDetails(List<UpdateMarkupRequestModel> updateMarkupRequestModel)  {
        this.updateMarkupRequestModel = updateMarkupRequestModel;
    }

    @And("^user enter advance values for product$")
    public void enterAdvanceValues(List<AdvancedValues> advancedValues){
        v[0] = val;
        val.setCategory(advancedValues.get(0).getCategory());
        val.setPrice(advancedValues.get(0).getPrice());
        val.setType(advancedValues.get(0).getType());
        updateMarkupRequestModel.get(0).setAdvancedValues(v);
        response = UpdateMarkupService.requestWithToken(updateMarkupRequestModel, LoginSteps.token);
    }

    @Then("^User should be able to update product markup$")
    public void userShouldBeAbleToUpdateMarkup()  {
        Assert.assertTrue(response.getStatusCode() == 200);
        updateMarkupResponseModel = gson().fromJson(response.body().prettyPrint(), UpdateMarkupResponseModel.class);
        Assert.assertEquals("ok" , updateMarkupResponseModel.getStatus());
        Assert.assertEquals("true", updateMarkupResponseModel.getData());
    }

    @Then("^User should not be able to update product markup and display message$")
    public void userShouldNotBeAbleToUpdateMarkup(List<String> message)  {
        Assert.assertTrue(response.getStatusCode() == 422);
        updateMarkupErrorResponseModel = gson().fromJson(response.body().prettyPrint(), UpdateMarkupErrorResponseModel.class);
        Assert.assertEquals("error" , updateMarkupErrorResponseModel.getStatus());
        Assert.assertTrue(updateMarkupErrorResponseModel.getData() == null);
        Assert.assertEquals(message.get(i), updateMarkupErrorResponseModel.getError());
        i++;
    }
}
