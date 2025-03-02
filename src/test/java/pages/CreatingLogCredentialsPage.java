package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class CreatingLogCredentialsPage extends CommonMethods {

    @FindBy(xpath = "//h1[text()='Dashboard']")
    public WebElement dashboardPage;

    @FindBy(id = "welcome")
    public WebElement welcomeTextBox;

    @FindBy(xpath = "//a[@id='menu_pim_viewPimModule']")
    public WebElement PIMTab;
    @FindBy(xpath = "//a[@id='menu_pim_addEmployee']")
    public WebElement addEmployeeTab;

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "middleName")
    public WebElement middleNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "chkLogin")
    public WebElement createLogDetailsBox;

    @FindBy(id = "user_name")
    public WebElement userNameField;

    @FindBy(id = "user_password")
    public WebElement passwordField;

    @FindBy(id = "re_password")
    public WebElement confirmPasswordField;

    @FindBy(id = "status")
    public WebElement statusDropdown;

    @FindBy(xpath = "//option[@value='Disabled']")
    public WebElement disabledSelection;

    @FindBy(id = "btnSave")
    public WebElement saveButton;

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logOutButton;

    @FindBy(id = "personal_txtEmployeeId")
    public WebElement employeeIDField;

    @FindBy(xpath = "//h1[text()='Personal Details']")
    public WebElement personalDetailPage;

    @FindBy(xpath = "//span[contains(text(),'For a strong password,')]")
    public WebElement passwordRuleText;

    @FindBy(xpath = "//span[text()='Passwords do not match']")
    public WebElement passErrorMsg;

    @FindBy(xpath = "//span[text()='Required']")
    public WebElement requiredFieldsError;

    @FindBy(xpath = "//span[text()='Account disabled']")
    public WebElement accountDisabledError;

    public CreatingLogCredentialsPage() {
        PageFactory.initElements(driver, this);
    }


}