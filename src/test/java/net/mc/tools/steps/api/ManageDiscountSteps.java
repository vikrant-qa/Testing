package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.manageDiscount.request.AdvancedValues;
import net.mc.tools.models.manageDiscount.request.ManageDiscountRequestModel;
import net.mc.tools.models.manageDiscount.response.ManageDiscountResponseModel;
import net.mc.tools.models.updateUserSetting.request.UpdateUserSettingRequestModel;
import net.mc.tools.models.updateUserSetting.response.UpdateUserSettingResponseModel;
import net.mc.tools.services.auth.ManageDiscountService;
import net.mc.tools.services.auth.UpdateUserSettingService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class ManageDiscountSteps {

    private Response response;
    private ManageDiscountResponseModel manageDiscountResponseModel;
    private ManageDiscountRequestModel manageDiscountRequestModel = new ManageDiscountRequestModel();
    private AdvancedValues[] advancedValues = new AdvancedValues[1];
    private AdvancedValues val = new AdvancedValues();

    @When("^user enter details for discount$")
    public void userEnterMarkupDetails(List<ManageDiscountRequestModel> manageDiscountRequestModel)  {
        this.manageDiscountRequestModel.setPrice(manageDiscountRequestModel.get(0).getPrice());
        this.manageDiscountRequestModel.setType(manageDiscountRequestModel.get(0).getType());
        this.manageDiscountRequestModel.setUserId(manageDiscountRequestModel.get(0).getUserId());
        this.manageDiscountRequestModel.setRuleBy(manageDiscountRequestModel.get(0).getRuleBy());
    }

    @And("^user enter advance values for discount$")
    public void enterAdvanceValues(List<AdvancedValues> advancedValues){
        val.setPrice(advancedValues.get(0).getPrice());
        val.setProductId(advancedValues.get(0).getProductId());
        val.setType(advancedValues.get(0).getType());
        val.setVendorId(advancedValues.get(0).getVendorId());
        this.advancedValues[0] = val;
        manageDiscountRequestModel.setAdvancedValues(this.advancedValues);
        response = ManageDiscountService.login(manageDiscountRequestModel,LoginSteps.token);
    }

    @Then("^user should be able to update discount settings for user$")
    public void userShouldBeAbleToUpdateMarkup()  {
        Assert.assertTrue(response.getStatusCode() == 200);
        manageDiscountResponseModel = gson().fromJson(response.body().prettyPrint(), ManageDiscountResponseModel.class);
        Assert.assertEquals("true", manageDiscountResponseModel.getData());
    }
}
