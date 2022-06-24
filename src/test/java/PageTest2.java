import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.DriverActions;
import pageObjects.GooglePage;

public class PageTest2 {
    WebDriver driver;

    @BeforeTest
    void setUp(){
        String projectPath = System.getProperty("user.dir") + "\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", projectPath);
        driver = new ChromeDriver();
    }

    @Test
    void GoogleSearchTest2() {
        GooglePage googlePage = new GooglePage(driver);
        googlePage.googleSearchTest2();
    }


    @AfterTest
    void teardown() {
        driver.quit();
    }
}
