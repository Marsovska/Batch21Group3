package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class essUserUpdatePage extends CommonMethods {

    @FindBy(id = "personal_txtEmpFirstName")
    public WebElement firstNameLocator;

    @FindBy(id = "personal_txtEmpMiddleName")
    public WebElement middleNameLocator;

    @FindBy(id = "personal_txtEmpLastName")
    public WebElement lastNameLocator;

    @FindBy(xpath = "//input[@id='btnSave' and @value='Edit']")
    public WebElement editButton;

    @FindBy(xpath = "//input[@id='btnSave' and @value='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//input[@id='personal_optGender_1']")
    public WebElement maleButton;

    @FindBy(xpath = "//input[@id='personal_optGender_2']")
    public WebElement femaleButton;

    @FindBy(xpath = "//select[@id='personal_cmbNation']")
    public WebElement nationalityDropdown;

    @FindBy(xpath = "//select[@id='personal_cmbMarital']")
    public WebElement maritalStatusDropdown;

    @FindBy(xpath = "//span[@ for ='personal_txtEmpFirstName']")
    public WebElement fnErrorMessage;

    @FindBy(xpath = "//span[@ for ='personal_txtEmpLastName']")
    public WebElement lnErrorMessage;

    @FindBy(xpath = "(//div[contains(@class, 'inner')])[1]")
    public WebElement fadingSavedMessage;


    public essUserUpdatePage() {
        PageFactory.initElements(driver, this);
    }
}