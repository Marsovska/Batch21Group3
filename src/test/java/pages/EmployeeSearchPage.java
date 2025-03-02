package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;


public class EmployeeSearchPage extends CommonMethods {

    @FindBy(id = "searchBtn")
    public WebElement searchButton;

    @FindBy(xpath = "//a[text()='Dependents']")
    public WebElement personalDetailsTab;

    @FindBy(id = "empsearch_id")
    public WebElement idSearchField;

    public EmployeeSearchPage() {
        PageFactory.initElements(driver, this);
    }
}