package TestScenarios;

import ObjectPages.HomePage;
import ObjectPages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTest {

    public WebDriver driver;


    LoginPage LPage;
    HomePage HPage;

    @BeforeMethod
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qajobbyapp.ccbp.tech/login");
        LPage = new LoginPage(driver);
        HPage = new HomePage(driver);


    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
    }

    public void Login(String username,String password){
        //Navigate to the URL https://qajobbyapp.ccbp.tech/login
        //Login to the application, with the Username rahul and Password rahul@2021.
        LPage.enterUsernameInput(username);
        LPage.enterPasswordInput(password);
        LPage.clickOnLoginButton();
    }

    //Test the Homepage Heading


    @Test(priority = 12)
    public void HomePageHeadingText(){
        //Navigate to the URL https://qajobbyapp.ccbp.tech/login
        //Login to the application, with the Username rahul and Password rahul@2021.
        //Wait until the web driver navigates to the home page
        //Home Page URL: https://qajobbyapp.ccbp.tech/
        Login("rahul","rahul@2021");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qajobbyapp.ccbp.tech/"));

        //Verify the Heading text of the home page - use Assertions,
        //Expected text: Find The Job That Fits Your Life
        //If the Heading text does not match the expected text, print "Heading text does not match"

        Assert.assertEquals(HPage.getTextContentOfHeading(),"Find The Job That Fits Your Life","Heading text does not match");

        //Verify the Description text of the home page - use Assertions,
        //Expected text: Millions of people are searching for jobs, salary information, company reviews. Find the job that fits your abilities and potential.
        //If the Description text does not match the expected text, print "Description text does not match"
        //Close the browser window.

        Assert.assertEquals(HPage.getTextContentOfDescription(),"Millions of people are searching for jobs, salary information, company reviews. Find the job that fits your abilities and potential.","Description text does not match");

    }

    //Test the Find Jobs button functionality

    @Test(priority = 13)
    public void ClickOnFindJobFunctionality(){
        //Navigate to the URL https://qajobbyapp.ccbp.tech/login
        //Login to the application, with the Username rahul and Password rahul@2021.
        //Wait until the web driver navigates to the home page
        //Home Page URL: https://qajobbyapp.ccbp.tech/
        Login("rahul","rahul@2021");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qajobbyapp.ccbp.tech/"));

        //Click the "Find Jobs" button.
        HPage.clickOnFindJobButton();

        //Verify the navigation to the jobs page - use Assertions
        //Expected URL: https://qajobbyapp.ccbp.tech/jobs
        //If the current URL does not match the expected URL, print "URLs do not match"
        wait.until(ExpectedConditions.urlToBe("https://qajobbyapp.ccbp.tech/jobs"));

        Assert.assertEquals(driver.getCurrentUrl(),"https://qajobbyapp.ccbp.tech/jobs","URLs do not match");
        //Close the browser window.

    }

}
