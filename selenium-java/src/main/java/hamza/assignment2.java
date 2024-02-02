package hamza;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class assignment2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice");

        driver.findElement(By.xpath("//div[@class='form-group']//input[@name='name']")).sendKeys("Ranju");

        driver.findElement(By.xpath("//div[@class='form-group']//input[@name='email']")).sendKeys("r@gmail.com");

        driver.findElement(By.xpath("//div[@class='form-group']//input[@type='password']")).sendKeys("Ran12");

        driver.findElement(By.xpath("//div[@class='form-check']//input[@type='checkbox']")).click();

        WebElement staticDropdown = driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']"));

        Select dropdown = new Select(staticDropdown);

        dropdown.selectByVisibleText("Female");

        driver.findElement(By.xpath("//input[@value='option1']")).click();

        driver.findElement(By.xpath("//input[@type='date']")).sendKeys("02/09/1994");

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        System.out.println(driver.findElement(By.cssSelector("div[class*='alert-success']")).getText());
        Thread.sleep(5000);
        driver.quit();
    }
}
