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

    private final By searchBox = By.xpath("//input[@id='addressInput']");
    private final By centerList = By.xpath("//div[contains(@class,'centerResult infoWindow')]");
    private final By centerCount = By.xpath("//span[@class='resultsNumber']");
    private final By firstCenter = By.xpath("//div[contains(@class,'centerResult infoWindow track_center_select')]");
    private final By centerName = By.xpath("//h3[@class='centerResult__name']");
    private final By centerAddress = By.xpath("//span[contains(@class,'_address')]");
    private final By popupName = By.xpath("//div[@class='gm-style-iw-d']//span[contains(@class,'_headline')]");
    private final By popupAddress = By.xpath("//div[@class='gm-style-iw-d']//div[contains(@class,'_address')]");

    public void enterLocation(String location) throws InterruptedException {
        driver.findElement(searchBox).sendKeys(location);
        Thread.sleep(2000);
        driver.findElement(searchBox).sendKeys(Keys.ENTER);

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
}


