package stepDefinitions;


import commonUtils.ScreenshotUtils;
import commonUtils.WebDriverUtil;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import projectManager.PropertyManager;
import projectManager.ScenarioManager;
import webPages.HomePage;
import webPages.SearchPage;

import java.util.Objects;

public class brightHorizons {


    int displayedCentersCounts;
    String selectedCenterName;
    String selectedCenterAddress;
    WebDriver driver;
    HomePage homePage;
    SearchPage searchPage;
    ScreenshotUtils screenshotUtils;



    @Given("User is on {string} home page")
    public void user_is_on_home_page(String systemName) {
        driver = WebDriverUtil.getDriver();
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        screenshotUtils = new ScreenshotUtils(driver);
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

    @When("User click on the search icon")
    public void user_click_on_the_search_loop_icon() {
        homePage.clickSearchIcon();
        ScenarioManager.getInstance().getScenario().log("User clicks on the Search Icon");
        screenshotUtils.captureScreenshot("user_clicks_search_icon");
    }

    @Then("User should see the search field")
    public void User_should_see_the_search_field() {
        assert(searchPage.isSearchFieldDisplayed());
        ScenarioManager.getInstance().getScenario().log("User should see the search field");
        screenshotUtils.captureScreenshot("Search_field_displayed");
    }

    String expectedQuery;
    @When("User enter {string} into the search field")
    public void User_enter_into_the_search_field(String query) {
        this.expectedQuery = query;
        searchPage.enterSearchQuery(query);
        ScenarioManager.getInstance().getScenario().log("User enter Query in the search field \n Query: <pre>"+query+"</pre>");
        screenshotUtils.captureScreenshot("User_enter_into_the_search_field");
    }

    @And("User click on the Search button")
    public void User_click_on_the_Search_button() {
        searchPage.clickSearchButton();
        ScenarioManager.getInstance().getScenario().log("User click on the Search button");
        screenshotUtils.captureScreenshot("User_click_on_the_Search_button");
    }

    @Then("Validate first search result should match the search query")
    public void validate_first_search_result_should_match_the_search_query() {
        String firstResultText = searchPage.getFirstResultText().trim();
        assert(firstResultText.equals(expectedQuery));
        ScenarioManager.getInstance().getScenario().log("Validation first search result should match the search query: <pre> Expected Result : "+expectedQuery+"</pre> \n <pre> Actual Result : "+firstResultText+"</pre> ");
        screenshotUtils.captureScreenshot("validate_first_search_result_should_match_the_search_query");

    }


}