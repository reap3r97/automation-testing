package hamza;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class elementStateValidation {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");

        // Assertion to check is checkbox clicked is false
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        // Selecting checkbox
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

        // Assertion to check true result
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        // Finding round way radio button
        boolean state = driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled();
        System.out.println(state); // False because it's disabled when round trip is not selected
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        state = driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled();
        System.out.println(state);

        // Getting value of the attribute that is changing when we enable/disable
        // element for calendar
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        String style = driver.findElement(By.id("Div1")).getAttribute("style");
        System.out.println(style);

        if (style.contains("1")) {
            System.out.println("Return date is enabled");
            Assert.assertTrue(true);
        } else {
            System.out.println("Return date is disabled");
            Assert.assertTrue(false);
        }

        Thread.sleep(1000);
        driver.quit();

    }
}
