package hamza;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class handlingTabs {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

        driver.findElement(By.cssSelector(".blinkingText")).click();

        // To get IDs of the tabs open in the browser
        Set<String> windows = driver.getWindowHandles();

        // Using iterator to get id of child tab
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();

        // Switching to child window
        driver.switchTo().window(childId);
       

        // Taking the text then extracting email from the text we got
        String email = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
        Assert.assertEquals(email, "mentor@rahulshettyacademy.com");

        // Switching to parent window
        driver.switchTo().window(parentId);

        // Sending extracted email here
        driver.findElement(By.id("username")).sendKeys(email);
       
        Thread.sleep(2000);
        driver.quit();
    }
}
