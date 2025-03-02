package steps;/*package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonMethods;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ConfigReader;
import utils.DbUtils;

import java.io.IOException;

public class EmployeeDependentsSteps extends CommonMethods {

    @Given("user is logged into HRMS application")
    public void user_is_logged_into_hrms_application() {
        sentText(ConfigReader.read("username"), loginPage.loginUsernameField);
        sentText(ConfigReader.read("password"), loginPage.loginPasswordField);
        clickOnElement(loginPage.loginButton);
    }

    @And("user navigates to employee profile with Id {string}")
    public void userNavigatesToEmployeeProfileWithId(String expectedEmployeeID) {
        clickOnElement(drDashboardPage.pimOption);
        clickOnElement(drDashboardPage.employeeListOption);

        String actualID = employeeSearchPage.personalDetailsTab.getText();
        Assert.assertEquals(expectedEmployeeID,actualID);
        clickOnElement(employeeSearchPage.personalDetailsTab);
    }
//    @Given("user navigates to employee profile with ID {string}")
//    public void user_navigates_to_employee_profile_with_ID(String dependentEmployeeID) {
//        clickOnElement(drDashboardPage.pimOption);
//        clickOnElement(drDashboardPage.employeeListOption);
//
//        sentText(employeeId, employeeSearchPage.idSearchField);
//        clickOnElement(employeeSearchPage.searchButton);
//
//        WebElement employeeLink = driver.findElement(By.xpath("//a[contains(@href, '/pim/viewEmployee/empNumber/" + employeeId + "')]"));
//        clickOnElement(employeeLink);
//
//
//    }

    @Given("user clicks on the Dependents tab")
    public void user_clicks_on_the_Dependents_tab() {
        clickOnElement(employeeDependentsPage.dependentsTab);
        waitForElementToBeVisible(employeeDependentsPage.addButton);
    }

    @When("user clicks on {string} button")
    public void user_clicks_on_button(String buttonName) {
        WebElement button = findButtonByText(buttonName);
        clickOnElement(button);
    }

    @And("user enters dependent name {string}")
    public void user_enters_dependent_name(String dependentName) {
        waitForElementToBeVisible(employeeDependentsPage.nameField);
        sentText(dependentName, employeeDependentsPage.nameField);
    }

    @And("user selects relationship {string} from dropdown")
    public void user_selects_relationship_from_dropdown(String relationship) {
        Select relationshipDropdown = new Select(employeeDependentsPage.relationshipDropdown);
        relationshipDropdown.selectByVisibleText(relationship);
    }

    @And("user selects date of birth {string}")
    public void user_selects_date_of_birth(String dob) {
        sentText(formatDate(dob), employeeDependentsPage.dateOfBirthField);
    }

    @And("user enters dependent with name {string}, relationship {string} and birth date {string}")
    public void user_enters_dependent_with_name_relationship_and_birth_date(String name, String relationship, String dob) {
        if (!name.isEmpty()) {
            sentText(name, employeeDependentsPage.nameField);
        }

        if (!relationship.isEmpty()) {
            Select relationshipDropdown = new Select(employeeDependentsPage.relationshipDropdown);
            relationshipDropdown.selectByVisibleText(relationship);
        }

        if (!dob.isEmpty()) {
            sentText(formatDate(dob), employeeDependentsPage.dateOfBirthField);
        }
    }

    @Then("the dependent should appear in the dependents list")
    public void the_dependent_should_appear_in_the_dependents_list() {
        waitForElementToBeVisible(employeeDependentsPage.dependentsTable);
        boolean dependentFound = isDependentInList("David Smith");
        Assert.assertTrue("Dependent not found in the list", dependentFound);
    }

    @Then("database should reflect the new dependent")
    public void database_should_reflect_the_new_dependent() {
        String query = "SELECT * FROM hs_hr_emp_dependents WHERE emp_number = '75022554' AND name = 'David Smith'";
        Assert.assertTrue("Dependent not found in database", DbUtils.RecordExistInDb(query));
    }

    private String formatDate(String isoDate) {
        String[] dateComponents = isoDate.split("-");
        return dateComponents[1] + "/" + dateComponents[2] + "/" + dateComponents[0];
    }

    private boolean isDependentInList(String dependentName) {
        for (WebElement row : employeeDependentsPage.dependentRows) {
            if (row.getText().contains(dependentName)) {
                return true;
            }
        }
        return false;
    }


    @Then("system shows error message {string}")
    public void system_shows_error_message(String expectedErrorMessage) {
        waitForElementToBeVisible(employeeDependentsPage.errorMessageContainer);
        String actualErrorMessage = employeeDependentsPage.errorMessageContainer.getText();
        Assert.assertEquals("Error message doesn't match expected", expectedErrorMessage, actualErrorMessage);
    }


    @When("user clicks on {string} button for dependent {string}")
    public void user_clicks_on_button_for_dependent(String buttonType, String dependentName) {

        waitForElementToBeVisible(employeeDependentsPage.dependentsTable);

        String xpath;
        if (buttonType.equalsIgnoreCase("Edit")) {
            xpath = "//table[@id='dependent_list']//td[contains(text(),'" + dependentName + "')]" +
                    "/following-sibling::td//input[contains(@class,'editButton') or contains(@value,'Edit')]";
        } else if (buttonType.equalsIgnoreCase("Delete")) {
            xpath = "//table[@id='dependent_list']//td[contains(text(),'" + dependentName + "')]" +
                    "/following-sibling::td//input[contains(@class,'deleteButton') or contains(@value,'Delete')]";
        } else {
            throw new RuntimeException("Button type '" + buttonType + "' not recognized. Use 'Edit' or 'Delete'");
        }

        WebElement button = driver.findElement(By.xpath(xpath));
        clickOnElement(button);

        if (buttonType.equalsIgnoreCase("Delete")) {
            WebElement deleteConfirmDialog = driver.findElement(By.id("deleteConfModal"));
            waitForElementToBeVisible(deleteConfirmDialog);
        }
    }


    @When("user clicks on {string} button in confirmation dialog")
    public void user_clicks_on_button_in_confirmation_dialog(String buttonType) {
        // Wait for dialog to be visible
        WebElement dialog = driver.findElement(By.id("deleteConfModal"));
        waitForElementToBeVisible(dialog);

        // Find and click appropriate button
        if (buttonType.equalsIgnoreCase("Delete") || buttonType.equalsIgnoreCase("Ok")) {
            clickOnElement(employeeDependentsPage.deleteConfirmButton);
        } else if (buttonType.equalsIgnoreCase("Cancel")) {
            WebElement cancelButton = driver.findElement(By.xpath("//div[@id='deleteConfModal']//input[@value='Cancel']"));
            clickOnElement(cancelButton);
        } else {
            throw new RuntimeException("Button type '" + buttonType + "' not recognized in confirmation dialog");
        }

        // Wait for dialog to disappear
        WebDriverWait wait = getWait();
        wait.until(ExpectedConditions.invisibilityOf(dialog));
    }


    @Then("the dependent should no longer appear in the list")
    public void the_dependent_should_no_longer_appear_in_the_list() {
        // Refresh table to ensure latest data
        driver.navigate().refresh();

        try {
            // Wait for table to load
            waitForElementToBeVisible(employeeDependentsPage.dependentsTable);

            // Check if any row contains "David Smith" (the name from your test scenario)
            boolean dependentFound = isDependentInList("David Smith");
            Assert.assertFalse("Dependent still appears in the list after deletion", dependentFound);
        } catch (NoSuchElementException e) {
            // If table isn't found, it might mean there are no dependents left
            // This is also a valid case after deletion
            System.out.println("No dependents table found, which may indicate successful deletion of all dependents");
        }
    }


}
*/
