package page_object;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void signIn(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("admin", "admin");
    }
}
