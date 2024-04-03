package hamza;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class alerts {
    public static void main(String[] args) throws InterruptedException {
        String text = "Ham";
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(2000);

        // Taking text from the alert button
        text = driver.switchTo().alert().getText();
        Assert.assertEquals(text, "Hello Ham, share this practice page and share your knowledge");

        // Add code to press ok on browser alerts which are not part of the code and
        // this alert has one option ok, yes
        driver.switchTo().alert().accept();

        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(2000);
        text = driver.switchTo().alert().getText();
        Assert.assertEquals(text, "Hello , Are you sure you want to confirm?");

        // Add code to press cancel/ok on browser alerts which are not part of the code
        // and this alert has two options, ok, cancel, yes, no
        driver.switchTo().alert().accept();

        Thread.sleep(1000);
        driver.quit();

    }
}
