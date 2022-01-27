import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class TabTest2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 1000);

        driver.get("https://yandex.ru/");
        driver.switchTo().newWindow(WindowType.TAB); // Открывает новую вкладку и переключается на новую вкладку
        //driver.switchTo().newWindow(WindowType.WINDOW); // Открывает новое окно и переключается в новое окно
        driver.get("https://mail.ru/");
        driver.close();
    }
}

