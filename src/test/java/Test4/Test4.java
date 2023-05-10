package Test4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

// Sprawdzenie czy można zaznaczyć pierwsze odpowiedzi i dojść do tablicy końcowej.
public class Test4 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        // wejście do sklepu
        driver.get("https://pro-test.qa.m.goit.global/auth");
        //    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
        // logowanie poprawnymi danymi
        WebElement email = driver.findElement(By.name("email"));
        email.clear();
        email.sendKeys("zwsfthyjeyvszmbgrn@tcwlx.com");
        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("katana1234");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/main/div/div/div/div[2]/form/div/button[1]")).click();
        Thread.sleep(2000);
        // zamiana języka na polski
        WebElement language = driver.findElement(By.id("react-select-3-input"));
        language.click();
        Thread.sleep(2000);
        language.sendKeys("PL");
        Thread.sleep(2000);
        language.sendKeys(Keys.ENTER);
       // Wybranie kategorii "Teoria Testów" i Zaznaczanie pierwszych odpowiedzi przy wszystkich 12 pytaniach.
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/main/div/div/section[2]/a[1]")).click();
        Thread.sleep(2000);
        WebElement answer1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/main/div/div/div/div/section/div[1]/label"));
        for (int i = 1; i <= 12; i++) {
            answer1.click();
        }
        Thread.sleep(2000);
        // zamknięcie przeglądarki
        driver.quit();

    }
}
