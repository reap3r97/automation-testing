package hamza;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class siblingTraversal {
    public static void main(String[] args) throws InterruptedException {
        String buttonText = "";

        System.setProperty("webdriver.chrome.driver",
                "C:/Users/Hamza/chromedriver/chromedriver-win64/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.rahulshettyacademy.com/AutomationPractice");

        // We will create a locator which does sibling traversal to find an item
        buttonText = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();
        System.out.println(buttonText);

        driver.quit();
    }
}
