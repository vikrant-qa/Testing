package net.mc.tools.steps.api;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;
import net.mc.tools.models.countListOfUsers.CountListOfUsersRequest.CountListOfUsersRequest;
import net.mc.tools.models.countListOfUsers.CountListOfUsersRequest.CountListOfUsersRequestModel;
import net.mc.tools.models.countListOfUsers.CountListOfUsersRequest.Filter;
import net.mc.tools.models.countListOfUsers.CountListOfUsersRequest.UserRole;
import net.mc.tools.models.countListOfUsers.CountListOfUsersResponse.CountListOfUsersResponse;
import net.mc.tools.models.orders.request.CountListOfOrdersRequestModel;
import net.mc.tools.models.respnseForAllModel.ErrorResponseCommonForAll;
import net.mc.tools.services.auth.CountListOfUsersService;
import org.junit.Assert;

import java.util.List;

import static net.mc.tools.services.auth.RegisterService.gson;

public class CountListOfUsersSteps
{
    private static Response json_Response;
      private static CountListOfUsersResponse countListOfUsersResponse;
    private static ErrorResponseCommonForAll errorResponseCommonForAll;
    private static List<CountListOfUsersRequestModel> countListOfUsersRequestModelList;
    private List<UserRole> userRoleList;
    private List<Filter> filterList;
    private static int i=0;

    @Then("^user enters the userRole field of requester$")
    public void user_enters_the_userRole_field_of_requester(List<UserRole> userRoleList) throws Exception
    {
       this.userRoleList=userRoleList;
    }

    @Then("^user enters the filter field as type of users to fetch for requester$")
    public void user_enters_the_filter_field_as_type_of_users_to_fetch_for_requester(List<Filter> filterList) throws Exception
    {
        this.filterList=filterList;
    }


    @Then("^user should be able to get the list of user that he requested$")
    public void user_should_be_able_to_get_the_list_of_user_that_he_requested() throws Exception
    {

        Assert.assertTrue(json_Response.getStatusCode()==200);
        countListOfUsersResponse=gson().fromJson(json_Response.body().prettyPrint(),CountListOfUsersResponse.class);
        Assert.assertEquals("ok",countListOfUsersResponse.getStatus());
         System.out.println("countListOfUsersResponse.getData() is-------"+countListOfUsersResponse.getData());

    }

    @Then("^user should not be able to get the list of user that he requested and user should get validation messages$")
    public void user_should_not_be_able_to_get_the_list_of_user_that_he_requested(List<String> errorMessage) throws Exception
    {
        json_Response.body().prettyPrint();
        Assert.assertTrue(json_Response.getStatusCode()>=400);
        System.out.println("first i value is "+i);
        json_Response.body().prettyPrint();
        try
        {
            System.out.println(errorMessage.get(i));
            Assert.assertTrue(json_Response.getStatusCode() >= 400);
            errorResponseCommonForAll=gson().fromJson(json_Response.body().prettyPrint(), ErrorResponseCommonForAll.class);
            Assert.assertEquals("error",errorResponseCommonForAll.getStatus());
            Assert.assertEquals(errorMessage.get(i),errorResponseCommonForAll.getError());
            Assert.assertTrue(errorResponseCommonForAll.getData()==null);
        }finally
        {
            i++;
            if(errorMessage.size()==i)
            {
                i=0;
                System.out.println("i value in updated at last"+i);
            }
        }
    }



    @Then("^user enters the userRole field and filter field of requester$")
    public void user_enters_the_userRole_field_and_filter_field_of_requester(List<CountListOfUsersRequestModel> countListOfUsersRequestModelList) throws Exception
    {
        this.countListOfUsersRequestModelList=countListOfUsersRequestModelList;

    }

    @Then("^user make a request to fetch  the count of users$")
    public void user_make_a_request_to_fetch_the_count_of_users() throws Exception
    {

        System.out.println("**********Filter is ---"+countListOfUsersRequestModelList.get(0).getFilter()+"--user role is---"+ countListOfUsersRequestModelList.get(0).getuserRole()+"**************");

        json_Response=CountListOfUsersService.CountListOfUsersWithToken2(countListOfUsersRequestModelList,LoginSteps.token);

    }

}
