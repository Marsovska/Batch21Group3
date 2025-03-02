package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ConfigReader;

public class CreatingLogCredentialSteps extends CommonMethods {

    @When("admin enter login credentials and submits")
    public void admin_enter_login_credentials_and_submits() {
        sentText(ConfigReader.read("username"), loginPage.loginUsernameField);
        sentText(ConfigReader.read("password"), loginPage.loginPasswordField);
        clickOnElement(loginPage.loginButton);
    }

    @Then("admin lands {string} page")
    public void admin_lands_page(String dashboard) {
        String expected = creatingLogCredentialsPage.dashboardPage.getText();
        Assert.assertTrue("Expected to be on " + dashboard +
                " page, but was on " + expected, expected.contains(dashboard));


    }

    @Then("admin click on PIM tab")
    public void admin_click_on_pim_tab() {
        clickOnElement(creatingLogCredentialsPage.PIMTab);
    }

    @Then("admin click on AddEmployee tab")
    public void admin_click_on_add_employee_tab() {
        clickOnElement(creatingLogCredentialsPage.addEmployeeTab);
    }

    @When("admin enter {string}, {string} and {string}")
    public void admin_enter_and(String firstName, String middleName, String lastName) {
        creatingLogCredentialsPage.firstNameField.sendKeys(firstName);
        creatingLogCredentialsPage.middleNameField.sendKeys(middleName);
        creatingLogCredentialsPage.lastNameField.sendKeys(lastName);

    }

    @When("admin check Create Login Details box")
    public void admin_check_create_login_details_box() {
        clickOnElement(creatingLogCredentialsPage.createLogDetailsBox);
    }

    @Then("admin sees clear rule message about password")
    public void admin_sees_clear_rule_message_about_password() {
        System.out.println(creatingLogCredentialsPage.passwordRuleText.getText());
    }

    @When("admin set {string}, {string}, {string} as user credentials")
    public void admin_set_as_user_credentials(String username, String password, String confirmPassword) {
        creatingLogCredentialsPage.userNameField.sendKeys(username);
        creatingLogCredentialsPage.passwordField.sendKeys(password);
        creatingLogCredentialsPage.confirmPasswordField.sendKeys(confirmPassword);
    }

    @When("admin make sure status is enabled")
    public void admin_make_sure_status_is_enabled() {
        Assert.assertTrue(creatingLogCredentialsPage.statusDropdown.isEnabled());
    }

    @When("admin click save button")
    public void admin_click_save_button() {
        clickOnElement(creatingLogCredentialsPage.saveButton);
    }

    @Then("admin ends on {string} page")
    public void admin_ends_on_page(String personalDetailPage) {
        String expected = creatingLogCredentialsPage.personalDetailPage.getText();
        Assert.assertTrue("Expected to be on " + personalDetailPage +
                " page, but was on " + expected, expected.contains(personalDetailPage));


    }

    @Then("the system should automatically generate employee ID")
    public void the_system_should_automatically_generate_employee_id() {
        Assert.assertNotNull(creatingLogCredentialsPage.employeeIDField.getText());
        System.out.println(creatingLogCredentialsPage.employeeIDField.getText());
    }

    @Then("admin logs out")
    public void admin_logs_out() {
        clickOnElement(creatingLogCredentialsPage.welcomeTextBox);
        clickOnElement(creatingLogCredentialsPage.logOutButton);
    }


    @Then("employee shall be able to login with {string}, {string} and get {string} message")
    public void employee_shall_be_able_to_login_with_and_get_message(String username, String password, String expectedMsg) {
        loginPage.loginUsernameField.sendKeys(username);
        loginPage.loginPasswordField.sendKeys(password);
        clickOnElement(loginPage.loginButton);
        String actualMsg = creatingLogCredentialsPage.welcomeTextBox.getText();
        Assert.assertEquals(expectedMsg, actualMsg);
    }


    @Then("admin shall get an error message {string}")
    public void admin_shall_get_an_error_message(String expectedErrorMessage) {
        String actualErrMsg = creatingLogCredentialsPage.passErrorMsg.getText();

        Assert.assertEquals(expectedErrorMessage, actualErrMsg);

    }

    @Then("admin gets an error message {string}")
    public void admin_gets_an_error_message(String expectedErrMsg) {
        String actualErrorMessage = creatingLogCredentialsPage.requiredFieldsError.getText();
        Assert.assertEquals(expectedErrMsg, actualErrorMessage);
    }

    @Then("admin set Status as Disabled")
    public void admin_set_status_as_disabled() {
        clickOnElement(creatingLogCredentialsPage.statusDropdown);
        clickOnElement(creatingLogCredentialsPage.disabledSelection);
    }

    @Then("employee shall not be able to login using {string}, {string} as credentials")
    public void employee_shall_not_be_able_to_login_using_as_credentials(String username, String password) {
        loginPage.loginUsernameField.sendKeys(username);
        loginPage.loginPasswordField.sendKeys(password);
        clickOnElement(loginPage.loginButton);
    }

    @Then("employee will get {string} error message")
    public void employee_will_get_error_message(String expectedError) {
        String actualErrorMessage = creatingLogCredentialsPage.accountDisabledError.getText();
        Assert.assertEquals(expectedError, actualErrorMessage);
    }

}