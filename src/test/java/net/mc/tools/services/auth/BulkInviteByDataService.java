package net.mc.tools.services.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import net.mc.tools.helpers.ApiHelper;
import net.mc.tools.models.bulkInvite.request.BulkInviteByDataRequestModel;

public class BulkInviteByDataService extends ApiHelper {

    public static Gson gson;

    public static Response bulkInviteByData(BulkInviteByDataRequestModel loginRequest, String token) {
        Response loginUserResponse;

        loginUserResponse = bulkWithToken(token).body(gson().toJson(loginRequest)).post("bulk/invite/vendor");

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
