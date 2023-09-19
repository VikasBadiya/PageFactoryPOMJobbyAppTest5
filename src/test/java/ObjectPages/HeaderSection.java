package ObjectPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class HeaderSection {

    //Define the locators for the Header section using Page Factory
    //App logo image
    @FindBy(how = How.XPATH,using = "//*[@id='root']/div/nav/div/div[2]/a/img")
    @CacheLookup
    WebElement AppLogoImageLocator;

    //App logo link
    @FindBy(how = How.XPATH,using = "//*[@id='root']/div/nav/div/div[2]/a")
    @CacheLookup
    WebElement AppLogoLinkLocator;


    //Navbar Home link

    @FindBy(how = How.XPATH,using = "//*[@id='root']/div/nav/div/div[2]/ul/li[1]/a")
    @CacheLookup
    WebElement NavbarHomeLinkLocator;

    //Navbar Jobs link
    @FindBy(how = How.XPATH,using = "//*[@id='root']/div/nav/div/div[2]/ul/li[2]/a")
    @CacheLookup
    WebElement NavbarJobLinkLocator;

    //"Logout" button
    @FindBy(how = How.XPATH,using = "//*[@id='root']/div/nav/div/div[2]/button")
    @CacheLookup
    WebElement LogoutButtonLocator;

    //__________________________________________________________________________________________________________________

    WebDriver driver;

    WebDriverWait wait;

    public HeaderSection(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);


    }

    //Find the App logo image
    public WebElement findAppLogoImage(){
        return AppLogoImageLocator;
    }
    //Click the App logo link

    public void clickOnAppLogoLink(){
        AppLogoLinkLocator.click();
    }

    //Click the Navbar Home link
    public void clickOnNavbarHomeLink(){
        NavbarHomeLinkLocator.click();
    }

    //Click the Navbar Jobs link

    public void clickOnNavbarJobLink(){
        NavbarJobLinkLocator.click();
    }

    //Click the "Logout" button
    public void clickOnLogout(){
        LogoutButtonLocator.click();
    }
    //Logout of the application, by accepting the alert
    public void acceptingAlertLogout(){
        clickOnLogout();
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }




}
