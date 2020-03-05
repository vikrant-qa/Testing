package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.muteNotification.request.MuteNotificationRequestModel;
import net.mc.tools.models.muteNotification.response.MuteNotificationErrorResponseModel;
import net.mc.tools.models.muteNotification.response.MuteNotificationResponseModel;
import net.mc.tools.models.shipping.request.ShippingBandForSellerRequestModel;
import net.mc.tools.models.shipping.request.ShippingRuleForSellerRequestModel;
import net.mc.tools.models.shipping.response.ShippingBandForSellerErrorResponseModel;
import net.mc.tools.models.shipping.response.ShippingBandForSellerResponseModel;
import net.mc.tools.models.shipping.response.ShippingRuleForSellerErrorResponseModel;
import net.mc.tools.models.shipping.response.ShippingRuleForSellerResponseModel;
import net.mc.tools.services.auth.MuteNotificationService;
import net.mc.tools.services.auth.ShippingBankForSellerService;
import net.mc.tools.services.auth.ShippingRuleForSellerService;
import net.mc.tools.utilities.RandomGenerator;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class ShippingRuleForSellerSteps {

    public static  String token = null;
    private Response response;
    private ShippingRuleForSellerResponseModel shippingRuleForSellerResponseModel;
    private ShippingRuleForSellerErrorResponseModel shippingRuleForSellerErrorResponseModel;
    private String[] temp = new String[1];
    private static int i = 0;

    @When("^User enter details  for  create shipping rule for seller$")
    public void userEnterShippingRuleDetails(List<ShippingRuleForSellerRequestModel> shippingRuleForSellerRequestModel)  {
        if(shippingRuleForSellerRequestModel.get(0).getProductIds() != null) {
        	temp[0] = RandomGenerator.randomInteger(5);
        	shippingRuleForSellerRequestModel.get(0).setProductIds(temp);
        }
        	
            response = ShippingRuleForSellerService.req(shippingRuleForSellerRequestModel,LoginSteps.token);

    }

    @Then("^User should be able to create rule for seller$")
    public void userSuccessfullyCreateShippingRule()  {
        Assert.assertTrue(response.getStatusCode() == 200);
        shippingRuleForSellerResponseModel = gson().fromJson(response.body().prettyPrint(), ShippingRuleForSellerResponseModel.class);
        Assert.assertEquals("ok" , shippingRuleForSellerResponseModel.getStatus());
        Assert.assertEquals("true", shippingRuleForSellerResponseModel.getData());
    }

    @Then("^User should not be able to create rule for seller and get error message$")
    public void userValidateErrorMsgForCreateShippingRule(List<String> message)  {
        Assert.assertTrue(response.getStatusCode() == 422);
        shippingRuleForSellerErrorResponseModel = gson().fromJson(response.body().prettyPrint(), ShippingRuleForSellerErrorResponseModel.class);
        Assert.assertEquals("error" , shippingRuleForSellerErrorResponseModel.getStatus());
        Assert.assertTrue(shippingRuleForSellerErrorResponseModel.getData() == null);
        Assert.assertEquals(message.get(i), shippingRuleForSellerErrorResponseModel.getError());
        i++;
    }
}