package hamza;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class updatedStaticDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");

        // Selecting checkbox
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

        // To check if checkbox is selected or not
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

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

        String passengerText = driver.findElement(By.id("divpaxinfo")).getText();
        System.out.println("Number of Passengers: " + passengerText);

        Thread.sleep(1000);
        driver.quit();

    }
}
