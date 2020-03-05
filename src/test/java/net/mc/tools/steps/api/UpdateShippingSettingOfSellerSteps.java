package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.shipping.request.UpdateShippingOfferRequestModel;
import net.mc.tools.models.shipping.request.UpdateShippingSettingRequestModel;
import net.mc.tools.models.shipping.response.UpdateShippingOfferErrorResponseModel;
import net.mc.tools.models.shipping.response.UpdateShippingOfferResponseModel;
import net.mc.tools.models.shipping.response.UpdateShippingSettingErrorResponseModel;
import net.mc.tools.models.shipping.response.UpdateShippingSettingResponseModel;
import net.mc.tools.services.auth.UpdateShippingOfferService;
import net.mc.tools.services.auth.UpdateShippingSettingOfSellerService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class UpdateShippingSettingOfSellerSteps {

    public static  String token = null;
    private Response response;
    private UpdateShippingSettingResponseModel updateShippingSettingResponseModel;
    private UpdateShippingSettingErrorResponseModel updateShippingSettingErrorResponseModel;
    private static int i;

    @When("^User enters shipping setting details to update$")
    public void userEnterUpdateShippingSetting(List<UpdateShippingSettingRequestModel> updateShippingSettingRequestModels)  {

        response = UpdateShippingSettingOfSellerService.req(updateShippingSettingRequestModels,LoginSteps.token);

    }

    @Then("^User should be able to update shipping setting for seller$")
    public void userSuccessfullyUpdateShippingSetting()  {
        Assert.assertTrue(response.getStatusCode() == 200);
        updateShippingSettingResponseModel = gson().fromJson(response.body().prettyPrint(), UpdateShippingSettingResponseModel.class);
        Assert.assertEquals("ok" , updateShippingSettingResponseModel.getStatus());
        Assert.assertEquals("true", updateShippingSettingResponseModel.getData());
    }

    @Then("^User should not be able to update shipping setting for seller and validate error message$")
    public void userValidateErrorMsgUpdateSetting(List<String> message)  {
        Assert.assertTrue(response.getStatusCode() == 422);
        updateShippingSettingErrorResponseModel = gson().fromJson(response.body().prettyPrint(), UpdateShippingSettingErrorResponseModel.class);
        Assert.assertEquals("error" , updateShippingSettingErrorResponseModel.getStatus());
        Assert.assertTrue(updateShippingSettingErrorResponseModel.getData() == null);
        Assert.assertEquals(message.get(i), updateShippingSettingErrorResponseModel.getError());
        i++;
    }
}