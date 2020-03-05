package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.login.response.LoginResponseModel;
import net.mc.tools.models.updateTermsSetting.request.PaymentTerms;
import net.mc.tools.models.updateTermsSetting.request.UpdateTermsSettingForSellerRequestModel;
import net.mc.tools.models.updateTermsSetting.response.UpdateTermsErrorResponseModel;
import net.mc.tools.models.updateTermsSetting.response.UpdateTermsSettingsForSellerResponseModel;
import net.mc.tools.services.auth.UpdateTermsSettingsSellerService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class UpdateTermsSettingsSellerSteps {

    private Response response;
    private LoginResponseModel loginResponseModel;
    private UpdateTermsSettingsForSellerResponseModel updateTermsSettingsForSellerResponseModel;
    private UpdateTermsErrorResponseModel updateTermsErrorResponseModel;
    private PaymentTerms objPt=new PaymentTerms();
    private UpdateTermsSettingForSellerRequestModel obj1=new UpdateTermsSettingForSellerRequestModel();

    @When("^User make a request to change the terms settings by entering return type and return period$")
    public void userUpdateTermsSettings(List<UpdateTermsSettingForSellerRequestModel> updateTerms)
    {
       obj1.setIsReturn(updateTerms.get(0).getIsReturn());
       obj1.setReturnPeriod(updateTerms.get(0).getReturnPeriod());

    }

    @And("^user enters payment terms$")
    public void userEnterPaymentTerms(List<PaymentTerms> paymentTerms)  {
        System.out.println(paymentTerms.get(0).getDays()+paymentTerms.get(0).getType());
        objPt.setDays(paymentTerms.get(0).getDays());
        objPt.setType(paymentTerms.get(0).getType());
        obj1.setPaymentTerms(objPt);
        response = UpdateTermsSettingsSellerService.requestWithToken(obj1,LoginSteps.token);

    }

    @Then("^User is able to successfully change the terms settings for seller$")
    public void userShouldBeAbleToChangeTerms() {
        response.body().prettyPrint();
        Assert.assertTrue(response.getStatusCode() == 200);
        updateTermsSettingsForSellerResponseModel = gson().fromJson(response.body().prettyPrint(), UpdateTermsSettingsForSellerResponseModel.class);
        Assert.assertEquals("ok", updateTermsSettingsForSellerResponseModel.getStatus());
        Assert.assertEquals("true", updateTermsSettingsForSellerResponseModel.getData());

    }

    @Then("^User is not able to change the terms and get validation error message for type$")
    public void userShouldNotBeAbleToChangeTerms() {
        Assert.assertTrue(response.getStatusCode() == 422);
        updateTermsErrorResponseModel = gson().fromJson(response.body().prettyPrint(), UpdateTermsErrorResponseModel.class);
        Assert.assertEquals("error", updateTermsErrorResponseModel.getStatus());
        Assert.assertTrue(updateTermsErrorResponseModel.getData() == null);
        Assert.assertEquals("Payment terms are required", updateTermsErrorResponseModel.getError());
    }

    @Then("^User is not able to change the terms and get validation error message for returnPeriod")
    public void userShouldNotBeAbleToChangeTermsWithoutReturnPeriod() {
        Assert.assertTrue(response.getStatusCode() == 422);
        updateTermsErrorResponseModel = gson().fromJson(response.body().prettyPrint(), UpdateTermsErrorResponseModel.class);
        Assert.assertEquals("error", updateTermsErrorResponseModel.getStatus());
        Assert.assertTrue(updateTermsErrorResponseModel.getData() == null);
        Assert.assertEquals("Days can't be less than 0", updateTermsErrorResponseModel.getError());
    }
}
