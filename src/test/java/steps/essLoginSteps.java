package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ConfigReader;

public class essLoginSteps extends CommonMethods {

    @When("user enters their essUsername and essPassword")
    public void user_enters_their_ess_username_and_ess_password() {
        sentText(ConfigReader.read("username"), loginPage.loginUsernameField);
        sentText(ConfigReader.read("password"), loginPage.loginPasswordField);

    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        clickOnElement(loginPage.loginButton);
    }

    @Then("user lands on Dashboard page")
    public void user_lands_on_dashboard_page() {
        Assert.assertTrue(ESS_dashboard_Page.welcomeText.isDisplayed());
        System.out.println("Test passed");
    }

    @When("user selects My Info tab")
    public void user_selects_my_info_tab() {
        clickOnElement(ESS_dashboard_Page.myInfoOption);
    }

    @When("user clicks Edit button")
    public void user_clicks_edit_button() {
        clickOnElement(ESS_user_update_Page.editButton);
    }
}