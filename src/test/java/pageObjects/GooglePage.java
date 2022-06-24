package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GooglePage extends PageObject {
    DriverActions da;
    String url = "http://www.google.com";
    By searchBox = By.name("q");
    By searchButton = By.xpath("(//input[@value='Google Search'])[2]");
    By espnScheduleLink = By.xpath("//h3[contains(text(), 'Boxing schedule - ESPN')]");
    By amazonLink = By.xpath("//h3[contains(text(), 'Customer Reviews - Amazon.com')]");

    public GooglePage(WebDriver driver) {
        super("http://www.google.com");
        da = new DriverActions(driver);
    }

    public void googleSearchTest() {
        String textToSearch = "Espn boxing schedule";
        String espnBoxingScheduleUrl = "https://www.espn.com/boxing/story/_/id/12508267/boxing-schedule";

        da.navigateToUrl(url);
        da.waitForVisibilityOfElement(searchBox, 5);
        da.sendText(searchBox, textToSearch);
        da.getDriver().findElement(searchBox).sendKeys(Keys.TAB);
        da.waitForVisibilityOfElement(searchButton, 5);
        da.click(searchButton);
        da.waitForVisibilityOfElement(espnScheduleLink, 5);
        da.click(espnScheduleLink);

        assert(da.getDriver().getCurrentUrl().equalsIgnoreCase(espnBoxingScheduleUrl));
    }

    public void googleSearchTest2() {
        String textToSearch = "amazon reviews";

        String amazonReviewUrl = "https://www.amazon.com/gp/help/customer/display.html?nodeId=G3UA5WC5S5UUKB5G";

        da.navigateToUrl(url);
        da.waitForVisibilityOfElement(searchBox, 5);
        da.sendText(searchBox, textToSearch);
        da.getDriver().findElement(searchBox).sendKeys(Keys.TAB);
        da.waitForVisibilityOfElement(searchButton, 5);
        da.click(searchButton);
        da.waitForVisibilityOfElement(amazonLink, 5);
        da.click(amazonLink);

        assert(da.getDriver().getCurrentUrl().equalsIgnoreCase(amazonReviewUrl));
    }
}