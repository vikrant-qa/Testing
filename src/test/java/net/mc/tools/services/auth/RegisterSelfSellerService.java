package net.mc.tools.services.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import net.mc.tools.helpers.ApiHelper;
import net.mc.tools.models.registerSelfSeller.registerSelfSellerRequest.RegisterSelfSellerRequestModel;


import java.util.List;

public class RegisterSelfSellerService extends ApiHelper
{
    public static Gson gson;
    public static Response createNewSeller(List<RegisterSelfSellerRequestModel> registerSelfSellerRequestModels) {
        Response createUserResponse;

        createUserResponse = auth().body(gson().toJson(registerSelfSellerRequestModels.get(0))).post("user/seller");

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
