package hamza;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class cartItems {
    public static void main(String[] args) throws InterruptedException {
        // Expected array
        String[] itemsNeeded = { "Cucumber", "Walnuts", "Strawberry" };
        int count = 0;

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        // Getting all products because no product is unique in the list
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        Thread.sleep(3000);

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

                // Adding count to be incremented everytime an item is found and then
                // Checking if that count is equal to total count of items needed, if yes then
                // break
                if (count == itemsNeeded.length) {
                    System.out.println("sup");
                    break;
                }

            }
        }

        Thread.sleep(5000);
        driver.quit();

    }
}
