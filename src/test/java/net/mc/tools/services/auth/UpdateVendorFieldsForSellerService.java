package net.mc.tools.services.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import net.mc.tools.helpers.ApiHelper;
import net.mc.tools.models.updateVendorFieldsForSeller.Request.UpdateVendorFieldsForSellerRequest;


import java.util.List;

public class UpdateVendorFieldsForSellerService extends ApiHelper
{
    public static Gson gson;

    public static Response UpdateVendorFieldsForSeller_with_Token(List<UpdateVendorFieldsForSellerRequest> updateVendorFieldsForSellerRequestList, String token)
    {
        Response response1;
        response1=authWithToken(token).body(gson().toJson(updateVendorFieldsForSellerRequestList.get(0))).put("/user/vendor");
        return response1;

    }
    public static Gson gson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gson(gsonBuilder);
        return gson;
    }

    public static Gson gson(GsonBuilder gsonBuilder)
    {
        gson = gsonBuilder.create();
        return gson;
    }
}
