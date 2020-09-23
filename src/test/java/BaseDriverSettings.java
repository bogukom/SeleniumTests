import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseDriverSettings {

    WebDriver driver;

    @BeforeClass
    public void doBeforeClass() {
        String operatingSystem = System.getProperty("os.name").toLowerCase();
        System.out.println(System.getProperty("os.name"));

        if (operatingSystem.contains("win")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bogu\\Downloads\\chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless");
            options.addArguments("--window-size=1200x600");
            driver = new ChromeDriver(options);
        }
        else if (operatingSystem.contains("lin")) {
            System.setProperty("webdriver.chrome.driver", "\\home\\pi\\Downloads\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--window-size=1200x600");
            options.setBinary("\\usr\\lib\\chromium-browser");
            driver = new ChromeDriver(options);
        }
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bogu\\Downloads\\chromedriver.exe");
//        System.out.println(System.getProperty("os.name"));
//        if(System.getProperty("os.name").toLowerCase().contains("win"))
//            chromedriverPath+=".exe";
//        System.setProperty("webdriver.chrome.driver",chromedriverPath);
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        options.addArguments("--window-size=1200x600");
//        driver = new ChromeDriver(options);
        initialize();
    }

    @AfterClass
    public void afterClass() {
        if(null != driver) {
            driver.quit();
        }
    }

    public abstract void initialize();
}