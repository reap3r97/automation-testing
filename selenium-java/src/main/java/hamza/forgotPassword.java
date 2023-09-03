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
        
        driver.close();
    }
}
