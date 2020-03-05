package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.branding.request.Register;
import net.mc.tools.models.branding.request.UpdateBrandingOfSellerRequestModel;
import net.mc.tools.models.branding.response.UpdateBrandingOfSellerResponseModel;
import net.mc.tools.services.auth.UpdateBrandingOfSellerService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class UpdateBrandingOfSellerSteps {

    private Response response;
    private UpdateBrandingOfSellerResponseModel updateBrandingOfSellerResponseModel;
    private Register register;
    private List<UpdateBrandingOfSellerRequestModel> obj;

    @When("^User enter branding information$")
    public void userEnterBrandingInfo(List<UpdateBrandingOfSellerRequestModel> request)  {
        obj = request;
    }

    @And("^Enter register details$")
    public void userEnterRegisterInfo(List<Register> register)  {
        obj.get(0).setRegister(register.get(0));
        response = UpdateBrandingOfSellerService.request(obj,LoginSteps.token);
    }

    @Then("^user should be able to update branding of seller$")
    public void userUpdateBrandingInfo()  {
        Assert.assertTrue(response.getStatusCode() == 200);
        updateBrandingOfSellerResponseModel = gson().fromJson(response.body().prettyPrint(), UpdateBrandingOfSellerResponseModel.class);
        Assert.assertEquals("ok" , updateBrandingOfSellerResponseModel.getStatus());
        Assert.assertEquals("true", updateBrandingOfSellerResponseModel.getData());
    }
}
