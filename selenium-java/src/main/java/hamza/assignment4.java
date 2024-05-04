package hamza;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class assignment4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");

        driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
        // or: driver.findElement(By.linkText("Multiple Windows")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
        // or: driver.findElement(By.cssSelector("a[href*='windows']")).click();

        // To get IDs of the tabs open in the browser
        Set<String> windows = driver.getWindowHandles();

        // Using iterator to get id of child tab
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();

        // Switching to child window
        driver.switchTo().window(childId);

        String childText = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText();
        // or: driver.findElement(By.xpath("//div/h3")).getText()
        Assert.assertEquals(childText, "New Window");
        System.out.println(childText);

        // Switching to parent window
        driver.switchTo().window(parentId);
        String parentText = driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText();
        // or: By.xpath("//div[@id='content']/div/h3")).getText()
        Assert.assertEquals(parentText, "Opening a new window");
        System.out.println(parentText);

        Thread.sleep(2000);
        driver.quit();
    }
}
