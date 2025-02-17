package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By findCenterButton = By.xpath("(//li[@class='nav-item displayed-desktop']//a[contains(@data-tracking-cta,'Find a Center')])[2]");
    private final By searchIcon = By.xpath("//nav[contains(@class,'nav-top')]//a[contains(@href,'search-desktop')]//span");
    private final By acceptAlert = By.xpath("//button[contains(@id,'-accept-')]");

    public void clickFindCenter() {
        driver.findElement(acceptAlert).click();
        driver.findElement(findCenterButton).click();
    }

    public void clickSearchIcon() {
        driver.findElement(acceptAlert).click();
        driver.findElement(searchIcon).click();
    }
}