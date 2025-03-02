package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class EmployeeDependentsPage extends CommonMethods {

    @FindBy(xpath = "(//ul[@id='sidenav']/li/a)[4]")
    public WebElement dependentsTab;

    @FindBy(id = "btnAddDependent")
    public WebElement addButton;

    @FindBy(id = "dialogDeleteBtn")
    public WebElement deleteConfirmButton;

    // Form fields
    @FindBy(id = "dependent_name")
    public WebElement nameField;

    @FindBy(id = "dependent_relationshipType")
    public WebElement relationshipDropdown;

    @FindBy(id = "dependent_dateOfBirth")
    public WebElement dateOfBirthField;

    // Table elements
    @FindBy(id = "dependent_list")
    public WebElement dependentsTable;

    @FindBy(xpath = "//table[@id='dependent_list']/tbody/tr")
    public List<WebElement> dependentRows;

    // Validation elements
    @FindBy(className = "validation-error")
    public WebElement errorMessageContainer;


    public EmployeeDependentsPage() {
        PageFactory.initElements(driver, this);
    }
}
