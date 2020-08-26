import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebRandomTests {

    WebDriver driver;
    URL url;
    GooglePage googlePage;

    @BeforeTest
    public void doBeforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bogu\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        url = new URL();
        googlePage = new GooglePage(driver);

    }

    @AfterSuite
    public void afterSuite() {
        if(null != driver) {
            driver.close();
        }
    }

    @Test(testName = "Run www.google.pl", description = "Run Google page and verify title")
    public void runGooglePage() {
        driver.get(url.GOOGLE_URL);

        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @Test(testName = "Search 'Polska' in google", description = "Search 'Polska' in google")
    public void searchPolandInGoogleAndOpenWikipediaDetails() {
        driver.get(url.GOOGLE_URL);
        googlePage.typeValueInGoogleAndSearch("Polska");

    }
}
