package TestScenarios;

import ObjectPages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageTest {
    public WebDriver driver;


    LoginPage LPage;

    @BeforeMethod
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qajobbyapp.ccbp.tech/login");
        LPage = new LoginPage(driver);


    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void TestLoginPageUI(){
        //Navigate to the URL https://qajobbyapp.ccbp.tech/login
        //Verify if the App logo is displayed - use Assertions,
        //If the App logo is not displayed, print "App logo is not displayed"
        Assert.assertTrue(LPage.findAppLogoImage().isDisplayed(),"App logo is not displayed");

        //Verify the Username label text - use Assertions,
        //Expected text: USERNAME
        //If the Label text does not match the expected text, print "Username label text does not match"

        Assert.assertEquals(LPage.getTextLabelSpecificIndex(0),"USERNAME","Username label text does not match");

        //Verify the Password label text - use Assertions,
        //Expected text: PASSWORD
        //If the Label text does not match the expected text, print "Password label text does not match"

        Assert.assertEquals(LPage.getTextLabelSpecificIndex(1),"PASSWORD","Password label text does not match");
    }

    //Test the submission with empty input fields

    @Test(priority = 2)
    public void TestSubmissionWithEmptyInput(){

        //Navigate to the URL https://qajobbyapp.ccbp.tech/login
        //Click the "Login" button.
        LPage.clickOnLoginButton();
        //Wait and verify the error message - use Assertions,
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        //Expected text: *Username or password is invalid
        //If the error message does not match the expected text, print "Error text with empty input fields does not match"
        Assert.assertEquals(LPage.getTextErrorMessage(),"*Username or password is invalid","Error text with empty input fields does not match");

        //Close the browser window.

    }
    //Test the submission with empty Username field

    @Test(priority = 3)
    public void TestSubmissionWithEmptyUsername(){
        //Navigate to the URL https://qajobbyapp.ccbp.tech/login
        //Login to the application, only with the Password rahul@2021.
        LPage.enterPasswordInput("rahul@2021");
        LPage.clickOnLoginButton();
        //Wait and verify the error message - use Assertions,
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));

        //Expected text: *Username or password is invalid
        //If the error message does not match the expected text, print "Error text with empty input field do not match"
        //Close the browser window.

        Assert.assertEquals(LPage.getTextErrorMessage(),"*Username or password is invalid","Error text with empty input field do not match");


    }

    //Test the submission with empty Password field
    @Test(priority = 4)
    public void TestSubmissionWithEmptyPassword(){

        //Navigate to the URL https://qajobbyapp.ccbp.tech/login
        //Login to the application, only with the Username rahul.
        LPage.enterUsernameInput("rahul");
        LPage.clickOnLoginButton();
        //Wait and verify the error message - use Assertions,

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        //Expected text: *Username or password is invalid
        //If the error message does not match the expected text, print "Error text with empty input field do not match"
        Assert.assertEquals(LPage.getTextErrorMessage(),"*Username or password is invalid","Error text with empty input field do not match");

        //Close the browser window.

    }

    //Test the submission with invalid Password
    @Test(priority = 5)
    public void TestSubmissionWithInvalidPassword(){
        //Navigate to the URL https://qajobbyapp.ccbp.tech/login
        //Login to the application, with the Username rahul and Password rahul.
        LPage.enterUsernameInput("rahul");
        LPage.enterPasswordInput("rahul");
        LPage.clickOnLoginButton();
        //Wait and verify the error message - use Assertions,
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));

        //Expected text: *username and password didn't match
        //If the error message does not match the expected text, print "Error text with invalid password do not match"
        Assert.assertEquals(LPage.getTextErrorMessage(),"*username and password didn't match","Error text with invalid password do not match");

        //Close the browser window.

    }

    //Test the successful login
    @Test(priority = 6)
    public void TestSuccessfulLogin(){
        //Navigate to the URL https://qajobbyapp.ccbp.tech/login
        //Login to the application, with the Username rahul and Password rahul@2021.
        LPage.enterUsernameInput("rahul");
        LPage.enterPasswordInput("rahul@2021");
        LPage.clickOnLoginButton();
        //Wait and verify the navigation to the home page - use Assertions
        //Expected URL: https://qajobbyapp.ccbp.tech/
        //If the current URL does not match the expected URL, print "URLs do not match"
        //Close the browser window.

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qajobbyapp.ccbp.tech/"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://qajobbyapp.ccbp.tech/","URLs do not match");


    }


}
