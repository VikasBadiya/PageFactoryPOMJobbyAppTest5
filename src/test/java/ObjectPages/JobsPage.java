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

public class JobsPage {

    //Define the locators for the Header section using Page Factory
    //Profile image
    @FindBy(how = How.CLASS_NAME,using = "profile-img")
    @CacheLookup
    WebElement ProfileImageLocator;
    //Profile name
    @FindBy(how = How.CLASS_NAME,using = "profile-name")
    @CacheLookup
    WebElement ProfileNameLocator;


    //Short bio text
    @FindBy(how = How.XPATH,using = "//*[@id='root']/div/div/div/div[2]/div[1]/p")
    @CacheLookup
    WebElement ShortBioTextLocator;


    //Search input field
    @FindBy(how = How.XPATH,using = "//*[@id='root']/div/div/div/div[3]/div/div/div/input")
    @CacheLookup
    WebElement SearchInputLocator;

    //Search button
    @FindBy(how = How.XPATH,using = "//*[@id='root']/div/div/div/div[3]/div/div/div/button")
    @CacheLookup
    WebElement SearchButtonLocator;

    //List of all jobs displayed
    @FindBy(how = How.CLASS_NAME,using = "link-item")
    @CacheLookup
    List<WebElement> ListOfAllJobDisplayed;

    //No jobs found image
    @FindBy(how = How.XPATH,using = "//*[@id='root']/div/div/div/div[3]/div[2]/img")
    @CacheLookup
    WebElement NoJobsFoundImageLocator;

    //No jobs found heading
    @FindBy(how = How.XPATH,using = "//*[@id='root']/div/div/div/div[3]/div[2]/h1")
    @CacheLookup
    WebElement NoJobsFoundHeadingLocator;
    //No jobs found description

    @FindBy(how = How.XPATH,using = "//*[@id='root']/div/div/div/div[3]/div[2]/p")
    @CacheLookup
    WebElement NoJobFoundDescriptionLocator;

    @FindBy(how = How.CLASS_NAME,using = "results-text")
    @CacheLookup
    WebElement ResultsTextLocator;

    //_____________________________________________________________________________________________________

    WebDriver driver;
    WebDriverWait wait;

    public JobsPage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    //Define the methods for performing actions on the elements
    //Find the Profile image
    public WebElement findTheProfileImage(){
        return ProfileImageLocator;
    }
    //Get the text content of the Profile name
    public String getTextContentProfileName(){
        return ProfileNameLocator.getText();
    }

    //Get the text content of the Short bio text
    public String getTextContentShortBio(){
        return ShortBioTextLocator.getText();
    }

    //Enter a text in the Search input field
    public void enterTextSearchInput(String value){
        SearchInputLocator.sendKeys(value);
    }


    //Click the Search button
    public void clickOnSearchButton(){
        SearchButtonLocator.click();
    }

    //Search for a job with the specified text

    public void SearchForJobSpecifiedText(String value){
        enterTextSearchInput(value);
        clickOnSearchButton();

    }

    //Get the Count of all jobs displayed

    public int getCountAllJobDisplayed(){
        return ListOfAllJobDisplayed.size();
    }

    //Find the No jobs found image
    public WebElement findNoJobImage(){
        return NoJobsFoundImageLocator;
    }
    //Get the text content of the No jobs found heading
    public String getTextNoJobsHeading(){
        return NoJobsFoundHeadingLocator.getText();
    }
    //Get the text content of the No jobs found description
    public String getTextNoJobDescription(){
        return NoJobFoundDescriptionLocator.getText();
    }



}
