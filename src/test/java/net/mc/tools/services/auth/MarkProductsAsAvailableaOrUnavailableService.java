package net.mc.tools.services.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import net.mc.tools.helpers.ApiHelper;
import net.mc.tools.models.markProductsAsAvailableaOrUnavailable.markProductsAsAvailableaOrUnavailableRequest.MarkProductsAsAvailableaOrUnavailableRequestModel;

import java.util.List;

public class MarkProductsAsAvailableaOrUnavailableService extends ApiHelper
{
    public static Gson gson;
    private static MarkProductsAsAvailableaOrUnavailableRequestModel markProductsAsAvailableaOrUnavailableRequestModel;

    public static Response MarkAvailablewithtoken(MarkProductsAsAvailableaOrUnavailableRequestModel markProductsAsAvailableaOrUnavailableRequestModel, String token) {
        Response response;
        System.out.println(gson().toJson(markProductsAsAvailableaOrUnavailableRequestModel));

        response = productWithToken(token).body(gson().toJson(markProductsAsAvailableaOrUnavailableRequestModel)).put("/product/mark-publish");

        return response;
    }

    public static Response MarkUnAvailablewithtoken(MarkProductsAsAvailableaOrUnavailableRequestModel markProductsAsAvailableaOrUnavailableRequestModel, String token) {
        Response response;

        response = productWithToken(token).body(gson().toJson(markProductsAsAvailableaOrUnavailableRequestModel)).put("/product/mark-unpublish");

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
