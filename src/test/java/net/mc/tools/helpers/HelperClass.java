package net.mc.tools.helpers;

import com.jayway.restassured.response.Response;
import net.mc.tools.models.respnseForAllModel.ErrorResponseCommonForAll;
import net.mc.tools.services.auth.RegisterService;
import org.junit.Assert;

import java.util.List;

public class HelperClass
{
    private static ErrorResponseCommonForAll errorResponseCommonForAll;
    private static int i=0;

    public static void ErrorValidationPage(Response jsonResponse, List<String> errorMessage)
    {
        jsonResponse.body().prettyPrint();
        System.out.println("**********************Expected error message is --("+ errorMessage.get(i)+")*************************");
        try
        {
            {
                if (jsonResponse.getStatusCode() >= 400) {
                    errorResponseCommonForAll = RegisterService.gson().fromJson(jsonResponse.body().prettyPrint(), ErrorResponseCommonForAll.class);
                    Assert.assertEquals("error", errorResponseCommonForAll.getStatus());
                    Assert.assertTrue(errorResponseCommonForAll.getData() == null);
                    if(errorMessage.get(i).equalsIgnoreCase(errorResponseCommonForAll.getError()))
                    {
                        Assert.assertEquals(errorMessage.get(i), errorResponseCommonForAll.getError());
                    }
                    else
                    {
                        System.out.println("********************Expected error message--(" + errorMessage.get(i) + ")is not match with actual error message --(" + errorResponseCommonForAll.getError() + ") and Logged a bug for this defect************************* ");
                        Assert.assertEquals(errorMessage.get(i), errorResponseCommonForAll.getError());
                    }

                } else {
                    System.out.println("********************Expected error message--(" + errorMessage.get(i) + ")is not found and Logged a bug for this defect************************* ");
                    Assert.assertTrue(jsonResponse.getStatusCode() >= 400);
                }
            }
        }
        catch (Exception error)
        {
            error.printStackTrace();
            System.out.println("********************Expected error message--("+ errorMessage.get(i)+")is not found and Logged a bug for this defect************************* ");
        }
        finally
        {
            i++;
            if (errorMessage.size()==i)
            {
                i=0;
                System.out.println(" i's value, has now been updated as  ----("+i+")");
            }

        }
    }
}
