import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebTest {
    private static ChromeDriver driverChrome;
    private  static FirefoxDriver driverFireFox;
    @BeforeClass
    public  void beforeAll(){
        System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
        driverChrome = new ChromeDriver();
        System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_PATH);
        driverFireFox = new FirefoxDriver();
    }

    @Test
    public void test01(){
        //#1
        driverChrome.get("https://www.walla.co.il");
        driverFireFox.get("https://www.ynet.co.il");
        //#2
        driverChrome.navigate().to("https://translate.google.com");
        System.out.println(driverChrome.findElement(By.tagName("textarea")));
        System.out.println(driverChrome.findElement(By.className("QFw9Te")));
//
        //#3
        driverFireFox.navigate().to("https://www.youtube.com");
        System.out.println(driverFireFox.findElement(By.id("img")));

        //#4
        driverFireFox.navigate().to("https://www.selenium.dev");
        WebElement buttonElement = driverFireFox.findElement(By.className("DocSearch-Button-Placeholder"));
        System.out.println(buttonElement);
        buttonElement.click();
        WebElement searchElement = driverFireFox.findElement(By.className("DocSearch-Input"));
        System.out.println(searchElement);
        searchElement.sendKeys("selenium");

        //#5
        driverChrome.navigate().to("https://www.amazon.com");
        WebElement buttonElement5 = driverChrome.findElement(By.id("twotabsearchtextbox"));
        System.out.println(buttonElement5);
        buttonElement5.click();
        buttonElement5.sendKeys("“Leather shoes”.");
        //#6

        driverChrome.get("https://translate.google.com");
        driverChrome.findElement(By.tagName("textarea")).sendKeys("שלום");

        //#7
        driverChrome.navigate().to("https://www.youtube.com");
        driverChrome.findElement(By.id("search")).sendKeys("Blessed");
        driverChrome.findElement(By.id("search-icon-legacy")).click();


    }

    @AfterClass
    public void afterAll(){
        driverChrome.quit();
        driverFireFox.quit();
    }



}