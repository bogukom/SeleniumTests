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

    public Alert waitUntilAlertIsPresented() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public String alertGetText() {
        Alert alert = waitUntilAlertIsPresented();
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
        Alert alert = waitUntilAlertIsPresented();
        alert.accept();
    }
}
