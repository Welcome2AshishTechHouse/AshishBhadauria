package webPages;

import commonUtils.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class SearchPage {
    private final WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By addressSearchBox = By.xpath("//input[@id='addressInput']");
    private final By centerList = By.xpath("//div[contains(@class,'centerResult infoWindow')]");
    private final By centerCount = By.xpath("//span[@class='resultsNumber']");
    private final By firstCenter = By.xpath("//div[contains(@class,'centerResult infoWindow track_center_select')]");
    private final By centerName = By.xpath("//h3[@class='centerResult__name']");
    private final By centerAddress = By.xpath("//span[contains(@class,'_address')]");
    private final By popupName = By.xpath("//div[@class='gm-style-iw-d']//span[contains(@class,'_headline')]");
    private final By popupAddress = By.xpath("//div[@class='gm-style-iw-d']//div[contains(@class,'_address')]");
    private final By searchField = By.xpath("//nav[@id='subnav-search-desktop-top']//child::input[@id='search-field']");
    private final By searchButton = By.xpath("//nav[@id='subnav-search-desktop-top']//button[text()='Search']");
    private final By firstResult = By.xpath("//a[@class='search-result']//h3");


    public void enterLocation(String location) throws InterruptedException {
        driver.findElement(addressSearchBox).sendKeys(location);
        Thread.sleep(2000);
        driver.findElement(addressSearchBox).sendKeys(Keys.ENTER);

    }

    public int getCenterCount() {
        WebDriverUtil.waitVisibilityOfElementLocated(centerCount);
        return Integer.parseInt(driver.findElement(centerCount).getText());
    }

    public int getListOfAllCenterFound() {
        return driver.findElements(centerList).size();
    }

    public void clickFirstCenter() {
        driver.findElement(firstCenter).click();
    }

    public String getCenterName() {
        return driver.findElement(centerName).getText();
    }

    public String getCenterAddress() {
        return driver.findElement(centerAddress).getText();
    }

    public String getPopupName() {
        return driver.findElement(popupName).getText();
    }

    public String getPopupAddress() {
        return driver.findElement(popupAddress).getText();
    }

    public void enterSearchQuery(String query) {
        driver.findElement(searchField).sendKeys(query);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public String getFirstResultText() {
        return driver.findElement(firstResult).getText();
    }

    public boolean isSearchFieldDisplayed() {
        return driver.findElement(searchField).isDisplayed();
    }
}


