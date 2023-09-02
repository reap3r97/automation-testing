package hamza;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators {
    public static void main(String[] args) {
        String error;

        System.setProperty("webdriver.chrome.driver",
                "C:/Users/Hamza/chromedriver/chromedriver-win64/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/locatorspractice/");

        // Now finding element by it's id
        // .SendKeys() function will send some data as input
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");

        // Finding element by it's name and adding input
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");

        // Finding element by it's class and sending input through click() which will
        // click the button
        driver.findElement(By.className("signInBtn")).click();

        // Using CSS selector to get text of the error message generated
        error = driver.findElement(By.cssSelector("p.error")).getText();
        System.out.println(error);

        driver.close();
    }
}
