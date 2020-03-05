package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.updateUserSetting.request.UpdateUserSettingRequestModel;
import net.mc.tools.models.updateUserSetting.response.UpdateUserSettingErrorResponseModel;
import net.mc.tools.models.updateUserSetting.response.UpdateUserSettingResponseModel;
import net.mc.tools.services.auth.UpdateUserSettingService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class UpdateUserSettingSteps {

    private Response response;
    private UpdateUserSettingResponseModel updateUserSettingResponseModel;
    private UpdateUserSettingErrorResponseModel updateUserSettingErrorResponseModel;
    private static int i = 0;

    @When("^user enters details for user setting update$")
    public void userEnterSettingDetails(List<UpdateUserSettingRequestModel> updateMarkupRequestModel)  {
        response = UpdateUserSettingService.requestWithToken(updateMarkupRequestModel,LoginSteps.token);
    }

    @Then("^User should be able to update user setting$")
    public void userShouldBeAbleToUpdateSetting()  {
        Assert.assertTrue(response.getStatusCode() == 200);
        updateUserSettingResponseModel = gson().fromJson(response.body().prettyPrint(), UpdateUserSettingResponseModel.class);
        System.out.println(updateUserSettingResponseModel);
    }

    @Then("^User should not be able to update user setting$")
    public void userShouldNotBeAbleToUpdateSetting(List<String> message)  {
        Assert.assertTrue(response.getStatusCode() == 422);
        updateUserSettingErrorResponseModel = gson().fromJson(response.body().prettyPrint(), UpdateUserSettingErrorResponseModel.class);
        Assert.assertEquals(message.get(i), updateUserSettingErrorResponseModel.getError());
        Assert.assertTrue(updateUserSettingErrorResponseModel.getData() == null);
        i++;
    }
}
