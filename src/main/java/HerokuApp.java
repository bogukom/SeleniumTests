import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class HerokuApp {

    public static final String ADD_REMOVE_ELEMENTS_URL = "/add_remove_elements/";
    public static final String ADDED_BUTTON_CSS = ".added-manually";
    public static final String BROKEN_IMAGES_URL = "/broken_images";
    public static final String IMAGE_ELEMENT_IN_BROKEN_IMAGES_CSS = ".example img";
    public static final String CHECKBOXES_URL = "/checkboxes";
    public static final String CONTEXT_MENU_URL = "/context_menu";
    public static final String CONTEXT_BOX_ID = "hot-spot";
    public static final String DIGEST_AUTH_URL = "/digest_auth";
    public static final String AUTHENTICATION_SUCCESS_MESSAGE_CSS = "#content > div > p";

    WebDriver driver;
    URL url;
    CommonPageMethods commonPageMethods;

    public HerokuApp(WebDriver driver) {
        this.driver = driver;
        url = new URL();
        commonPageMethods = new CommonPageMethods(driver);
    }

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
        for (WebElement checkbox : driver.findElements(By.cssSelector("form#checkboxes input"))) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    public boolean verifyIfAllCheckboxesAreChecked() {
        for (WebElement checkbox : driver.findElements(By.cssSelector("form#checkboxes input"))) {
            if (checkbox.isSelected()) {
                return true;
            }
        }
        return verifyIfAllCheckboxesAreChecked();
    }

    public void rightClickOnContextBox() {
        WebElement contextBox = driver.findElement(By.id(CONTEXT_BOX_ID));
        Actions actions = new Actions(driver);
        actions.contextClick(contextBox).perform();
    }

    public void enterUserNameAndPassword(String userName, String pass) {
        String loginUrl = "https://" + userName + ":" + pass + "@" + url.HEROKUAPPTESTS_AUTH_URL + DIGEST_AUTH_URL;
        driver.get(loginUrl);
    }

    public String getSuccessLoginText() {
        return driver.findElement(By.cssSelector(AUTHENTICATION_SUCCESS_MESSAGE_CSS)).getText();
    }
}
