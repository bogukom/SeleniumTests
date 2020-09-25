import org.testng.Assert;
import org.testng.annotations.Test;

public class HerokuAppTests extends BaseDriverSettings {

    URL url;
    HerokuApp herokuApp;
    CommonPageMethods commonPageMethods;

    @Override
    public void initialize() {
        this.url = new URL();
        this.commonPageMethods = new CommonPageMethods(driver);
        this.herokuApp = new HerokuApp(driver);
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

    @Test
    public void verifyIsAlertVisible() {
        herokuApp.getHerokuAppExampleUrl(HerokuApp.CONTEXT_MENU_URL);
        herokuApp.rightClickOnContextBox();

        Assert.assertTrue(commonPageMethods.verifyIsAlertVisible());
    }

    @Test
    public void rightClickContextBoxAndVerifyAlertText() {
        String alertText = "You selected a context menu";

        herokuApp.getHerokuAppExampleUrl(HerokuApp.CONTEXT_MENU_URL);
        herokuApp.rightClickOnContextBox();

        Assert.assertEquals(commonPageMethods.alertGetText(), alertText);
    }

    @Test
    public void acceptAlertAndVerifyIsNotVisible() {
        herokuApp.getHerokuAppExampleUrl(HerokuApp.CONTEXT_MENU_URL);
        herokuApp.rightClickOnContextBox();
        commonPageMethods.acceptAlert();

        Assert.assertFalse(commonPageMethods.verifyIsAlertVisible());
    }

    @Test
    public void digestAuthenticationUserAndPass() {
        String loginSuccessMessage = "Congratulations! You must have the proper credentials.";

        herokuApp.enterUserNameAndPassword("admin", "admin");

        Assert.assertEquals(herokuApp.getSuccessLoginText(), loginSuccessMessage);
    }
}
