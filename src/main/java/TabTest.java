import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class TabTest {
    @Test
    public void alertTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver,1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            driver.get("https://yandex.ru/");
            Thread.sleep(5000);
            String window1 = driver.getWindowHandle();//  получаем дескрпитор окна
            System.out.println(window1);
            js.executeScript("window.open()"); //  коанда открытия новой вкладки
            Set<String> currentWindows = driver.getWindowHandles(); // получаем дескрипторы всех окон
            String window2 = null; // инициализируем переменную window2 как null.
            for (String window : currentWindows) {
                if (!window.equals(window1)) { // если window не равен window1
                   window2 = window; // то в window2 записывыаем актуальный для него дескрпитор
                   break;
                }
        };
            driver.switchTo().window(window2); // переключение на новую вкладку с новым url
            driver.get("https://mail.ru/");
            driver.close();// закрытие текущую влкдаки
            driver.switchTo().window(window1); // переход на предыдущую вкладку.

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
        }


    }
}
