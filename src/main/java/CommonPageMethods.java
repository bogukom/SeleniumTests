import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class CommonPageMethods {

    WebDriver driver;

    public CommonPageMethods(WebDriver driver) {
        this.driver = driver;
    }

    public int getRandomNumberFromTo(int min, int max) {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(max - min + 1) + min;
    }

    public String alertGetText() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert.getText();
    }

    public boolean verifyIsAlertVisible() {
        try {
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    public void acceptAlert() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}
