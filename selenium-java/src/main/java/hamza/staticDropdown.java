package hamza;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class staticDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");

        // Dropdown with select tag. Select tag is static dropdown so elements can be searched by index
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);

        // 
        // Selecting value by index
        dropdown.selectByIndex(3);

        // This gets the first selected option. returns web element
        String text = dropdown.getFirstSelectedOption().getText();
        System.out.println(text);

        // Select value by text
        dropdown.selectByVisibleText("AED");
        text = dropdown.getFirstSelectedOption().getText();
        System.out.println(text);

        // Select value by value attribute of html element
         dropdown.selectByValue("INR");
        text = dropdown.getFirstSelectedOption().getText();
        System.out.println(text);
        
        driver.quit();

    }
}
