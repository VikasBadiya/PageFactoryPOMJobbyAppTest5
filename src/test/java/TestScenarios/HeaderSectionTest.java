package TestScenarios;

import ObjectPages.HeaderSection;
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

public class HeaderSectionTest {

    public WebDriver driver;


    LoginPage LPage;
    HeaderSection HeaderSectionPage;

    @BeforeMethod
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qajobbyapp.ccbp.tech/login");
        LPage = new LoginPage(driver);
        HeaderSectionPage = new HeaderSection(driver);


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

    @Test(priority = 7)
    public void HeaderSectionAppLogoImage(){//Navigate to the URL https://qajobbyapp.ccbp.tech/login
    //Login to the application, with the Username rahul and Password rahul@2021.
    //Wait until the web driver navigates to the home page
    //Home Page URL: https://qajobbyapp.ccbp.tech/
      Login("rahul","rahul@2021");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qajobbyapp.ccbp.tech/"));

        //Verify if the App logo is displayed - use Assertions,
        //If the App logo is not displayed, print "App logo is not displayed"
        //Close the browser window.
        Assert.assertTrue(HeaderSectionPage.findAppLogoImage().isDisplayed(),"App logo is not displayed");

    }

    //Test the navigation by clicking the Navbar Jobs link
    @Test(priority = 8)
    public void ClickOnNavbarJobsLink(){
        //Navigate to the URL https://qajobbyapp.ccbp.tech/login
        //Login to the application, with the Username rahul and Password rahul@2021.
        //Wait until the web driver navigates to the home page
        //Home Page URL: https://qajobbyapp.ccbp.tech/
        //Click the Navbar Jobs link.
        Login("rahul","rahul@2021");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qajobbyapp.ccbp.tech/"));
        HeaderSectionPage.clickOnNavbarJobLink();

        //Verify the navigation to the jobs page - use Assertions
        //Expected URL: https://qajobbyapp.ccbp.tech/jobs
        //If the current URL does not match the expected URL, print "URLs do not match"
        //Close the browser window.

        wait.until(ExpectedConditions.urlToBe("https://qajobbyapp.ccbp.tech/jobs"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://qajobbyapp.ccbp.tech/jobs","URLs do not match");

    }

    //Test the navigation by clicking the App logo link

    @Test(priority = 9)
    public void ClickOnAppLogo(){
        //Navigate to the URL https://qajobbyapp.ccbp.tech/login
        //Login to the application, with the Username rahul and Password rahul@2021.
        //Wait until the web driver navigates to the home page
        //Home Page URL: https://qajobbyapp.ccbp.tech/

        Login("rahul","rahul@2021");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qajobbyapp.ccbp.tech/"));
        //Click the Navbar Jobs link.
        HeaderSectionPage.clickOnNavbarJobLink();
        //Click the App logo link
        HeaderSectionPage.clickOnAppLogoLink();

        //Verify the navigation to the home page - use Assertions
        //Expected URL: https://qajobbyapp.ccbp.tech/
        wait.until(ExpectedConditions.urlToBe("https://qajobbyapp.ccbp.tech/"));
        //If the current URL does not match the expected URL, print "URLs do not match"
        Assert.assertEquals(driver.getCurrentUrl(),"https://qajobbyapp.ccbp.tech/","URLs do not match");
        //Close the browser window.

    }

    //Test the navigation by clicking the Navbar Home link

    @Test(priority = 10)
    public void ClickOnNavbarHome(){
        //Navigate to the URL https://qajobbyapp.ccbp.tech/login
        //Login to the application, with the Username rahul and Password rahul@2021.
        //Wait until the web driver navigates to the home page
        //Home Page URL: https://qajobbyapp.ccbp.tech/
        Login("rahul","rahul@2021");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qajobbyapp.ccbp.tech/"));
        //Click the Navbar Jobs link.
        HeaderSectionPage.clickOnAppLogoLink();
        //Click the Navbar Home link
        HeaderSectionPage.clickOnNavbarHomeLink();
        //Verify the navigation to the home page - use Assertions

        //Expected URL: https://qajobbyapp.ccbp.tech/
        wait.until(ExpectedConditions.urlToBe("https://qajobbyapp.ccbp.tech/"));
        //If the current URL does not match the expected URL, print "URLs do not match"
        Assert.assertEquals(driver.getCurrentUrl(),"https://qajobbyapp.ccbp.tech/","URLs do not match");
        //Close the browser window.


    }

    //Test the logout button functionality
    @Test(priority = 11)
    public void ClickOnLogout(){
        //Navigate to the URL https://qajobbyapp.ccbp.tech/login
        //Login to the application, with the Username rahul and Password rahul@2021.
        //Wait until the web driver navigates to the home page
        //Home Page URL: https://qajobbyapp.ccbp.tech/
        Login("rahul","rahul@2021");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qajobbyapp.ccbp.tech/"));
        //Logout of the application.
        HeaderSectionPage.acceptingAlertLogout();

        //Verify the navigation to the login page - use Assertions
        //Expected URL: https://qajobbyapp.ccbp.tech/login
        wait.until(ExpectedConditions.urlToBe("https://qajobbyapp.ccbp.tech/login"));
        //If the current URL does not match the expected URL, print "URLs do not match"
        Assert.assertEquals(driver.getCurrentUrl(),"https://qajobbyapp.ccbp.tech/login","URLs do not match");
        //Close the browser window.



    }




}
