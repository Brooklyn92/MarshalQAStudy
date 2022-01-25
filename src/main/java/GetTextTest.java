import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.avito.ru/ulyanovsk/odezhda_obuv_aksessuary?cd=1");
        WebElement text = driver.findElement(By.xpath("//span[@data-marker='page-title/count']"));
        String count = text.getText();
        System.out.println(count);// 90 778
        driver.close();
    }
}
