package Cetvrtak_08_06.Domaci4;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WithoutPassword {
    public static void main(String[] args) {
        WebDriverManager.chromedriver ().setup ();
        WebDriver driver = new ChromeDriver ();

        driver.manage ().window ().maximize ();

        driver.get ("https://the-internet.herokuapp.com/");

        String validUsername = "admin";

        WebElement basicAuthLink = driver.findElement (By.linkText ("Basic Auth"));
        basicAuthLink.click ();

        String urlForLogIn = "the-internet.herokuapp.com/basic_auth";

        driver.get ("https://"  + validUsername + "@" + urlForLogIn);

        String urlWhenLogedIn = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
        Assert.assertNotEquals (driver.getCurrentUrl (), urlWhenLogedIn);

        boolean message = false;
        try {
        message = driver.findElement (By.xpath ("//*[@id=\"content\"]/div/p")).isDisplayed ();

        } catch (Exception e) {

        }
        Assert.assertFalse (message);
    }
}