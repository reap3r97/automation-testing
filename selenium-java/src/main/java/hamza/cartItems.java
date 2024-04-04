package hamza;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class cartItems {
    public static void main(String[] args) throws InterruptedException {
        // Expected array
        String[] itemsNeeded = { "Cucumber", "Walnuts", "Strawberry" };
        String promoCode = "rahulshettyacademy";

        WebDriver driver = new ChromeDriver();

        // Implicit wait code
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        addItems(driver, itemsNeeded);

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        // only use text in xpath when we know our text will be static
        driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();

        // Next page where we add promo code takes some time to load so we need to add
        // implicit/explicit wait before adding promo code
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys(promoCode);
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        String promoInfo = driver.findElement(By.cssSelector("span.promoInfo")).getText();
        Assert.assertEquals(promoInfo, "Code applied ..!");

        Thread.sleep(5000);
        driver.quit();

    }

    public static void addItems(WebDriver driver, String[] itemsNeeded) {
        int count = 0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < products.size(); i++) {
            // Taking text and then formatting it to take only the name needed
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();

            // Check whether names taken are present in array or not
            // Convert array into array list for easy searching
            List itemsNeededList = Arrays.asList(itemsNeeded);

            if (itemsNeededList.contains(formattedName)) {
                count++;

                // Finds Add to cart option of cucumber by the index it found cucumber on and
                // then clicks it
                driver.findElements(By.xpath("//div[@class='product-action'] /button")).get(i).click();

                // Adding count to be incremented every time an item is found and then
                // Checking if that count is equal to total count of items needed, if yes then
                // break
                if (count == itemsNeeded.length) {
                    System.out.println("sup");
                    break;
                }

            }
        }
    }
}
