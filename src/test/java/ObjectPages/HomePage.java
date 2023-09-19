package ObjectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    //Define the locators for the Home page using Page Factory
    //Heading text
    @FindBy(how = How.CLASS_NAME,using = "home-heading")
    @CacheLookup
    WebElement HeadingTextLocator;

    //Description text
    @FindBy(how = How.CLASS_NAME,using = "home-description")
    @CacheLookup
    WebElement DescriptionTextLocator;

    //"Find Jobs" button

    @FindBy(how = How.CLASS_NAME,using = "find-jobs-button")
    @CacheLookup
    WebElement FindJobButtonLocator;

    //_________________________________________________________________________________________________________

    WebDriver driver;

    WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    //Define the methods for performing actions on the elements
    //Get the text content of the Heading
    public String getTextContentOfHeading(){
        return HeadingTextLocator.getText();
    }

    //Get the text content of the Description

    public String getTextContentOfDescription(){
        return DescriptionTextLocator.getText();
    }
    //Click the "Find Jobs" button

    public void clickOnFindJobButton(){
        FindJobButtonLocator.click();
    }



}
