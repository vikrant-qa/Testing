package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.helpers.HelperClass;
import net.mc.tools.models.deleteProductImage.deleteProductImageRequestModel.DeleteProductImageRequest;
import net.mc.tools.models.token.TokenMessageRequestModel;
import net.mc.tools.services.auth.DeleteProductImageServices;
import net.mc.tools.services.auth.MarkProductsAsAvailableaOrUnavailableService;
import org.junit.Assert;

import java.util.List;

public class DeleteProductImageSteps
{
    private static Response jsonResponse;
    private static List<DeleteProductImageRequest> deleteProductImageRequestList;


    @When("^user enters the details of productId , url of image and sellerid from seller products$")
    public void user_enters_the_details_of_productId_url_of_image_and_sellerid_from_seller_products(List<DeleteProductImageRequest> deleteProductImageRequestList) throws Exception
    {
     this.deleteProductImageRequestList=deleteProductImageRequestList;
    }

    @When("^user enters the details of productId , url of image and vendorid from vendor products$")
    public void user_enters_the_details_of_productId_url_of_image_and_vendorid_from_vendor_products(List<DeleteProductImageRequest> deleteProductImageRequestList) throws Exception
    {
        this.deleteProductImageRequestList=deleteProductImageRequestList;
    }

    @When("^User make a request to delete the image of product$")
    public void user_make_a_request_to_delete_the_image_of_product() throws Exception
    {
        jsonResponse= DeleteProductImageServices.deleteProductImageRequest(deleteProductImageRequestList,LoginSteps.token);
        deleteProductImageRequestList=null;

    }

    @Then("^user should be able to delete the image of product$")
    public void user_should_be_able_to_delete_the_image_of_product() throws Exception
    {
        jsonResponse.body().prettyPrint();
        Assert.assertTrue((jsonResponse.getStatusCode()==200));
    }

    @Then("^user should not be able to delete the image of product and user should get a validation message$")
    public void user_should_not_be_able_to_delete_the_image_of_product(List<String> errorMessage) throws Exception
    {
        HelperClass.ErrorValidationPage(jsonResponse,errorMessage);
        jsonResponse=null;
    }


    @When("^User make a request to delete the image of product with Incorrect/blank token field in form of without login credentials$")
    public void user_make_a_request_delete_the_image_of_product_with_Incorrect_blank_token_field_in_form_of_without_login_credentials(List<TokenMessageRequestModel> tokenMessageRequestModelList) throws Exception
    {
        jsonResponse= DeleteProductImageServices.deleteProductImageRequest(deleteProductImageRequestList,tokenMessageRequestModelList.get(0).gettoken());
        deleteProductImageRequestList=null;

    }

}
