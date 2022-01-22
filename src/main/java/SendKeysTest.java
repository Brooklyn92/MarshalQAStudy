import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeysTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.avito.ru/ulyanovsk/odezhda_obuv_aksessuary?cd=1");
        WebElement text = driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']"));
        text.sendKeys("Java", Keys.ENTER);
        driver.close();
    }
}
