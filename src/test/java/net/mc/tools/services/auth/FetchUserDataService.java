package net.mc.tools.services.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import net.mc.tools.helpers.ApiHelper;
import net.mc.tools.models.fetchUserData.FetchUserDataRequest.FetchUserDataRequestModel;

import java.util.List;

public class FetchUserDataService extends ApiHelper
{
    public static Gson gson;
    private static String QueryParams;

    public static Response FetchUserDatawithToken(List<FetchUserDataRequestModel> fetchUserDataRequestModellist, String token)
    {
        QueryParams=fetchUserDataRequestModellist.get(0).getid()+"?userId="+fetchUserDataRequestModellist.get(0).getuserId()+"&userType="+fetchUserDataRequestModellist.get(0).getuserType();
        Response response;
        response=authWithToken(token).get("/user/"+QueryParams);
        return response;

    }
    public static Gson gson_method(){
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
