import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);// задаём не явное ожидание(первый вариант)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// задаём не явное ожидание(второй вариант)
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10))//создание нового элемента, присвоение к нему нового экземеляра класса и выставление значение в 10 сек
                .until(ExpectedConditions.presenceOfElementLocated(By.id("123")))); //until - метод для обозначение явного ожидаения. ExpectedConditions - ожидаю условия.
                                                                                    // presenceOfElementLocated пока не появится элемент, который находится в скобках в виде локатора.
        driver.get("https://www.youtube.com/");
    }
}

