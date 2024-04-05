package hamza;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assignment3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Adding input to fields
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.xpath("//input[@value='user']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.modal-body")));
        driver.findElement(By.id("okayBtn")).click();

        WebElement options = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select dropdown = new Select(options);

        dropdown.selectByValue("consult");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));

        List<WebElement> products = driver.findElements(By.cssSelector(".card-footer .btn-info"));

        for (int i = 0; i < products.size(); i++) {
            products.get(i).click();
        }

        driver.findElement(By.partialLinkText("Checkout")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-success")));
        driver.findElement(By.cssSelector(".btn-success")).click();

        Thread.sleep(2000);
        driver.quit();
    }
}