package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class essDashboardPage extends CommonMethods {

    @FindBy(id = "menu_pim_viewMyDetails")
    public WebElement myInfoOption;

    @FindBy(id = "welcome")
    public WebElement welcomeText;

    public essDashboardPage() {
        PageFactory.initElements(driver, this);
    }
}