package net.mc.tools.services.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import net.mc.tools.helpers.ApiHelper;
import net.mc.tools.models.register.request.RegisterRequestModel;
import net.mc.tools.models.register.request.ResendVerificationMailRequestModel;
import net.mc.tools.models.register.request.VerifyEmailRequestModel;

import java.util.List;

public class RegisterService extends ApiHelper {
    public static Gson gson;

    public static Response createNewUser(List<RegisterRequestModel> registerRequestModels) {
        Response createUserResponse;

        createUserResponse = auth().body(gson().toJson(registerRequestModels.get(0))).post("user/register");

        return createUserResponse;
}
    public static Response verifyEmail(List<VerifyEmailRequestModel> verifyEmailRequestModels) {
        Response createUserResponse;
        createUserResponse = auth().body(gson().toJson(verifyEmailRequestModels.get(0))).put("user/verify-email");

        return createUserResponse;
    }
    public static Response resendVerificationEmail(List<ResendVerificationMailRequestModel> verifyEmailRequestModels) {
        Response createUserResponse;
        createUserResponse = auth().body(gson().toJson(verifyEmailRequestModels.get(0))).put("user/resend-email");

        return createUserResponse;
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
