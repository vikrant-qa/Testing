package net.mc.tools.services.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import net.mc.tools.helpers.ApiHelper;
import net.mc.tools.models.shipping.request.DeleteShippingBandRequestModel;
import net.mc.tools.models.shipping.request.DeleteShippingRuleRequestModel;

import java.util.List;

public class DeleteShippingRuleService extends ApiHelper {

    public static Gson gson;

    public static Response req(List<DeleteShippingRuleRequestModel> loginRequest, String token) {
        Response response;

        response = authWithToken(token).body(gson().toJson(loginRequest.get(0))).delete("user/shipping-rule");

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
