import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage {

    WebDriver driver;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public void typeValueInGoogleAndSearch (String stringToSearch) {
        WebElement searchArea = driver.findElement(By.name("q"));
        searchArea.sendKeys(stringToSearch);
        searchArea.sendKeys(Keys.ENTER);
    }
}
