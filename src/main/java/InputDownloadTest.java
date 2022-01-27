import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class InputDownloadTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://yandex.ru/images/?utm_source=main_stripe_big");
        WebElement download1 = driver.findElement(By.xpath("//input[@class='CbirCore-FileInput']"));
        download1.sendKeys("C:/Users/Aleksandr/Downloads/Telegram Desktop/22.jpg");
    }
}