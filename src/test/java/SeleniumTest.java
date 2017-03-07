import static org.testng.Assert.*;

import com.google.common.base.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by artempavlovskyi on 05/03/2017.
 */
public class SeleniumTest {
    private WebDriver driver;
    private final String URL = "https://akamaijobs.referrals.selectminds.com";

    @BeforeClass
    public void initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/artempavlovskyi/Documents/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void checkResultByKeyword() {
        String keywords = "Software Development Engineer in Test";
        int expected = 5;
        doSearch();

//        ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("job_results_list_hldr"));
        List<WebElement> elementList = driver.findElement(By.id("job_results_list_hldr"))
                .findElements(By.xpath("//*[contains(@id,'job_list')]//div/div[1]/p[1]/a"));
        int actual = 0;
        for (WebElement element : elementList) {
            if (element.getText().contains(keywords)) {
                actual++;
            }
        }
        assertTrue(actual == expected, String.format("Expected to find: %s, but was: %s ", expected, actual));
    }

    @Test
    public void checkResultByDate() {
        String keywords = "Software Development Engineer in Test - LUNA";
        String expected = "Jan 16, 2016";
        doSearch();

        List<WebElement> elements = driver.findElement(By.id("job_results_list_hldr"))
                .findElements(By.xpath("//*[contains(@id,'job_list_')]//div/div[1]/p[1]/a"));

        String link = null;
        for (WebElement element : elements) {
            if (element.getText().contains(keywords)) {
                link = element.getAttribute("href");
            }
        }
        String actual = null;
        if (link != null) {
            driver.get(link);
            actual = driver.findElement(By.className("job_post_date")).getText();
        }
        assertTrue(expected.equals(actual), String.format("Expected date is: %s, but was: %s", expected, actual));
    }

    @Test
    public void checkResultSize() {
        String expected = "29";
        doSearch();

        String actual = driver.findElement(By.className("total_results")).getText();
        assertTrue(actual.equals(expected), String.format("Expected results: %s, but was: %s", expected, actual));
    }

    @AfterClass
    public void quit() {
        if (driver != null) {
            driver.close();
        }
    }

    private void doSearch() {
        driver.get(URL);
        driver.findElement(By.id("keyword")).sendKeys("test");
        driver.findElement(By.id("jLocInputHldr")).click();
        driver.findElement(By.xpath("//*[@id=\"location_facet_chzn_o_18\"]")).click();
        driver.findElement(By.id("jSearchSubmit")).click();

//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("job_results_list_hldr")));
        sleep();
    }

    private void sleep() {
        try {
            Thread.sleep(10 * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
