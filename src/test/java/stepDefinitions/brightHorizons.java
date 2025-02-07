package stepDefinitions;


import commonUtils.ScreenshotUtils;
import commonUtils.WebDriverUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import projectManager.PropertyManager;
import projectManager.ScenarioManager;
import webPages.HomePage;
import webPages.SearchPage;

import java.util.Objects;

public class brightHorizons {

    WebDriver driver = WebDriverUtil.getDriver();
    HomePage homePage = new HomePage(driver);
    SearchPage searchPage = new SearchPage(driver);
    int displayedCentersCounts;
    String selectedCenterName;
    String selectedCenterAddress;
    ScreenshotUtils screenshotUtils = new ScreenshotUtils(driver);


    @Given("User is on {string} home page")
    public void user_is_on_home_page(String systemName) {
        String bh_url =  PropertyManager.getInstance().getProperty(systemName+".url");
        driver.get(bh_url);
        ScenarioManager.getInstance().getScenario().log("Login to URL : <pre>"+systemName+"</pre> \nUsing this Url :<pre>"+bh_url+"</pre>");
        screenshotUtils.captureScreenshot("Login Successful");
    }

    @When("User clicks on Find a Center")
    public void user_clicks_on_find_center() {
        homePage.clickFindCenter();
        ScenarioManager.getInstance().getScenario().log("Clicked on 'Find a Center' Button");
        screenshotUtils.captureScreenshot("");
    }

    @Then("Verify new page contains {string} in URL")
    public void verify_url_contains_locator(String endpoint) {
        Assert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains(endpoint));
        ScenarioManager.getInstance().getScenario().log("Validation completed for new page url contains endpoint: <pre>Endpoint: "+endpoint+"</pre> \n <pre>Current Url: "+driver.getCurrentUrl()+"</pre>");
        screenshotUtils.captureScreenshot("verify_url_contains_endpoint: "+endpoint);
    }

    @When("User searches for {string}")
    public void user_searches_for_location(String location) throws InterruptedException {
        searchPage.enterLocation(location);
        displayedCentersCounts = searchPage.getCenterCount();
        ScenarioManager.getInstance().getScenario().log("User search for location: <pre>"+location+"</pre>");
        screenshotUtils.captureScreenshot("user_searches_for_location: "+location);
    }

    @Then("Verify the number of found centers matches the displayed list")
    public void verify_center_count() {
        Assert.assertEquals(searchPage.getListOfAllCenterFound(), displayedCentersCounts);
        ScenarioManager.getInstance().getScenario().log("Validation completed for number of found centers matches the displayed list: <pre>"+displayedCentersCounts+"</pre>");
        screenshotUtils.captureScreenshot("verify_center_count: "+displayedCentersCounts);
    }

    @When("User clicks on the first center")
    public void user_clicks_first_center() {
        selectedCenterName = searchPage.getCenterName();
        selectedCenterAddress = searchPage.getCenterAddress();
        searchPage.clickFirstCenter();
        ScenarioManager.getInstance().getScenario().log("User clicks on the first center \n CenterName: <pre>"+selectedCenterName+"</pre> \n CenterAddress: <pre>"+selectedCenterAddress+"</pre>");
        screenshotUtils.captureScreenshot("user_clicks_first_center");
    }

    @Then("Verify if center name and address are the same on the list and popup")
    public void verify_center_details() {
        Assert.assertEquals(searchPage.getPopupName(), selectedCenterName);
        Assert.assertEquals(searchPage.getPopupAddress().replace(" ","").replace("\n",""), selectedCenterAddress.replace(" ",""));
        ScenarioManager.getInstance().getScenario().log("Validation completed for center name and address are the same on the list and popup");
        screenshotUtils.captureScreenshot("verify_center_details");
    }
}