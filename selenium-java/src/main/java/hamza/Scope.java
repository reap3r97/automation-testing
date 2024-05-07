package hamza;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();

        driver.get("http://qaclickacademy.com/practice.php");

        // 1. Get count of all links on the page
        int linksCount = driver.findElements(By.tagName("a")).size();
        System.out.println(linksCount);

        // 2. Get count of all links on footer of page
        // Limiting driver scope to only the footer of page
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        int footerLinksCount = footerDriver.findElements(By.tagName("a")).size();
        System.out.println(footerLinksCount);

        // 3. Get count of all links in first column of footer of page
        WebElement firstColumnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        int firstColumnLinksCount = firstColumnDriver.findElements(By.tagName("a")).size();
        System.out.println(firstColumnLinksCount);

        // 4. Click on each link in the column and check if tabs are opening
        for (int i = 1; i < firstColumnLinksCount; i++) {
            String click = Keys.chord(Keys.CONTROL, Keys.ENTER);
            firstColumnDriver.findElements(By.tagName("a")).get(i).sendKeys(click);
            // Thread.sleep(5000);
        }

        // Now we get title of each tab open
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            driver.switchTo().window(iterator.next());
            String title = driver.getTitle();
            System.err.println(title);
        }

        Thread.sleep(2000);
        driver.close();
    }
}
