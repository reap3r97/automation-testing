package hamza;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class assignment6 {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");

        driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input")).click();
        String option = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();

        WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
        Select select = new Select(dropdown);
        select.selectByVisibleText(option);

        driver.findElement(By.name("enter-name")).sendKeys(option);
        driver.findElement(By.id("alertbtn")).click();

        String text = driver.switchTo().alert().getText();

        if (text.contains(option)) {
            System.out.println("Alert Success");
        } else {
            System.out.println("Alert Unsuccessful");
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
