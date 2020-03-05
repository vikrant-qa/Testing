package net.mc.tools.services.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import net.mc.tools.helpers.ApiHelper;
import net.mc.tools.models.updateVendorDetailsForVendor.updateVendorDetailsForVendorRequest.UpdateVendorDetailsForVendorRequestModel;
import java.util.List;

public class UpdateVendorDetailsForVendorService extends ApiHelper
{
    public static Gson gson;

    public static Response UpdateVendorDetailsForVendor_with_Token(List<UpdateVendorDetailsForVendorRequestModel> updateVendorDetailsForVendorRequestModelList, String token)
    {
        Response response1;
        System.out.println(updateVendorDetailsForVendorRequestModelList.get(0).getBrandName()+updateVendorDetailsForVendorRequestModelList.get(0).getSellerId()+updateVendorDetailsForVendorRequestModelList.get(0).getVendorId());
        response1=authWithToken(token).body(gson().toJson(updateVendorDetailsForVendorRequestModelList.get(0))).put("/user/vendor-detail");
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
