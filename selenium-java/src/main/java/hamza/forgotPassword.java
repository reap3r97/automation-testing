package hamza;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class forgotPassword {
    public static void main(String[] args) {
        String infoMessage;

        System.setProperty("webdriver.chrome.driver",
                "C:/Users/Hamza/chromedriver/chromedriver-win64/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/locatorspractice/");

        // Adding implicit delay to wait for the info message
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

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

        // Using traversing from parent to child to select locator
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("12345");

        // Pressing submit. Issue arises. Single page application that's why some other
        // element is being triggered instead of the intended one
        // We have to wait for the new page to render. Which is the fix
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

        // Printing out the message that comes on top
        infoMessage = driver.findElement(By.cssSelector("form p")).getText();
        System.out.println(infoMessage);

        driver.close();
    }
}
