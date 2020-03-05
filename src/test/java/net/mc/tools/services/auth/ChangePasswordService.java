package net.mc.tools.services.auth;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import net.mc.tools.helpers.ApiHelper;
import net.mc.tools.models.change_Password.request.Change_Password_Request;

import java.util.List;

public class ChangePasswordService extends ApiHelper
{
    public static Gson gson;

    public static Response Change_Password_Request_with_Token(List<Change_Password_Request> password_request, String token)
     {
         Response response1;
         response1=authWithToken(token).body(gson_method().toJson(password_request.get(0))).put("/user/password");
         return response1;

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
