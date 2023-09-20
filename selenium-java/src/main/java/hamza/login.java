package hamza;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class login {
    public static void main(String[] args) {
        String successMessage;
        String name = "ham";
        String password = "rahulshettyacademy";

        System.setProperty("webdriver.chrome.driver",
                "C:/Users/Hamza/chromedriver/chromedriver-win64/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/locatorspractice/");

        // Now finding element by it's id
        // .SendKeys() function will send some data as input
        driver.findElement(By.id("inputUsername")).sendKeys(name);

        // Finding element by it's name and adding input
        driver.findElement(By.name("inputPassword")).sendKeys(password);

        // Finding element by it's class and sending input through click() which will
        // click the button
        driver.findElement(By.className("signInBtn")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Taking success message
        successMessage = driver.findElement(By.tagName("p")).getText();
        // We need to add an assertion to make sure what we get is what we need
        Assert.assertEquals(successMessage, "You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),
                "Hello " + name + ",");
        System.out.println(successMessage);

        // Logout
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();

        driver.close();
    }
}