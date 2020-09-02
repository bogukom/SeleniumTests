import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HerokuApp {

    public static final String ADD_REMOVE_ELEMENTS_URL = "/add_remove_elements/";
    public static final String ADDED_BUTTON_CSS = ".added-manually";
    public static final String BROKEN_IMAGES_URL = "/broken_images";
    public static final String IMAGE_ELEMENT_IN_BROKEN_IMAGES_CSS = ".example img";
    public static final String CHECKBOXES_URL = "/checkboxes";
    public static final String CHECKBOXES_1_CSS = "#checkboxes > input[type=checkbox]:nth-child(1)";
    public static final String CHECKBOXES_2_CSS = "#checkboxes > input[type=checkbox]:nth-child(2)";

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
     * Add/Remove Elements
     */
    public void getHerokuAppExampleUrl(String examplePartUrl) {
        String addOrRemoveElementUrl = url.HEROKUAPPTESTS_URL + examplePartUrl;
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

    public int countImages() {
        return driver.findElements(By.cssSelector(IMAGE_ELEMENT_IN_BROKEN_IMAGES_CSS)).size();
    }

    public int verifyIsImageBrokenAndReturnNumberOfBrokenElements() {
        int numberOfBrokenImages = 0;

        for (WebElement image : driver.findElements(By.cssSelector("img"))) {
            if (image.getAttribute("naturalWidth").equals("0")) {
                numberOfBrokenImages += 1;
            }
        }
        return numberOfBrokenImages;
    }

    public void checkUncheckedCheckBoxes() {
        for(WebElement checkbox : driver.findElements(By.cssSelector("form#checkboxes input"))) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    public boolean verifyIfAllCheckboxesAreChecked() {
        for(WebElement checkbox : driver.findElements(By.cssSelector("form#checkboxes input"))) {
            if (checkbox.isSelected()) {
                return true;
            }
        }
        return verifyIfAllCheckboxesAreChecked();
    }
}
