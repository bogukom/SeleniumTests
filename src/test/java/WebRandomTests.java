import org.testng.Assert;
import org.testng.annotations.Test;

public class WebRandomTests extends BaseDriverSettings {

    URL url;
    GooglePage googlePage;

    @Override
    public void initialize() {
        url = new URL();
        googlePage = new GooglePage(driver);
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
