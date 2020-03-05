package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.mc.tools.helpers.HelperClass;
import net.mc.tools.models.IdFetchOrderDataRow.IdFetchOrderDataRowRequest.IdFetchOrderDataRowRequestModel;
import net.mc.tools.models.IdFetchOrderDataRow.IdFetchOrderDataRowResponse.IdFetchOrderDataRowResponseModel;
import net.mc.tools.models.token.TokenMessageRequestModel;
import net.mc.tools.services.auth.IdFetchOrderDataRowService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.IdFetchOrderDataRowService.gson;

public class IdFetchOrderDataRowSteps
{
    private static List<IdFetchOrderDataRowRequestModel> idFetchOrderDataRowRequestModelList;
    private static Response json_Response;
    private static IdFetchOrderDataRowResponseModel idFetchOrderDataRowResponseModel;



    @When("^user enters the Object id of order and Object id of user who is sending the request$")
    public void user_enters_the_Object_id_of_order_and_Object_id_of_user_who_is_sending_the_request(List<IdFetchOrderDataRowRequestModel> idFetchOrderDataRowRequestModelList1) throws Exception
    {
      this.idFetchOrderDataRowRequestModelList=idFetchOrderDataRowRequestModelList1;
    }

    @When("^user make a request to fetch one row details of desired order$")
    public void user_make_a_request_to_fetch_one_row_details_of_desired_order() throws Exception
    {
      json_Response= IdFetchOrderDataRowService.req(idFetchOrderDataRowRequestModelList,LoginSteps.token);
    }

    @When("^user make a request for order details with Incorrect/blank token field in form of without login credentials$")
    public void user_make_a_request_for_order_details_with_Incorrectblank_token_field_in_form_of_without_login_credentials(List<TokenMessageRequestModel> tokenMessageRequestModelList) throws Exception
    {
        json_Response= IdFetchOrderDataRowService.req(idFetchOrderDataRowRequestModelList,tokenMessageRequestModelList.get(0).gettoken());
    }

    @Then("^user should be able to fetch one row details of desired order$")
    public void user_should_be_able_to_fetch_one_row_details_of_desired_order() throws Exception
    {
        Assert.assertTrue(json_Response.getStatusCode()==200);
        idFetchOrderDataRowResponseModel=gson().fromJson(json_Response.body().prettyPrint(),IdFetchOrderDataRowResponseModel.class);
        Assert.assertEquals("ok",idFetchOrderDataRowResponseModel.getStatus());
        Assert.assertTrue(idFetchOrderDataRowResponseModel.getOrder().get_id().equals(idFetchOrderDataRowRequestModelList.get(0).getId())
                ||!idFetchOrderDataRowResponseModel.getOrder().getShopifyOrderId().isEmpty()
                ||!idFetchOrderDataRowResponseModel.getOrder().getShop().isEmpty()
                ||!idFetchOrderDataRowResponseModel.getOrder().getSellerId().isEmpty()
                ||!idFetchOrderDataRowResponseModel.getOrder().getStatus().isEmpty()
                ||!idFetchOrderDataRowResponseModel.getOrder().getFulfillmentStatus().isEmpty()
                ||!idFetchOrderDataRowResponseModel.getOrder().getTotalPrice().isEmpty()
                ||!idFetchOrderDataRowResponseModel.getOrder().getCreatedAt().isEmpty());
    }


    @Then("^user should not be able to fetch one row details of desired order that he requested and user shuld get a validation message$")
    public void user_should_not_be_able_to_fetch_one_row_details_of_desired_order_that_he_requested_and_user_shuld_get_a_validation_message(List<String> errorMessage) throws Exception
    {
        HelperClass.ErrorValidationPage(json_Response,errorMessage);
    }

}
