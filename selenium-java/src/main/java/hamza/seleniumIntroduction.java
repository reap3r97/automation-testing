package hamza;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumIntroduction {
    public static void main(String[] args) {
        // Invoking Browser
        // Webdriver methods + class
        // If we had initialized using ChromeDriver() then we would only have access to methods of ChromeDriver()
        // We used WebDriver, so now we have access to methods of ChromeDriver() which are defined in WebDriver interface
        
        WebDriver driver = new ChromeDriver();
    }
}
