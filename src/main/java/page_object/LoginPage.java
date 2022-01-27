package page_object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    WebDriver driver = new ChromeDriver();
    WebElement inputLogin = driver.findElement(By.id("login"));
    WebElement inputPassword = driver.findElement(By.id("password"));
    WebElement enter = driver.findElement(By.id("enter"));

    public  void login(String login, String password){
        inputLogin.sendKeys();
        inputPassword.sendKeys();
        enter.click();
    }

}
