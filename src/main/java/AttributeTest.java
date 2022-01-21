import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AttributeTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.avito.ru/ulyanovsk/avtomobili/");
        WebElement element = driver.findElement(By.xpath("(//a[@title='Ford'])[1]"));
        String par = element.getAttribute("innerText");
        System.out.println(par);
        driver.close();
    }
}
