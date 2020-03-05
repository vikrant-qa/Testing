package net.mc.tools.services.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import net.mc.tools.helpers.ApiHelper;
import net.mc.tools.models.createandRemoveAssociation.CreateandRemoveAssociationRequest.CreateAssociationRequest;
import net.mc.tools.models.createandRemoveAssociation.CreateandRemoveAssociationRequest.RemoveAssociationRequest;

import java.util.List;

public class CreateandRemoveAssociationService extends ApiHelper
{
    public static Gson gson;

    public static Response createAssociationrequestWithToken(List<CreateAssociationRequest> createAssociationRequestList, String token) {
        Response response;
        response = authWithToken(token).body(gson().toJson(createAssociationRequestList.get(0))).post("user/association");
        return response;
    }
    public static Response removeAssociationrequestWithToken(List<RemoveAssociationRequest> removeAssociationRequestsList, String token) {

        Response response;
        response = authWithToken(token).body(gson().toJson(removeAssociationRequestsList.get(0))).delete("user/association");
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
