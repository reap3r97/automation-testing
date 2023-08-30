package hamza;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class seleniumIntroduction {
    public static void main(String[] args) {
        String browserTitle, currentUrl;

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

        // Code to redirect to a url
        driver.get("https://google.com");

        // To get the title of the browser and then print it
        browserTitle = driver.getTitle();
        System.out.println("Browser Title is: " + browserTitle);

        // To get current url
        currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL is: " + currentUrl);

        driver.close();

        // For invoking firefox driver
        // Gecko driver is used for firefox
        System.setProperty("webdriver.gecko.driver",
                "C:/Users/Hamza/geckodriver/geckodriver.exe");
        WebDriver firefoxDriver = new FirefoxDriver();

        // Code to redirect to a url
        firefoxDriver.get("https://reddit.com");

        // To get the title of the browser and then print it
        browserTitle = firefoxDriver.getTitle();
        System.out.println("Browser Title is: " + browserTitle);

        // To get current url
        currentUrl = firefoxDriver.getCurrentUrl();
        System.out.println("Current URL is: " + currentUrl);

        firefoxDriver.quit();

        // For invoking firefox driver
        // Gecko driver is used for firefox
        System.setProperty("webdriver.edge.driver",
                "C:/Users/Hamza/edgedriver/msedgedriver.exe");
        WebDriver edgeDriver = new EdgeDriver();

        // Code to redirect to a url
        edgeDriver.get("https://torn.com");

        // To get the title of the browser and then print it
        browserTitle = edgeDriver.getTitle();
        System.out.println("Browser Title is: " + browserTitle);

        // To get current url
        currentUrl = edgeDriver.getCurrentUrl();
        System.out.println("Current URL is: " + currentUrl);

        edgeDriver.close();
    }
}
