package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AddingEmployeePage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;

public class AddingEmployeeSteps extends CommonMethods {


    @When("the user enters valid admin credentials")
    public void the_user_enters_valid_admin_credentials() {
        sentText(ConfigReader.read("username"), loginPage.loginUsernameField);
        sentText(ConfigReader.read("password"), loginPage.loginPasswordField);
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        clickOnElement(loginPage.loginButton);
    }

    @Then("the user should be redirected to the admin {string} page")
    public void the_user_should_be_redirected_to_the_admin_page(String dashboard) {
        String expected = addingEmployeePage.dashboardPage.getText();
        Assert.assertEquals(expected.toLowerCase(), dashboard.toLowerCase());
    }

    @And("the user navigates to the PIM tab")
    public void the_user_navigates_to_the_pim_tab() {
        clickOnElement(addingEmployeePage.PIMTab);
    }

    @And("the user clicks on the Add Employee tab")
    public void the_user_clicks_on_the_add_employee_tab() {
        clickOnElement(addingEmployeePage.addEmployeeTab);
    }

    @When("the user enters {string}, {string}, {string} as employee details")
    public void the_user_enters_as_employee_details(String firstName, String middleName, String lastName) {
        sentText(firstName, addingEmployeePage.firstNameField);
        sentText(middleName, addingEmployeePage.middleNameField);
        sentText(lastName, addingEmployeePage.lastNameField);
    }

    @And("the user provides {string} as the employee ID")
    public void the_user_provides_as_the_employee_id(String employeeId) {
        addingEmployeePage.employeeIdField.clear();
        sentText(employeeId, addingEmployeePage.employeeIdField);
    }

    @And("the user clicks the save button")
    public void the_user_clicks_the_save_button() {
        clickOnElement(addingEmployeePage.saveButton);
    }

    @Then("the system should generate a unique employee ID")
    public void the_system_should_generate_a_unique_employee_id() {
        Assert.assertNotNull(addingEmployeePage.generatedEmployeeIdField.getAttribute("value"));
    }

    @Then("the employee record should be saved in the database")
    public void the_employee_record_should_be_saved_in_the_database() {
        // Add database verification logic here
    }

    @Then("the user should see an error message {string}")
    public void the_user_should_see_an_error_message(String expectedErrorMessage) {
        String actualErrorMessage = addingEmployeePage.requiredErrorMessage.getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Then("the system should save the employee with the provided ID")
    public void theSystemShouldSaveTheEmployeeWithTheProvidedID() {
        // Add logic to verify employee ID


    }
}