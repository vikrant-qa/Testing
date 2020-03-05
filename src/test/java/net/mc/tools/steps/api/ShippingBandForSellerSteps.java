package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.muteNotification.request.MuteNotificationRequestModel;
import net.mc.tools.models.muteNotification.response.MuteNotificationErrorResponseModel;
import net.mc.tools.models.muteNotification.response.MuteNotificationResponseModel;
import net.mc.tools.models.shipping.request.ShippingBandForSellerRequestModel;
import net.mc.tools.models.shipping.response.ShippingBandForSellerErrorResponseModel;
import net.mc.tools.models.shipping.response.ShippingBandForSellerResponseModel;
import net.mc.tools.services.auth.MuteNotificationService;
import net.mc.tools.services.auth.ShippingBankForSellerService;
import net.mc.tools.utilities.RandomGenerator;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class ShippingBandForSellerSteps {

    public static  String token = null;
    private Response response;
    private ShippingBandForSellerResponseModel shippingBandForSellerResponseModel;
    private ShippingBandForSellerErrorResponseModel shippingBandForSellerErrorResponseModel;
    private static int i = 0;

    @When("^User enter details  for  create shipping band for seller$")
    public void userEnterShippingBandDetails(List<ShippingBandForSellerRequestModel> shippingBandForSellerRequestModel)  {
        if(shippingBandForSellerRequestModel.get(0).getName().equalsIgnoreCase("Albert"))
            shippingBandForSellerRequestModel.get(0).setName(shippingBandForSellerRequestModel.get(0)
                                                                                                .getName()
                                                                            + RandomGenerator.randomAlphanumeric(5));
           //System.out.println(shippingBandForSellerRequestModel.get(0).getName()+shippingBandForSellerRequestModel.get(0).getDescription()+shippingBandForSellerRequestModel.get(0).getIsUpdateAllowed()+shippingBandForSellerRequestModel.get(0).getPrice()+shippingBandForSellerRequestModel.get(0).getPriceType());
            response = ShippingBankForSellerService.req(shippingBandForSellerRequestModel,LoginSteps.token);

    }

    @Then("^User should be able to create shipping successfully for seller$")
    public void userSuccessfullyCreateShippingBand()
    {
        Assert.assertTrue(response.getStatusCode() == 200);
        shippingBandForSellerResponseModel = gson().fromJson(response.body().prettyPrint(), ShippingBandForSellerResponseModel.class);
        Assert.assertEquals("ok" , shippingBandForSellerResponseModel.getStatus());
        Assert.assertEquals("true", shippingBandForSellerResponseModel.getData());
    }

    @Then("^User should not be able to create shipping successfully for seller and show below error messages$")
    public void userValidateShippingBandErrorMsg(List<String> message)
    {
        Assert.assertTrue(response.getStatusCode() == 422);
        shippingBandForSellerErrorResponseModel = gson().fromJson(response.body().prettyPrint(), ShippingBandForSellerErrorResponseModel.class);
        Assert.assertEquals("error" , shippingBandForSellerErrorResponseModel.getStatus());
        Assert.assertTrue(shippingBandForSellerErrorResponseModel.getData() == null);
        Assert.assertEquals(message.get(i), shippingBandForSellerErrorResponseModel.getError());
        i++;
    }
}
