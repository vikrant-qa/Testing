package net.mc.tools.services.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.response.Response;
import net.mc.tools.helpers.ApiHelper;
import net.mc.tools.models.sendEmailModel.request.SendEmailRequestModel;

import java.util.List;

public class SendEmailService extends ApiHelper
{
    public static Gson gson;

    public  static Response sendemail(List<SendEmailRequestModel> sendEmailRequest)
    {
        Response sendEmailResponse;
        sendEmailResponse=emailWithoutToken().body(gson().toJson(sendEmailRequest.get(0))).post("send-email");
        return sendEmailResponse;
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
