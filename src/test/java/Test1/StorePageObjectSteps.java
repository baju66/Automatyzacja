package pl.zadanie1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StorePageObjectSteps {

    private WebDriver driver;

    @Given("Jestem zalogowany jako użytkownik")
    public void jestem_Zalogowany_Jako_Uzytkownik() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
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
    }

    @When("Klikam w kafelek Addresses")
    public void klikam_W_Kafelek_Addresses() {
        // implementacja kroku, który klika w kafelek "Addresses"
        driver.findElement(By.id("addresses-link")).click();
    }

    @And("Klikam w przycisk + Create new address")
    public void klikam_W_Przycisk_Create_New_Address() {
        // implementacja kroku, który klika w przycisk "Create new address"
        driver.findElement(By.cssSelector("a[data-link-action='add-address']")).click();
    }

    @And("Wypełniam formularz New address danymi alias {string} address {string} city {string} country {string} zipPostalCode {string} phone {string}")
    public void wypelniamFormularzNewAddressDanymiAliasAddressCityCountryZipPostalCodePhone(String alias, String address, String city, String country, String zipPostalCode, String phone) {
        WebElement aliasInput = driver.findElement(By.id("field-alias"));
        aliasInput.clear();
        aliasInput.sendKeys(alias);
        WebElement addressInput = driver.findElement(By.id("field-address1"));
        addressInput.clear();
        addressInput.sendKeys(address);
        WebElement cityInput = driver.findElement(By.id("field-city"));
        cityInput.clear();
        cityInput.sendKeys(city);
        WebElement postcodeInput = driver.findElement(By.id("field-postcode"));
        postcodeInput.clear();
        postcodeInput.sendKeys(zipPostalCode);
        new Select(driver.findElement(By.id("field-id_country"))).selectByVisibleText("United Kingdom");
        WebElement phoneInput = driver.findElement(By.id("field-phone"));
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    @And("Klikam przycisk Save")
    public void klikam_Przycisk_Save() {
        driver.findElement(By.cssSelector(".btn.btn-primary.form-control-submit.float-xs-right")).click();
    }

    @Then("Sprawdzam, czy dodany adres zawiera poprawne dane alias {string} address {string} city {string} country {string} zipPostalCode {string} phone {string}")
    public void sprawdzam_czy_dodany_adres_zawiera_poprawne_dane_alias(String alias, String address, String city, String country, String zipPostalCode, String phone) {

        WebElement address1 = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[2]/article/div[1]"));
        String adressText1 = address1.getText();
        String adres1 = alias + "\n" + "Tomasz Bajek\n" + address + "\n" + city + "\n" + zipPostalCode + "\n" + country + "\n" + phone;
        assertEquals(adressText1, adres1);
        System.out.println("Potwierdzam zgodność danych adresowych");
    }
//  usunie powyższy adres klikając w "delete",

    @And("usunie powyższy adres klikając w delete")
    public void usuniePowyższyAdresKlikającWDelete() {
       WebElement deleteButton = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[2]/article/div[2]/a[2]/span"));
       deleteButton.click();
    }

    @Then("sprawdzi czy adres został usunięty.")
    public void sprawdziCzyAdresZostałUsunięty() {
        List<WebElement> adres = driver.findElements(By.xpath("/html/body/main/section/div/div/section/section/div[2]/article/div[1]"));
        if (adres.size() == 0) {
            System.out.println("Adres nie istnieje już na stronie.");

        }
    }


        @And("Zamykam przeglądarkę")
        public void zamykamPrzeglądarkę() {
            driver.quit();
        }

    }


