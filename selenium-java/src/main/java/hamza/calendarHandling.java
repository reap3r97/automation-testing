package hamza;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendarHandling {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        driver.findElement(By.xpath("//a[@value='MAA']")).click(); // this will select first element found
        Thread.sleep(1000);

        driver.findElement(By
                .xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='HYD']"))
                .click(); // selects element according to parent-child relation

        // Selecting current date
        driver.findElement(By
                .cssSelector(".ui-state-default.ui-state-highlight"))
                .click();

        Thread.sleep(2000);
        driver.quit();
    }
}
