package net.mc.tools.services.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import net.mc.tools.helpers.ApiHelper;
import net.mc.tools.models.addPaypalDetails.request.AddPaypalDetailsRequestModel;
import net.mc.tools.models.addProduct.request.AddProductRequestModel;

import java.util.List;

public class AddPaypalDetailsService extends ApiHelper {

    public static Gson gson;

    public static Response requestWithToken(List<AddPaypalDetailsRequestModel> addPaypalDetailsRequestModel, String token) {
        Response response;

        response = authWithToken(token).body(gson().toJson(addPaypalDetailsRequestModel.get(0))).post("user/paypal");

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
