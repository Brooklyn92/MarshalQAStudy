import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class ActionsTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        try {
            driver.get("https://crossbrowsertesting.github.io/drag-and-drop.html");
            Thread.sleep(2000);
            WebElement element = driver.findElement(By.id("draggable"));
            WebElement element2 = driver.findElement(By.id("droppable"));
            Actions actions = new Actions(driver);
            //actions.dragAndDropBy(); // перемещение элементов по координатам по х и у
            actions.dragAndDrop(element,element2).perform();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                Thread.sleep(2000);
                driver.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            /* ============Пример drag-and-drop (пошагово)=============
            actions
                    .moveToElement(element)
                    .clickAndHold()
                    .moveToElement(element2)
                    .release()
                    .build()
                    .perform();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                Thread.sleep(2000);
                driver.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

             */

        /*
        actions.contextClick(); // клик правой кнопкой мыши
        actions.clickAndHold(); // нажать лкм и зажать кнопку
        actions
                .moveToElement() // навести курсор на элемент
                .keyDown() // нажать на лкм
                .keyUp()  // отжать лкм от элемента
                .clickAndHold() /// нажать лкм и зажать кнопку
                .release() // отжать лкм
                .build() // собрать
                .perform(); // применить
         */
    }
}
