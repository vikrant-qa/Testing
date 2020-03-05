package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.addProduct.request.AddProductRequestModel;
import net.mc.tools.models.addProduct.response.AddProductErrorResponseModel;
import net.mc.tools.models.addProduct.response.AddProductResponseModel;
import net.mc.tools.models.register.request.RegisterRequestModel;
import net.mc.tools.models.register.response.RegisterResponseModel;
import net.mc.tools.models.registerSupplier.request.Message;
import net.mc.tools.services.auth.AddProductService;
import net.mc.tools.services.auth.RegisterService;
import net.mc.tools.utilities.RandomGenerator;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class AddProductBySellerSteps {

    String message = null;
    static int temp = 0;
    private Response response;
    private AddProductResponseModel addProductResponseModel;
    private AddProductErrorResponseModel addProductErrorResponseModel;

    @When("^user enter details of product$")
    public void userRequestToAddProduct(List<AddProductRequestModel> addProductRequestModel) {
        if(!addProductRequestModel.get(0).getHandle().isEmpty())
            addProductRequestModel.get(0).setHandle(addProductRequestModel.get(0).getHandle()+RandomGenerator.randomAlphanumeric(5));
        response = AddProductService.requestWithToken(addProductRequestModel,LoginSteps.token);
        System.out.println(response.getBody().prettyPrint());
    }

    @Then("^product should be added to system$")
    public void userShouldBeRegisteredSuccessfullyIntoTheSystem() {
        Assert.assertTrue(response.getStatusCode() == 200);
        addProductResponseModel = gson().fromJson(response.body().prettyPrint(), AddProductResponseModel.class);
        Assert.assertEquals("ok", addProductResponseModel.getStatus());
        Assert.assertTrue(addProductResponseModel.getData() != null);
    }

    @And("^enter error message to be validate$")
    public void setMessage(List<Message> msg){

        message = msg.get(temp++).getMessage();

    }

    @Then("^product should not be added to system and error message should be verified$")
    public void productShouldNotBeAdded() {
        Assert.assertTrue(response.getStatusCode() == 422);
        addProductErrorResponseModel = gson().fromJson(response.body().prettyPrint(), AddProductErrorResponseModel.class);
        Assert.assertEquals("error", addProductErrorResponseModel.getStatus());
        Assert.assertEquals(message, addProductErrorResponseModel.getError());
        Assert.assertTrue(addProductErrorResponseModel.getData() == null);
    }
}
