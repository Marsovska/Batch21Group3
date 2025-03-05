package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;

public class LoginSteps extends CommonMethods {


    @When("the user enters invalid username and valid password")
    public void the_user_enters_invalid_username_and_valid_password() {
        sentText("NotAdmin", loginPage.loginUsernameField);
        sentText(ConfigReader.read("password"), loginPage.loginPasswordField);
    }

    @When("the user enters valid username and invalid password")
    public void the_user_enters_valid_username_and_invalid_password() {
        sentText(ConfigReader.read("username"), loginPage.loginUsernameField);
        sentText("NotPassword", loginPage.loginPasswordField);
    }


    @Then("an error message {string} should be displayed")
    public void anErrorMessageIndicatingInvalidUsernameOrPasswordShouldBeDisplayed(String loginErrorMessage) {
        String displayedError = loginPage.invalidMessage.getText();
        Assert.assertEquals(loginErrorMessage, displayedError);
    }

    @When("the user leaves the username field empty")
    public void theUserLeavesTheUsernameFieldEmpty() {
        loginPage.loginUsernameField.clear();
        sentText(ConfigReader.read("password"), loginPage.loginPasswordField);
    }

    @When("the user leaves the password field empty")
    public void theUserLeavesThePasswordFieldEmpty() {
        sentText(ConfigReader.read("username"), loginPage.loginUsernameField);
        loginPage.loginPasswordField.clear();
    }


    @Then("the user should be redirected to the admin {string} page")
    public void theUserShouldBeRedirectedToTheAdminPage(String dashboard) {
        String expected = creatingLogCredentialsPage.dashboardPage.getText();
        Assert.assertEquals(expected.toLowerCase(), dashboard.toLowerCase());
    }
}
