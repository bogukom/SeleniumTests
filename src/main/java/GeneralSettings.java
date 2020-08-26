import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GeneralSettings {
    WebDriver driver;

    public void setChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public void enterValueToTextField(String number) {
        WebElement textField = driver.findElement(By.id("number"));
        textField.sendKeys(number);
    }

    public void clickSubmitButton() {
        WebElement submit = driver.findElement(By.id("getFactorial"));
        submit.click();
    }

    public String result() {
        return driver.findElement(By.id("resultDiv")).getText();
    }
}
