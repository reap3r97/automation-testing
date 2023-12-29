package hamza;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowActivities {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        // To run browser in full screen mode
        driver.manage().window().maximize();

        driver.get("https://www.torn.com"); // waits to fully load page
        driver.navigate().to("https://www.rahulshettyacademy.com"); // navigates to a
                                                                    // different page as soon as one
                                                                    // thing is loaded. use implicit or explicit wait or
                                                                    // thread.sleep() to fully load
        driver.navigate().back(); // to navigate back to previous page
        driver.navigate().forward(); // navigate to the new page

        driver.close();

    }
}
