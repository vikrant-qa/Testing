package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.muteNotification.request.MuteNotificationRequestModel;
import net.mc.tools.models.muteNotification.response.MuteNotificationErrorResponseModel;
import net.mc.tools.models.muteNotification.response.MuteNotificationResponseModel;
import net.mc.tools.services.auth.MuteNotificationService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class MuteNotificationSteps {

    public static  String token = null;
    private Response response;
    private MuteNotificationResponseModel muteNotificationResponseModel;
    private MuteNotificationErrorResponseModel muteNotificationErrorResponseModel;

    @When("^User enter label and reset information that needs to be muted$")
    public void userEnterLabelAndResetInfo(List<MuteNotificationRequestModel> muteNotificationRequestModel)  {

        response = MuteNotificationService.muteNotification(muteNotificationRequestModel,LoginSteps.token);

    }

    @Then("^User should be able to mute respective notificaiton$")
    public void muteNotificaitonWithSuccess()  {
        Assert.assertTrue(response.getStatusCode() == 200);
        muteNotificationResponseModel = gson().fromJson(response.body().prettyPrint(), MuteNotificationResponseModel.class);
        Assert.assertEquals("ok" , muteNotificationResponseModel.getStatus());
        Assert.assertEquals("true", muteNotificationResponseModel.getData());
    }

    @Then("^User should not be able to mute respective notificaiton$")
    public void muteNotificaitonWithSuccessError()  {
        Assert.assertTrue(response.getStatusCode() == 422);
        muteNotificationErrorResponseModel = gson().fromJson(response.body().prettyPrint(), MuteNotificationErrorResponseModel.class);
        Assert.assertEquals("error" , muteNotificationErrorResponseModel.getStatus());
        Assert.assertTrue(muteNotificationErrorResponseModel.getData() == null);
        Assert.assertEquals("Label is required.", muteNotificationErrorResponseModel.getError());
    }
}
