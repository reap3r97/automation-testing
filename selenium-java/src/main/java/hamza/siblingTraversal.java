package hamza;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class siblingTraversal {
    public static void main(String[] args) throws InterruptedException {
        String buttonText = "";

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.rahulshettyacademy.com/AutomationPractice");

        // We will create a locator which does sibling traversal to find an item
        buttonText = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();
        System.out.println(buttonText);

        // Child to parent locator traversal
        buttonText = driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header")).getText();
        System.out.println(".......");
        System.out.println(buttonText);

        driver.quit();
    }
}
