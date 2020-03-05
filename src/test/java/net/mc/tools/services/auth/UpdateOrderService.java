package net.mc.tools.services.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import net.mc.tools.helpers.ApiHelper;
import net.mc.tools.models.orders.request.UpdateOrderLineItemRequestModel;
import net.mc.tools.models.orders.request.UpdateOrderRequestModel;

import java.util.List;

public class UpdateOrderService extends ApiHelper {

    public static Gson gson;

    public static Response requestWithToken(List<UpdateOrderRequestModel> updateOrderRequestModels, String token) {
        Response response;

        response = orderWithToken(token).body(gson().toJson(updateOrderRequestModels.get(0))).put("order");
        System.out.println(response.getBody().prettyPrint());
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
