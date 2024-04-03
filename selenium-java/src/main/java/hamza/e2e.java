package hamza;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class e2e {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");

        // Selecting trip to be one way only
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='DEL']")).click(); // this will select first element found

        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='HYD']"))
                .click(); // selects element according to parent-child relation

        // Selecting current date
        driver.findElement(By
                .cssSelector(".ui-state-default.ui-state-highlight"))
                .click();

        // Returning true because we chose only one way trip and not round trip and 0.5
        // val is for disabled
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
            System.out.println("its disabled");
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

        // Selecting a dropdown tag
        driver.findElement(By.id("divpaxinfo")).click();

        // Adding sleep because the dropdown can take time to load
        Thread.sleep(1000);

        for (int i = 0; i < 4; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        String passengerText = driver.findElement(By.id("divpaxinfo")).getText();
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
        System.out.println("Number of Passengers: " + passengerText);

        // Now we click on search button
        driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
        // driver.findElement(By.cssSelector("input[value="Search"]")).click();
        // driver.findElement(By.xpath("//input[@value="Search"]")).click();

        Thread.sleep(10000);
        // driver.quit();

    }
}
