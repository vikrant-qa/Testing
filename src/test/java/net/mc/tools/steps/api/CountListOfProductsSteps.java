package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.countListOfProducts.countListOfProductsRequest.CountListOfProductsRequestModel;
import net.mc.tools.models.countListOfProducts.countListOfProductsResponse.CountListOfProductsResponseModel;
import net.mc.tools.models.orders.request.CountListOfOrdersRequestModel;
import net.mc.tools.services.auth.CountListOfOrdersService;
import net.mc.tools.services.auth.CountListOfProductsService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class CountListOfProductsSteps
{
    private static Response jsonResponse;
    private static CountListOfProductsResponseModel countListOfProductsResponseModel;

    @When("^User enters details to count of list products$")
    public void userEnterDetailsToGetCountOfList_products(List<CountListOfProductsRequestModel> countListOfProductsRequestModelList)
    {
        System.out.println("Now user enter filter -("+countListOfProductsRequestModelList.get(0).getFilter()+")");
        jsonResponse = CountListOfProductsService.requestWithToken(countListOfProductsRequestModelList,LoginSteps.token);
    }

    @Then("^User should be able to count list of products that he requested$")
    public void User_should_be_able_to_count_list_of_products_that_he_requested()
    {
        Assert.assertTrue(jsonResponse.getStatusCode() == 200);
        countListOfProductsResponseModel = gson().fromJson(jsonResponse.body().prettyPrint(), CountListOfProductsResponseModel.class);
        Assert.assertTrue(countListOfProductsResponseModel.getData()>=0);
        Assert.assertEquals("ok", countListOfProductsResponseModel.getStatus());
    }
}
