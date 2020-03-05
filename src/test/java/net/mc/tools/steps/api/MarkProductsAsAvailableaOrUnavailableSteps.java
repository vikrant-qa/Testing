package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.helpers.HelperClass;
import net.mc.tools.models.markProductsAsAvailableaOrUnavailable.markProductsAsAvailableaOrUnavailableRequest.MarkProductsAsAvailableaOrUnavailableRequestModel;
import net.mc.tools.models.markProductsAsAvailableaOrUnavailable.markProductsAsAvailableaOrUnavailableResponse.MarkProductsAsAvailableaOrUnavailableResponseModel;
import net.mc.tools.models.token.TokenMessageRequestModel;
import net.mc.tools.services.auth.MarkProductsAsAvailableaOrUnavailableService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.MarkProductsAsAvailableaOrUnavailableService.gson;

public class MarkProductsAsAvailableaOrUnavailableSteps
{
    private static List<MarkProductsAsAvailableaOrUnavailableRequestModel> ObjectIdOfProductList;
    private static MarkProductsAsAvailableaOrUnavailableRequestModel markProductsAsAvailableaOrUnavailableRequestModel=new MarkProductsAsAvailableaOrUnavailableRequestModel();
    private static Response jsonResoponse;
    private static MarkProductsAsAvailableaOrUnavailableResponseModel markProductsAsAvailableaOrUnavailableResponseModel;
    private static String ids[],ids1[];

    @When("^user enters the Object ids of product$")
    public void user_enters_the_Object_ids_of_product(List<String> ObjectIdOfProduct) throws Exception
    {
        ids=ObjectIdOfProduct.toArray(new String[ObjectIdOfProduct.size()]);
        markProductsAsAvailableaOrUnavailableRequestModel.setIds(ids);
        for(int i=0;i<ids.length;i++)
        {
            System.out.print(ids[i]+"     ");
        }

    }

    @When("^user make a request to mark the Products as a Unavailable for customers$")
    public void user_make_a_request_to_mark_the_Products_as_a_Unavailable_for_customers() throws Exception
    {
        jsonResoponse=null;
        jsonResoponse= MarkProductsAsAvailableaOrUnavailableService.MarkUnAvailablewithtoken(markProductsAsAvailableaOrUnavailableRequestModel,LoginSteps.token);
        markProductsAsAvailableaOrUnavailableRequestModel.setIds(null);
    }

    @Then("^user should be able to mark the Products as a Unavailable$")
    public void user_should_be_able_to_mark_the_Products_as_a_Unavailable() throws Exception
    {
        if (jsonResoponse.getStatusCode()==200)
        {
            Assert.assertTrue(jsonResoponse.getStatusCode()==200);
            markProductsAsAvailableaOrUnavailableResponseModel=gson().fromJson(jsonResoponse.body().prettyPrint(),MarkProductsAsAvailableaOrUnavailableResponseModel.class);
            Assert.assertEquals("ok",markProductsAsAvailableaOrUnavailableResponseModel.getStatus());
            Assert.assertTrue(markProductsAsAvailableaOrUnavailableResponseModel.getData()==true);

        }
        else {
            jsonResoponse.body().prettyPrint();
            System.out.println(" *****************Actual response is not match with expected Response  ************************");
        }
    }

    @Then("^user should not be able to mark the Products as a Unavailable and user should get a validation message$")
    public void user_should_not_be_able_to_mark_the_Products_as_a_Unavailable(List<String> errorMessage) throws Exception
    {
        HelperClass.ErrorValidationPage(jsonResoponse,errorMessage);

    }

    @When("^user make a request to mark the Products as a Available for customers$")
    public void user_make_a_request_to_mark_the_Products_as_a_Available_for_customers() throws Exception
    {
        jsonResoponse=null;
        jsonResoponse= MarkProductsAsAvailableaOrUnavailableService.MarkAvailablewithtoken(markProductsAsAvailableaOrUnavailableRequestModel,LoginSteps.token);
        markProductsAsAvailableaOrUnavailableRequestModel.setIds(null);
    }

    @Then("^user should be able to mark the Products as a Available$")
    public void user_should_be_able_to_mark_the_Products_as_a_Available() throws Exception
    {if (jsonResoponse.getStatusCode()==200)
    {
        Assert.assertTrue(jsonResoponse.getStatusCode()==200);
        markProductsAsAvailableaOrUnavailableResponseModel=gson().fromJson(jsonResoponse.body().prettyPrint(),MarkProductsAsAvailableaOrUnavailableResponseModel.class);
        Assert.assertEquals("ok",markProductsAsAvailableaOrUnavailableResponseModel.getStatus());
        Assert.assertTrue(markProductsAsAvailableaOrUnavailableResponseModel.getData()==true);
    }
    else {
        jsonResoponse.body().prettyPrint();
        System.out.println(" *****************Actual response is not match with expected Response  ************************");
    }
    }


    @Then("^user should not be able to mark the Products as a Available and user should get a validation message$")
    public void user_should_not_be_able_to_mark_the_Products_as_a_Available(List<String> errorMessage) throws Exception
    {
        HelperClass.ErrorValidationPage(jsonResoponse,errorMessage);

    }

    @When("^user make a request to mark product as avaliable with Incorrect/blank token field in form of without login credentials$")
    public void user_make_a_request_to_mark_product_as_avaliable_with_Incorrect_blank_token_field_in_form_of_without_login_credentials(List<TokenMessageRequestModel> tokenMessageRequestModelList) throws Exception
    {
       jsonResoponse=MarkProductsAsAvailableaOrUnavailableService.MarkAvailablewithtoken(markProductsAsAvailableaOrUnavailableRequestModel,tokenMessageRequestModelList.get(0).gettoken());
    }


    @When("^user make a request to mark product as Unavaliable with Incorrect/blank token field in form of without login credentials$")
    public void user_make_a_request_to_mark_product_as_Unavaliable_with_Incorrect_blank_token_field_in_form_of_without_login_credentials(List<TokenMessageRequestModel> tokenMessageRequestModelList) throws Exception
    {
        jsonResoponse=MarkProductsAsAvailableaOrUnavailableService.MarkUnAvailablewithtoken(markProductsAsAvailableaOrUnavailableRequestModel,tokenMessageRequestModelList.get(0).gettoken());
    }

    @When("^user enters the Object ids of product1$")
    public void user_enters_the_Object_ids_of_product1(List<String> ObjectIdOfProduct) throws Exception
    {

        System.out.println(ObjectIdOfProduct+"");
        ids=new String[ObjectIdOfProduct.size()];
        System.out.println("\n");
        for(int i=0;i<ids.length;i++)
        {
            ids[i]=ObjectIdOfProduct.get(i);
            System.out.print(ids[i]+"      ");
        }
        System.out.println("\n");
        for(int i=0;i<ids.length;i++)
        {
            System.out.print(ids[i]+"     ");
        }



        System.out.println("\n");
        markProductsAsAvailableaOrUnavailableRequestModel.setIds(ids);
        ids1=markProductsAsAvailableaOrUnavailableRequestModel.getIds();
        for(int i=0;i<ids1.length;i++)
        {

            System.out.print(ids1[i]+"     ");
        }
    }


}
