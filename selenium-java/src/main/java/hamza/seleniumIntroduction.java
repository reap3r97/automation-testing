package hamza;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumIntroduction {
    public static void main(String[] args) {
        // Invoking Browser
        // Webdriver methods + class
        // If we had initialized using ChromeDriver() then we would only have access to
        // methods of ChromeDriver()
        // We used WebDriver, so now we have access to methods of ChromeDriver() which
        // are defined in WebDriver interface

        // Weirdly enough, need to download chrome driver according to the version of
        // chrome and then add the path here like it is so that the chrome driver
        // actually works
        // If it's not done then it will not work
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/Hamza/chromedriver/chromedriver-win64/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.close();

    }
}
