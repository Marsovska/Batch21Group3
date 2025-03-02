package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;


public class AddingEmployeePage extends CommonMethods {

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "middleName")
    public WebElement middleNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "employeeId")
    public WebElement employeeIdField;

    @FindBy(id = "btnSave")
    public WebElement saveButton;

    @FindBy(xpath = "//span[text()='Required']")
    public WebElement requiredErrorMessage;

    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement PIMTab;

    @FindBy(id = "menu_pim_addEmployee")
    public WebElement addEmployeeTab;

    @FindBy(id = "personal_txtEmployeeId")
    public WebElement generatedEmployeeIdField;
    public WebElement dashboardPage;

    public AddingEmployeePage() {
        PageFactory.initElements(driver, this);
    }
}