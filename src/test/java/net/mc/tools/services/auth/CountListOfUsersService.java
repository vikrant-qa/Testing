package net.mc.tools.services.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import net.mc.tools.helpers.ApiHelper;
import net.mc.tools.models.countListOfUsers.CountListOfUsersRequest.CountListOfUsersRequest;
import net.mc.tools.models.countListOfUsers.CountListOfUsersRequest.CountListOfUsersRequestModel;

import java.util.List;

public class CountListOfUsersService extends ApiHelper
{
    private static Gson gson;
    private static String QueryParams;

    public static Response CountListOfUsersWithToken2(List<CountListOfUsersRequestModel> countListOfUsersRequestModelList, String token)
    {
        Response response;
        response = authWithToken(token).body(gson().toJson(countListOfUsersRequestModelList.get(0))).get("/user/count");
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

    public static Response CountListOfUsersWithToken(CountListOfUsersRequest countListOfUsersList, String token)
    {
        Response response;
        response = authWithToken(token).body(gson().toJson(countListOfUsersList)).get("/user/count");
        return response;
    }


    public static Response CountListOfUsersWithToken1(CountListOfUsersRequest countListOfUsersList, String token)
    {
        Response response;
        QueryParams="?userRole="+countListOfUsersList.getuserRole().getuserRole()+"&filter="+countListOfUsersList.getFilter().getFilter();

        response = authWithToken(token).body(gson().toJson(countListOfUsersList)).get("/user/count"+QueryParams);
        return response;
    }

}
