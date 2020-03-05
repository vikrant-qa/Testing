package net.mc.tools.services.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import net.mc.tools.helpers.ApiHelper;
import net.mc.tools.models.orders.request.FetchListOfOrdersRequestModel;
import net.mc.tools.models.orders.request.UpdateOrderRequestModel;

import java.util.List;

public class FetchListOfOrdersService extends ApiHelper {

    public static Gson gson;
    private static String params;
    public static Response FetchListOfOrdersRrequestWithToken(List<FetchListOfOrdersRequestModel> val, String token)
    {
        Response response;
        params="?"+"userId="+val.get(0).getUserId();
        response = orderWithToken(token).get("order"+params);
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

    public static Response requestWithToken(List<FetchListOfOrdersRequestModel> val, String token)
    {
        Response response;

        response = orderWithToken(token).body("").get("order?"
                +"?searchFilter="+val.get(0).getSearchFilter()+"&userId="+val.get(0).getUserId()+"&sortName="+val.get(0).getSortName()+"&sortOrder=" +val.get(0).getSortOrder()
                +"&perPage="+10+"&page="+val.get(0).getPage()+"&filter="+val.get(0).getFilter()+"&search"+val.get(0).getSearch());
        System.out.println(response.getBody().prettyPrint());
        return response;
    }

}
