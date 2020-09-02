import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HerokuAppTests {

    WebDriver driver;
    URL url;
    HerokuApp herokuApp;
    CommonPageMethods commonPageMethods;

    @BeforeTest
    public void doBeforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bogu\\Downloads\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1200x600");
        driver = new ChromeDriver();

        url = new URL();
        commonPageMethods = new CommonPageMethods(driver);
        herokuApp = new HerokuApp(driver);

    }

    @AfterSuite
    public void afterSuite() {
        if(null != driver) {
            driver.close();
        }
    }

    @Test
    public void clickRandomTimesAddElementAndVerifyIfNumberOfAddedButtonsIsProper() {
        int numberOfClick = commonPageMethods.getRandomNumberFromTo(1, 100);

        herokuApp.getHerokuAppExampleUrl(HerokuApp.ADD_REMOVE_ELEMENTS_URL);
        herokuApp.clickAddElementButton(numberOfClick);

        Assert.assertEquals(herokuApp.countOfElementsOnPage(HerokuApp.ADDED_BUTTON_CSS), numberOfClick);
    }

    @Test
    public void deleteRandomNumberOfAddedButtonsAndCheckIsDeleteWorks() {
        int clickAdd = commonPageMethods.getRandomNumberFromTo(1, 100);
        int clickDelete = herokuApp.getRandomNumberOfItemsToDelete(clickAdd);

        herokuApp.getHerokuAppExampleUrl(HerokuApp.ADD_REMOVE_ELEMENTS_URL);
        herokuApp.clickAddElementButton(clickAdd);
        herokuApp.clickDeleteButtonRandomTimes(clickDelete);

        Assert.assertEquals(herokuApp.countOfElementsOnPage(HerokuApp.ADDED_BUTTON_CSS), clickAdd - clickDelete);
    }

    @Test
    public void verifyIsImageBroken() {
        int numberOfWorkingImages = 1;

        herokuApp.getHerokuAppExampleUrl(HerokuApp.BROKEN_IMAGES_URL);

        Assert.assertEquals(herokuApp.countImages() - numberOfWorkingImages,
                herokuApp.verifyIsImageBrokenAndReturnNumberOfBrokenElements());
    }

    @Test
    public void changeAllCheckBoxesToCheckedAndVerify() {
        herokuApp.getHerokuAppExampleUrl(HerokuApp.CHECKBOXES_URL);
        herokuApp.checkUncheckedCheckBoxes();

        Assert.assertTrue(herokuApp.verifyIfAllCheckboxesAreChecked());
    }
}
