package net.mc.tools.services.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import net.mc.tools.helpers.ApiHelper;
import net.mc.tools.models.IdFetchOrderDataRow.IdFetchOrderDataRowRequest.IdFetchOrderDataRowRequestModel;

import java.util.List;

public class IdFetchOrderDataRowService extends ApiHelper
{
    public static Gson gson;
    private static String parameters;

    public static Response req(List<IdFetchOrderDataRowRequestModel> idFetchOrderDataRowRequestModelList, String token)
    {
        Response response;
         parameters=idFetchOrderDataRowRequestModelList.get(0).getId()+"?userId="+idFetchOrderDataRowRequestModelList.get(0).getUserId();
        response = orderWithToken(token).get("order/"+parameters);

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
