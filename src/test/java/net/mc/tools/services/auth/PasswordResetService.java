package net.mc.tools.services.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import net.mc.tools.helpers.ApiHelper;
import net.mc.tools.models.passwordReset.request.PasswordResetRequestModel;
import net.mc.tools.models.passwordReset.request.TokenGenerateRequestModel;

import java.util.List;

public class PasswordResetService extends ApiHelper {

    public static Gson gson;

    public static Response getToken(List<TokenGenerateRequestModel> tokenGenerateRequestModel) {
        Response getTokenResponse;

        getTokenResponse = auth().body(gson().toJson(tokenGenerateRequestModel.get(0))).put("/user/password-token");

        return getTokenResponse;
    }

    public static Response resetPassword(List<PasswordResetRequestModel> passwordResetRequestModel) {
        Response resetPasswordResponse;

        resetPasswordResponse = auth().body(gson().toJson(passwordResetRequestModel.get(0))).put("/user/reset-password");

        return resetPasswordResponse;
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
