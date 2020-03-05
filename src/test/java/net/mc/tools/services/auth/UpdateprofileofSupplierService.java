package net.mc.tools.services.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import net.mc.tools.helpers.ApiHelper;
import net.mc.tools.models.updateprofileofSupplier.request.UpdateprofileofSupplierRequestModel;

import java.util.List;

public class UpdateprofileofSupplierService extends ApiHelper
{
    public static Gson gson;

    public static Response UpdateprofileRequest(List<UpdateprofileofSupplierRequestModel> list, String Token) {
        Response loginUserResponse;
        System.out.println(" BrandName is --  ("+list.get(0).getbrandName()+")first Name is --   ("+list.get(0).getfirstName()+") Last Name is    ("+list.get(0).getlastName()+")Phone number is   ("+list.get(0).getphoneNumber()+")Id is--("+list.get(0).getid()+")Id is--("+list.get(0).getid()+")");

        loginUserResponse = authWithToken(Token).body(gson().toJson(list.get(0))).put("user/profile");

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
