package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.models.registerSupplier.request.Message;
import net.mc.tools.models.registerSupplier.request.RegisterSupplierRequestModel;
import net.mc.tools.models.registerSupplier.response.RegisterSupplierErrorResponseModel;
import net.mc.tools.models.registerSupplier.response.RegisterSupplierResponseModel;
import net.mc.tools.services.auth.RegisterSupplierService;
import net.mc.tools.utilities.RandomGenerator;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class RegisterSupplierSteps {

    private Response response;
    private RegisterSupplierResponseModel registerSupplierResponseModel;
    private RegisterSupplierErrorResponseModel registerSupplierErrorResponseModel;
    private String message;
    static private int temp = 0;

    @When("^user enter details of vendor")
    public void userEnterDetails(List<RegisterSupplierRequestModel> registerSupplierRequestModels) {
        if(!registerSupplierRequestModels.get(0).getEmail().isEmpty())
            if(!registerSupplierRequestModels.get(0).getEmail().equalsIgnoreCase("invalid"))
                registerSupplierRequestModels.get(0).setEmail(registerSupplierRequestModels.get(0).getEmail()+ RandomGenerator.randomAlphanumeric(5)+"@mailinator.com");
            else if(registerSupplierRequestModels.get(0).getEmail().equalsIgnoreCase("invalid"))
                registerSupplierRequestModels.get(0).setEmail(registerSupplierRequestModels.get(0).getEmail());
            else{}

        response = RegisterSupplierService.registerSupplier(registerSupplierRequestModels, LoginSteps.token);

    }

    @Then("^Vendor should be registered successfully into the system$")
    public void userShouldBeRegister()  {
        Assert.assertTrue(response.getStatusCode() == 200);
        registerSupplierResponseModel = gson().fromJson(response.body().prettyPrint(), RegisterSupplierResponseModel.class);
        Assert.assertEquals("ok" , registerSupplierResponseModel.getStatus());
        Assert.assertTrue(registerSupplierResponseModel.getData().getOtp() != null);
    }

    @And("^enter error Message$")
    public void setMessage(List<Message> msg){

        message = msg.get(temp++).getMessage();

    }
    @Then("^Vendor should not be registered successfully into the system$")
    public void userShouldNotBeRegister()  {
        Assert.assertTrue(response.getStatusCode() == 422);
        registerSupplierErrorResponseModel = gson().fromJson(response.body().prettyPrint(), RegisterSupplierErrorResponseModel.class);
        Assert.assertEquals("error" , registerSupplierErrorResponseModel.getStatus());
        Assert.assertEquals(message, registerSupplierErrorResponseModel.getError());
    }
}