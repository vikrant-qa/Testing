package net.mc.tools.services.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import net.mc.tools.helpers.ApiHelper;
import net.mc.tools.models.addProduct.request.AddProductRequestModel;
import net.mc.tools.models.branding.request.UpdateBrandingOfSellerRequestModel;

import java.util.List;

public class UpdateBrandingOfSellerService extends ApiHelper {

    public static Gson gson;

    public static Response request(List<UpdateBrandingOfSellerRequestModel> updateBrandingOfSellerRequestModels, String token) {
        Response response;

        response = authWithToken(token).body(gson().toJson(updateBrandingOfSellerRequestModels.get(0))).put("user/branding");

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
