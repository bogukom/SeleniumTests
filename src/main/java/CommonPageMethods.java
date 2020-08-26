import org.openqa.selenium.WebDriver;

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
}
