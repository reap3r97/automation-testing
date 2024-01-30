package hamza;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class assignment2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice");

        // Adding input to fields
        driver.findElement(By.name("name")).sendKeys("Ham");
        driver.findElement(By.name("email")).sendKeys("test@test.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("abc123");
        driver.findElement(By.id("exampleCheck1")).click();

        // Using Select to select option by their index
        Select gender = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
        gender.selectByIndex(0);

        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).sendKeys("12/03/1997");
        driver.findElement(By.cssSelector(".btn-success")).click();
       
        String result = driver.findElement(By.cssSelector(".alert-success")).getText();
        System.out.println("result: " + result);
        Assert.assertTrue(true,result);

        Thread.sleep(2000);
        driver.quit();
    }
}
