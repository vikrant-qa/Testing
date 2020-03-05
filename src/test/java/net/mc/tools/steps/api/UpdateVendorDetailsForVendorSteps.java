package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import net.mc.tools.models.respnseForAllModel.ErrorResponseCommonForAll;
import net.mc.tools.models.updateVendorDetailsForVendor.updateVendorDetailsForVendorRequest.UpdateVendorDetailsForVendorRequestModel;
import net.mc.tools.services.auth.UpdateVendorDetailsForVendorService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.UpdateVendorDetailsForVendorService.gson;

public class UpdateVendorDetailsForVendorSteps
{
    private static List<UpdateVendorDetailsForVendorRequestModel> updateVendorDetailsForVendorRequestModelList;
    private static Response json_Response;
    private static ErrorResponseCommonForAll errorResponseCommonForAll;
    private static int i=0;

    @Then("^user enters the details of vendor$")
    public void user_enters_the_details_of_vendor(List<UpdateVendorDetailsForVendorRequestModel> updateVendorDetailsForVendorRequestModelList1) throws Exception
    {
     this.updateVendorDetailsForVendorRequestModelList=updateVendorDetailsForVendorRequestModelList1;

    }

    @Then("^user make a request to update the vendor field by way of click on submit button$")
    public void user_make_a_request_to_update_the_vendor_field_by_way_of_click_on_submit_button() throws Exception
    {

    json_Response= UpdateVendorDetailsForVendorService.UpdateVendorDetailsForVendor_with_Token(updateVendorDetailsForVendorRequestModelList,LoginSteps.token);
    }

    @Then("^user should be able to update the vendor field that he requested$")
    public void user_should_be_able_to_update_the_vendor_field_that_he_requested() throws Exception
    {
        json_Response.body().prettyPrint();
        Assert.assertTrue(json_Response.statusCode()==200);
    }

    @Then("^user should not be able to update the vendor field that he requested and user should get validation mesaage$")
    public void user_should_not_be_able_to_update_the_vendor_field_that_he_requested_and_user_should_get_validation_mesaage(List<String> errorMessage) throws Exception
    {
        try {
            json_Response.body().prettyPrint();
            Assert.assertTrue(json_Response.getStatusCode() >= 400);
            errorResponseCommonForAll = gson().fromJson(json_Response.body().prettyPrint(), ErrorResponseCommonForAll.class);
            Assert.assertEquals("error", errorResponseCommonForAll.getStatus());
            Assert.assertTrue(errorResponseCommonForAll.getData() == null);
            Assert.assertEquals(errorMessage.get(i), errorResponseCommonForAll.getError());
        }
        finally
        {
            i++;
            if (errorMessage.size()==i)
            {
                i++;
            }
        }
    }
}
