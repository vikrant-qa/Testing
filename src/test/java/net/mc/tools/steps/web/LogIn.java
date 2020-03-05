package net.mc.tools.steps.web;

import com.typesafe.config.Config;
import cucumber.api.java.en.Given;
import net.mc.tools.pages.LogInPage;
import net.mc.tools.utilities.ConfigLoader;

public class LogIn {

    static Config conf = ConfigLoader.load();

    LogInPage logInPage;

    @Given("^User tries to login on mc system$")
    public void userLoginInMcSystem() {


        logInPage.openUrl(conf.getString("webdriver.base.url"));

    }
}
