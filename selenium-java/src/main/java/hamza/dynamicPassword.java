package hamza;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class dynamicPassword {
    public static void main(String[] args) throws InterruptedException {
        String password, successMessage;
        String name = "ham";

        System.setProperty("webdriver.chrome.driver",
                "C:/Users/Hamza/chromedriver/chromedriver-win64/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // Adding implicit delay to wait for the info message
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        // Calling the function here to extract password
        password = getPassword(driver);

        driver.get("https://www.rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        successMessage = driver.findElement(By.tagName("p")).getText();

        // We need to add an assertion to make sure what we get is what we need
        Assert.assertEquals(successMessage, "You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),
                "Hello " + name + ",");
        System.out.println(successMessage);

        driver.close();
    }

    // Creating this method to extract password from the info message we get
    public static String getPassword(WebDriver driver) throws InterruptedException {
        String infoMessage, password;

        driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        infoMessage = driver.findElement(By.cssSelector("form p")).getText();

        // Splitting the message we get with ' character
        String[] infoMessageArray = infoMessage.split("'");
        password = infoMessageArray[1].split("'")[0];

        return password;
    }
}
