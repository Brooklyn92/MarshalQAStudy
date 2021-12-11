import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");// зависимости
        WebDriver browser=new ChromeDriver(); // создаём переменную webDriver которая будет манупулировать браузером Chrome
        browser.manage().window().maximize();// разворачиваем браузер на весь экран
        browser.get("https://mail.ru/"); // переходим на сайт
        WebElement input = browser.findElement(By.xpath("//input[@data-testid='search-input']"));//создаём переменную input и присваиваем и ищем элемент xpath
        input.click();
    }
}
