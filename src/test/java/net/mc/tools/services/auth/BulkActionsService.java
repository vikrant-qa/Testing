package net.mc.tools.services.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import net.mc.tools.helpers.ApiHelper;
import net.mc.tools.models.bulkInvite.request.BulkInviteByDataRequestModel;
import net.mc.tools.models.orders.request.BulkActionsRequestModel;
import net.mc.tools.models.updateUserSetting.request.UpdateUserSettingRequestModel;
import org.jruby.RubyProcess;

import java.util.List;

public class BulkActionsService extends ApiHelper {

    public static Gson gson;

    public static Response requestWithToken(List<BulkActionsRequestModel> bulkActionsRequestModels, String token) {
        Response response;

        response = orderWithToken(token).body(gson().toJson(bulkActionsRequestModels.get(0))).put("order/bulk-action");
        System.out.println(response.getBody().prettyPrint());
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
