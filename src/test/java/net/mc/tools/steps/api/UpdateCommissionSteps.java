package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.commission.request.CommissionRequestModel;
import net.mc.tools.models.commission.response.CommissionErrorResponseModel;
import net.mc.tools.models.commission.response.CommissionResponseModel;
import net.mc.tools.services.auth.CommissionService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class UpdateCommissionSteps
{
     private Response json_Response;
     private CommissionResponseModel commissionResponseModel;
     private CommissionErrorResponseModel commissionErrorResponseModel;

    @When("^User make a request to change the commission of given user$")
    public void userMakeCommissionChangeRequest(List<CommissionRequestModel> commissionRequestModel)
    {
        json_Response = CommissionService.requestWithToken(commissionRequestModel,LoginSteps.token);
    }

    @Then("^User is able to successfully change the commission for the given user$")
    public void userShouldBeAbleToChangeCommission()  {
        Assert.assertTrue(json_Response.getStatusCode() == 200);
        commissionResponseModel = gson().fromJson(json_Response.body().prettyPrint(), CommissionResponseModel.class);
        Assert.assertEquals("ok" , commissionResponseModel.getStatus());
        Assert.assertEquals("true", commissionResponseModel.getData());

    }

    @Then("^User is not able to successfully change the commission for the given user without commission$")
    public void userShouldNotBeAbleToChangeWithoutCommission()  {
        Assert.assertTrue(json_Response.getStatusCode() == 422);
        commissionErrorResponseModel = gson().fromJson(json_Response.body().prettyPrint(), CommissionErrorResponseModel.class);
        Assert.assertEquals("error" , commissionErrorResponseModel.getStatus());
        Assert.assertEquals("Commission is required.", commissionErrorResponseModel.getError());
        Assert.assertTrue(commissionErrorResponseModel.getData() == null);
    }

    @Then("^User is not able to successfully change the commission for the given user without commission type$")
    public void userShouldNotBeAbleToChangeWithoutCommissionType()  {
        Assert.assertTrue(json_Response.getStatusCode() == 422);
        commissionErrorResponseModel = gson().fromJson(json_Response.body().prettyPrint(), CommissionErrorResponseModel.class);
        Assert.assertEquals("error" , commissionErrorResponseModel.getStatus());
        Assert.assertEquals("CommissionType is required.", commissionErrorResponseModel.getError());
        Assert.assertTrue(commissionErrorResponseModel.getData() == null);
    }


}
