package hamza;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class autoSuggestiveDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(3000);

        // get all items present in auto suggestive list
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        // iterate through the options element
        for (WebElement option : options) {
            System.out.println(option.getText());

            // finding option that equals india and not case sensitive then clicking it then
            // breaking the loop
            if (option.getText().equalsIgnoreCase("India")) {
                option.click();
                break;
            }
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
