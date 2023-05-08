package Test2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

    public class AutoTest {

        public static void main(String[] args) throws InterruptedException, IOException {

            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            //zalogowanie się
            ChromeDriver driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            driver.manage().window().maximize();
            driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");

            WebElement emailInput = driver.findElement(By.id("field-email"));
            emailInput.clear();
            emailInput.sendKeys("wvaaciquzqweadaorl@bbitf.com");


            WebElement passwordInput = driver.findElement(By.id("field-password"));
            passwordInput.clear();
            passwordInput.sendKeys("katana");


            WebElement signInButton = driver.findElement(By.id("submit-login"));
            signInButton.click();
            //wybierze do zakupu Hummingbird Printed Sweater
            driver.findElement(By.id("category-3")).click();
            driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/div[2]/article/div/div[1]/a")).click();

            //wybierze rozmiar M
            new Select(driver.findElement(By.id("group_1"))).selectByVisibleText("M");
            // sleep(500);
            new Select(driver.findElement(By.id("group_1"))).selectByVisibleText("S");
            //wybierze 5 sztuk według parametru podanego w teście
            WebElement quantityWanted = driver.findElement(By.id("quantity_wanted"));
            quantityWanted.clear();
            quantityWanted.sendKeys(Keys.BACK_SPACE);
            quantityWanted.sendKeys("5");
            //dodaj produkt do koszyka,
            driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")).click();

            //przejdzie do opcji - checkout
            driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")).click();
            driver.findElement(By.cssSelector(".btn.btn-primary")).click();

            //potwierdzi address (możesz go dodać wcześniej ręcznie),
            driver.findElement(By.xpath("//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button")).click();

            //wybierze metodę odbioru - PrestaShop "pick up in store",
            //    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            driver.findElement(By.name("confirmDeliveryOption")).click();

            //wybierze opcję płatności - Pay by Check,
            driver.findElement(By.name("payment-option")).click();
            driver.findElement(By.id("conditions_to_approve[terms-and-conditions]")).click();
            //kliknie na "order with an obligation to pay",
            driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button")).click();

            //zrobi screenshot z potwierdzeniem zamówienia i kwotą (cała strona)
            Date now = new Date();
            Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
            String screenfilename = "Fullpagescreenshot_" + now.getTime() + ".png";
            ImageIO.write(screenshot.getImage(), "PNG", new File(System.getProperty("user.dir") + "\\screenshots\\" + screenfilename));
            WebElement cena = driver.findElement(By.cssSelector("#content-hook_payment_return > div > div > div > ul > li:nth-child(1) > span > strong"));
            cena.getText();


            //Wejdź w historię zamówień i detale (najpierw kliknij w użytkownika zalogowanego, później kafelek),
            driver.findElement(By.cssSelector("#_desktop_user_info > div > a.account > span")).click();
            driver.findElement(By.id("history-link")).click();

            //sprawdź czy zamówienie znajduje się na liście ze statusem "Awaiting check payment" i kwotą taką samą jak na zamówieniu dwa kroki wcześniej.
            WebElement tekst = driver.findElement(By.cssSelector("#content > table > tbody > tr:nth-child(1) > td:nth-child(5) > span"));
            tekst.getText();
            WebElement cena2 = driver.findElement(By.cssSelector("#content > table > tbody > tr:nth-child(1) > td.text-xs-right"));
            if (tekst.equals("Awaiting Check payment") && cena == cena2 ) {
                System.out.println("Status i cena się zgadzają");
            }
            //zamknięcie przeglądarki
           driver.quit();
        }
    }








