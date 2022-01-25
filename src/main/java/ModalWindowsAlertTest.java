import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class ModalWindowsAlertTest {
    @Test
    public void alertTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver,1000);

        try {
            driver.get("");
            Thread.sleep(5000);

            WebElement element = driver.findElement(By.id("a"));
            WebElement element2 = driver.findElement(By.id("b"));
            WebElement element3 =  driver.findElement(By.id("c"));
            element.click();

            Alert alert = wait.until(alertIsPresent()); // ожидаем пока модальное окно появится
            alert.accept(); // нажатие на кнопку ОК в модальном окне

            element2.click();
            Alert prompt = wait.until(alertIsPresent()); // ожидаем пока модальное окно появится

            prompt.sendKeys("super"); // вписываем текст в модальное окно
            prompt.accept(); // нажатие на кнопку ОК в модальном окне
            Alert alert2 = wait.until(alertIsPresent()); // ожидаем модальное окно после нажатия кнопки ОК
            Thread.sleep(2000); // пауза в выполнение 2 сек
            alert2.accept(); // нажатие на кнопку ОК в модальном окне

            element3.click();
            Alert alert3 = wait.until(alertIsPresent());
            alert.dismiss(); // нажатие на кнопку Отмена в модальном окне

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }


    }
}
