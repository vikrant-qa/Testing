package net.mc.tools.services.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import net.mc.tools.helpers.ApiHelper;
import net.mc.tools.models.login.request.LoginRequestModel;
import net.mc.tools.models.login.request.LoginRequestModel;
import net.mc.tools.models.orders.request.CreateFulfillmentRequestModel;

import java.util.List;

public class CreateFulfillmentService extends ApiHelper {

    public static Gson gson;

    public static Response requestWithToken(List<CreateFulfillmentRequestModel> createFulfillmentRequestModels, String token) {
        Response response;

        response = orderWithToken(token).body(gson().toJson(createFulfillmentRequestModels.get(0))).post("order/webhook/vendor/fulfill");

        return response;
    }

    public static Response requestForLoginToken(List<LoginRequestModel> loginRequestModels) {
        Response response;

        response = auth().body(gson().toJson(loginRequestModels.get(0))).post("user/login");

        return response;
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
