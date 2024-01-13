package hamza;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class assignment1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice");

        // Clicking the first checkbox to select
        driver.findElement(By.cssSelector("input[id*='checkBoxOption1']")).click();

        // Assertion to check is checkbox clicked is true
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='checkBoxOption1']")).isSelected());

        // Clicking the first checkbox again to unselect
        driver.findElement(By.cssSelector("input[id*='checkBoxOption1']")).click();

        // Assertion to check false result
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='checkBoxOption1']")).isSelected());

        // Assertion to check number of checkboxes are 3
        Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), 3);

        Thread.sleep(1000);
        driver.quit();

    }
}
