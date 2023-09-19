package ObjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage {
   //Define the locators for the Login page using Page Factory
    //App logo image
    @FindBy(how = How.CLASS_NAME,using = "login-website-logo")
    @CacheLookup
    WebElement AppLogoImageLocator;
    //List of label texts
    @FindBy(how = How.CLASS_NAME,using = "input-label")
    @CacheLookup
    List<WebElement> ListOfLabelTextsLocator;


    //"USERNAME" input field

    @FindBy(how = How.ID,using = "userNameInput")
    @CacheLookup
    WebElement UsernameInputLocator;

    //"PASSWORD" input field
    @FindBy(how = How.ID,using = "passwordInput")
    @CacheLookup
    WebElement PasswordInputLocator;

    //"Login" button
    @FindBy(how = How.CLASS_NAME,using = "login-button")
    @CacheLookup
    WebElement LoginButtonLocator;


    //Error message text
    @FindBy(how = How.CLASS_NAME,using = "error-message")
    @CacheLookup
    WebElement ErrorMessageTextLocator;

    //_________________________________________________________________________________________________________________

    WebDriver driver;

    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    //Define the methods for performing actions on the elements
    //Find the App logo image
    public WebElement findAppLogoImage(){
        return AppLogoImageLocator;
    }

    //Get the text content of the label at a specific index
    public String getTextLabelSpecificIndex(int index){
        return ListOfLabelTextsLocator.get(index).getText();
    }

    //Enter a text in the "USERNAME" input field

    public void enterUsernameInput(String username){
        UsernameInputLocator.sendKeys(username);
    }

    //Enter a text in the "PASSWORD" input field
    public void enterPasswordInput(String password){
        PasswordInputLocator.sendKeys(password);
    }

    //Click the "Login" button
    public void clickOnLoginButton(){
        LoginButtonLocator.click();
    }

    //Enter with the given credentials and click the "Login" button
    public void givenCredentialsAndClickOnLogin(String username,String password){
        enterUsernameInput(username);
        enterPasswordInput(password);
        clickOnLoginButton();
    }
    //Wait and get the text content of the error message
    public String getTextErrorMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        return ErrorMessageTextLocator.getText();
    }


}
