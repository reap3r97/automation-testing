package hamza;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class assertion {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");

        // Assertion to check is checkbox clicked is false
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        // Selecting checkbox
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

        // Assertion to check true result
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        // Counting number of checkboxes
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        // Selecting a dropdown tag
        driver.findElement(By.id("divpaxinfo")).click();

        // Adding sleep because the dropdown can take time to load
        Thread.sleep(1000);

        // Selecting the increase button to add one more passenger in our search. only
        // selects once
        driver.findElement(By.id("hrefIncAdt")).click();

        // looping to select multiple times
        for (int i = 0; i < 4; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        driver.findElement(By.id("btnclosepaxoption")).click();

        // Assert equals condition to confirm if returned value is equal to expected value
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "6 Adult");

        String passengerText = driver.findElement(By.id("divpaxinfo")).getText();
        System.out.println("Number of Passengers: " + passengerText);

        Thread.sleep(2000);
        driver.quit();

    }
}
