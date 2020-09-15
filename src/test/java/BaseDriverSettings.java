import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseDriverSettings {

    WebDriver driver;

    @BeforeClass
    public void doBeforeClass() {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bogu\\Downloads\\chromedriver.exe");
        }
        else if (System.getProperty("os.name").toLowerCase().contains("lin")) {
            System.setProperty("webdriver.chrome.driver", "\\home\\pi\\Downloads\\chromedriver");
        }
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bogu\\Downloads\\chromedriver.exe");
//        System.out.println(System.getProperty("os.name"));
//        if(System.getProperty("os.name").toLowerCase().contains("win"))
//            chromedriverPath+=".exe";
//        System.setProperty("webdriver.chrome.driver",chromedriverPath);
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1200x600");
        driver = new ChromeDriver(options);
        initialize();
    }

    @AfterClass
    public void afterClass() {
        if(null != driver) {
            driver.close();
        }
    }

    public abstract void initialize();
}