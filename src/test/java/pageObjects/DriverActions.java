package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class DriverActions {

    WebDriver driver;

    public DriverActions(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void navigateToUrl(String url) {
        this.driver.get(url);
    }

    public void sendText(By by, String text) {
        this.driver.findElement(by).sendKeys(text);
    }

    public void click(By by) {
        this.driver.findElement(by).click();
    }

    public void switchFrames() {
        Set<String> handles = driver.getWindowHandles();
    }

    public void waitForVisibilityOfElement(By by, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void waitForElementToBeClickable(By by, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
}
