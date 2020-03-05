package net.mc.tools.services.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import net.mc.tools.helpers.ApiHelper;
import net.mc.tools.models.muteNotification.request.MuteNotificationRequestModel;

import java.util.List;

public class MuteNotificationService extends ApiHelper {

    public static Gson gson;

    public static Response muteNotification(List<MuteNotificationRequestModel> muteNotificationRequestModels, String token) {
        Response response;

        response = emailWithToken(token).body(gson().toJson(muteNotificationRequestModels.get(0))).post("email/mute-notification");

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
