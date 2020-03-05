package net.mc.tools.services.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import net.mc.tools.helpers.ApiHelper;
import net.mc.tools.models.commission.request.CommissionRequestModel;
import net.mc.tools.models.updateTermsSetting.request.PaymentTerms;
import net.mc.tools.models.updateTermsSetting.request.UpdateTermsSettingForSellerRequestModel;

import java.util.List;

public class UpdateTermsSettingsSellerService extends ApiHelper {

    public static Gson gson;

    public static Response requestWithToken(UpdateTermsSettingForSellerRequestModel updateTermsSetting, String token) {
        Response loginUserResponse;

        loginUserResponse = authWithToken(token).body(gson().toJson(updateTermsSetting)).put("/user/term");

        return loginUserResponse;
    }

    //Specify all one time default Gson config
    public static Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gson(gsonBuilder);
        return gson;
    }

    //Custom Gson config to override Default Gson  configuration
    public static Gson gson(GsonBuilder gsonBuilder) {
        gson = gsonBuilder.create();
        return gson;
    }


}
