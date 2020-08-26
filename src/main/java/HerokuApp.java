import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HerokuApp {

    public static final String ADD_REMOVE_ELEMENTS_URL = "add_remove_elements/";
    public static final String ADDED_BUTTON_CSS = ".added-manually";

    WebDriver driver;
    URL url;
    CommonPageMethods commonPageMethods;
//    HerokuApp herokuApp;

    public HerokuApp(WebDriver driver) {
        this.driver = driver;
        url = new URL();
        commonPageMethods = new CommonPageMethods(driver);
//        this.herokuApp = new HerokuApp(driver);
    }

    /**
     *Add/Remove Elements
     */
    public void getAddOrRemoveUrl() {
        String addOrRemoveElementUrl = url.HEROKUAPPTESTS_URL + ADD_REMOVE_ELEMENTS_URL;
        driver.get(addOrRemoveElementUrl);
    }

    public void clickAddElementButton(int randomTimesOfClick) {
        for (int i = 0; i < randomTimesOfClick; i++) {
            WebElement addElementButton = driver.findElement(By.cssSelector("div > button"));
            addElementButton.click();
        }
    }

    public int countOfElementsOnPage(String cssLocator) {
        return driver.findElements(By.cssSelector(cssLocator)).size();
    }

    public int getRandomNumberOfItemsToDelete(int numberOfAddedButtons) {
        return commonPageMethods.getRandomNumberFromTo(1, numberOfAddedButtons);
    }

    public void clickDeleteButtonRandomTimes(int numberOfButtonsToDelete) {
        for (int i = 1; i <= numberOfButtonsToDelete; i++) {
            WebElement deleteButton = driver.findElement(By.cssSelector(ADDED_BUTTON_CSS));
            deleteButton.click();
        }
    }

}
