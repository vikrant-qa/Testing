package net.mc.tools.services.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import net.mc.tools.helpers.ApiHelper;
import net.mc.tools.models.fetchListOfUsers.FetchListOfUsersRequest.FetchListOfUsersRequestModel;

import java.util.List;

public class FetchListOfUsersService extends ApiHelper
{
    public static Gson gson;
    private static String QueryParams;

    public static Response FetchListOfUsersWithToken(List<FetchListOfUsersRequestModel> fetchListOfUsersRequestModelList, String token)
    {
        QueryParams="?userId="+fetchListOfUsersRequestModelList.get(0).getuserId()+"&userType="+fetchListOfUsersRequestModelList.get(0).getuserType();
        Response response;
        response=authWithToken(token).get("/user"+QueryParams);
        return response;

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
