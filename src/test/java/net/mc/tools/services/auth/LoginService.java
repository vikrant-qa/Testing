package net.mc.tools.services.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import net.mc.tools.helpers.ApiHelper;
import net.mc.tools.models.login.request.LoginRequestModel;

import java.util.List;

public class LoginService extends ApiHelper {

    public static Gson gson;

    public static Response login(List<LoginRequestModel> loginRequest) {
        Response loginUserResponse;

        loginUserResponse = auth().body(gson().toJson(loginRequest.get(0))).post("user/login");

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
