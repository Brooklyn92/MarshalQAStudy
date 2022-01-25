import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitTest2 {

    @Test
    public void testWaits2(){
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            driver.get("https://pagination.js.org/index.html");
            Thread.sleep(2000); // пауза в выполнение 2 сек

            List<WebElement> elements = driver.findElements(By.xpath("//div[@class = 'data-container']/ul/li"));
            List<WebElement> page = driver.findElements(By.xpath("//div[@class = 'paginationjs-pages']/ul/li"));
            String text = elements.get(5).getText(); // получаем текс 5 элемента li и присваиваем для вывода на экран переменной text
            System.out.println(text);

            page.get(2).click(); // переходим на 2 элемент li, что является 2-ой страницей
            wait.until(ExpectedConditions.stalenessOf(elements.get(5))); // убеждаемся, что элемент на текущей странице пропал

           elements = driver.findElements(By.xpath("//div[@class = 'data-container']/ul/li"));
           text = elements.get(5).getText(); // получаем 5 элемент li следующей страницы
           System.out.println(text);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                Thread.sleep(2000);
                driver.quit();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
