package hamza;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class forgotPassword {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/Hamza/chromedriver/chromedriver-win64/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/locatorspractice/");

        // Using linkText for when links 'a' are used and have no other identifiers
        driver.findElement(By.linkText("Forgot your password?")).click();

        // Using XPATH for accessing fields
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");

        // Using customised syntax to deal with CSS
        driver.findElement(By.cssSelector("input[placeholder=Email]")).sendKeys("John@rsa.com");

        // To clear input field. We wrote xpath like this just in case there is no
        // unique identifier. So, there will be given indexes on how many fields are
        // there and from there we chose #2
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

        // Using indexing in CSS to get field index
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("John@rsa.com");

        driver.close();
    }
}
