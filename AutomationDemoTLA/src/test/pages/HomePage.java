package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//
//    @FindBy(xpath = "//a[text()='User-Mgt']")
//      public WebElement userMgtBtn;

    public String[] navButtons ={"Home", "Inputs", "Selectors", "Selectors-class", "Alert", "Pop-Up", "Miltiple-window",
            "Tables", "Calendar", "iFrames" , "Action-Class", "JS-Executor", "Synchronization","Files", "User-Mgt"};

    public void clickNavBtn(String buttonName){
        click(driver.findElement(By.linkText(buttonName)));

    }
}
