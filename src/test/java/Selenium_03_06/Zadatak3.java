package Selenium_03_06;

//Otici na Google
////Zatim ukucati "Wikipedia" u polje za pretragu
////Odraditi pretragu i otvoriti stranicu
////Na stranici Wikipedia pretraziti "Nikola Tesla"

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver ();
        WebDriver driver = new ChromeDriver ();

        driver.manage ().window ().maximize ();

        driver.navigate ().to ("https://www.google.com/");

        WebElement searchbox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea"));
        searchbox.sendKeys("Wikipedia");

        WebElement searchButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"));
        searchButton.submit ();

        WebElement wikipedia = driver.findElement(By.xpath("/html/body/div[6]/div/div[11]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div[1]/a/h3"));
        wikipedia.click();

        WebElement wikipediaSearch = driver.findElement(By.xpath("/html/body/div[3]/form/fieldset/div/input"));
        wikipediaSearch.sendKeys("Nikola Tesla");

        WebElement wikipediaButton = driver.findElement(By.xpath("/html/body/div[3]/form/fieldset/button/i"));
        wikipediaButton.click();
    }
}
