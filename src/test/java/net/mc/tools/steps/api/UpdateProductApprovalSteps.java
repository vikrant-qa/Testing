package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.addPaypalDetails.request.AddPaypalDetailsRequestModel;
import net.mc.tools.models.addPaypalDetails.response.AddPaypalDetailsErrorResponseModel;
import net.mc.tools.models.addPaypalDetails.response.AddPaypalDetailsResponseModel;
import net.mc.tools.models.updateProductApprovalSettings.request.UpdateProductApprovalRequestModel;
import net.mc.tools.models.updateProductApprovalSettings.response.UpdateProductApprovalResponseModel;
import net.mc.tools.services.auth.AddPaypalDetailsService;
import net.mc.tools.services.auth.UpdateProductApprovalService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class UpdateProductApprovalSteps {

    private String message;
    private static int i = 0;
    private Response response;
    private UpdateProductApprovalResponseModel updateProductApprovalResponseModel;

    @When("^user enter approval setting and submit request$")
    public void userUpdateProductApprovalSetting(List<UpdateProductApprovalRequestModel> updateProductApprovalRequestModel)  {
            response = UpdateProductApprovalService.requestWithToken(updateProductApprovalRequestModel,LoginSteps.token);
    }

    @Then("^user should be able to update approval settings for any seller or vendor$")
    public void paypalDetailsShouldBeAdd()  {
        Assert.assertTrue(response.getStatusCode() == 200);
        updateProductApprovalResponseModel = gson().fromJson(response.body().prettyPrint(), UpdateProductApprovalResponseModel.class);
        Assert.assertEquals("ok" , updateProductApprovalResponseModel.getStatus());
        Assert.assertEquals("true", updateProductApprovalResponseModel.getData());

    }
}
