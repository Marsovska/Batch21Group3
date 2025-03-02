package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import utils.CommonMethods;

public class essUserUpdateSteps extends CommonMethods {

    @When("user enters {string} and {string} in the firstname and lastname")
    public void user_enters_and_in_the_firstname_and_lastname
            (String blankFirstName, String blankLastName) {
        sentText(blankFirstName, ESS_user_update_Page.firstNameLocator);
        sentText(blankLastName, ESS_user_update_Page.lastNameLocator);
    }

    @When("user clicks save button")
    public void user_clicks_save_button() {
        clickOnElement(ESS_user_update_Page.saveButton);
    }

    @Then("user gets an error message Required for firstname")
    public void user_gets_an_error_message_required_for_firstname() {
        String errorValue = ESS_user_update_Page.fnErrorMessage.getText();
        Assert.assertEquals("Required", errorValue);
        System.out.println("Error message shown");
    }

    @Then("user gets an error message Required for lastname")
    public void user_gets_an_error_message_required_for_lastname() {
        String errorValue = ESS_user_update_Page.lnErrorMessage.getText();
        Assert.assertEquals("Required", errorValue);
        System.out.println("Error message shown");
    }

    @When("user enters {string} in middlename field")
    public void user_enters_in_middlename_field
            (String blankMiddlesName) {
        sentText(blankMiddlesName, ESS_user_update_Page.middleNameLocator);
    }

    @Then("Personal details are updated successfully")
    public void personal_details_are_updated_successfully() {
        String savedMessage = ESS_user_update_Page.fadingSavedMessage.getText();
        Assert.assertTrue(savedMessage.contains("Successfully Saved"));
        System.out.println("Successfully Saved[");
    }

    @When("user enters data {string} and {string} and {string}")
    public void user_enters_data_and_and
            (String firstName, String middleName, String lastName) {
        sentText(firstName, ESS_user_update_Page.firstNameLocator);
        sentText(middleName, ESS_user_update_Page.middleNameLocator);
        sentText(lastName, ESS_user_update_Page.lastNameLocator);
    }

    @When("user selects their gender {string}")
    public void user_selects_their_gender
            (String gender) {
        if (gender.equals("Male")) {
            clickOnElement(ESS_user_update_Page.maleButton);
        } else if (gender.equals("Female")) {
            clickOnElement(ESS_user_update_Page.femaleButton);
        }
    }

    @When("user selects their nationality {string}")
    public void user_selects_their_nationality
            (String nationality) {
        Select sel = new Select(ESS_user_update_Page.nationalityDropdown);
        sel.selectByVisibleText(nationality);
    }

    @When("user selects their marital status {string}")
    public void user_selects_their_marital_status
            (String status) {
        Select sel = new Select(ESS_user_update_Page.maritalStatusDropdown);
        sel.selectByValue(status);
    }
}