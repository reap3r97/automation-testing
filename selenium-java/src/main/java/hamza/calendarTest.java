package hamza;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;;

public class calendarTest {
    public static void main(String[] args) throws InterruptedException {
        String month = "6";
        String day = "20";
        String year = "2027";
        String[] expectedList = { month, day, year };

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()='" + year + "']")).click();

        // Getting all months elements then getting June by index
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month"))
                .get(Integer.parseInt(month) - 1).click();

        driver.findElement(By.xpath("//abbr[text()='" + day + "']")).click();

        // Getting the resulting date
        List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        for (int i = 0; i < actualList.size(); i++) {
            System.out.println(actualList.get(i).getAttribute("value"));
            Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
