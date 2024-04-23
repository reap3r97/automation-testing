package hamza;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ebay.com");

        // Initialising the action for interaction
        Actions actions = new Actions(driver);
       
        WebElement move = driver.findElement(By.xpath("//a[@title='My eBay']"));
        WebElement textBox = driver.findElement(By.id("gh-ac"));
      
        // Building the interaction which moves to specified element
        actions.moveToElement(textBox).click().keyDown(Keys.SHIFT).sendKeys("Hello");

        // Double clicking the text added to text box 
        actions.moveToElement(textBox).doubleClick();

        // To move to element
        actions.moveToElement(move);

        // To right click
        actions.moveToElement(move).contextClick().build().perform();

        Thread.sleep(3000);
        driver.quit();
    }
}
