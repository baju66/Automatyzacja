package Test31;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Random;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;

public class Test31 {

    // Wybranie losowej liczby X produktów i sprawdzenie czy zgadza się cena na końcu (zastosowano pętlę)
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

    //  wejście do sklepu

        driver.get("https://skleptest.pl/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
        // wpisanie T-shirt

        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"search-field-top-bar\"]"));
        searchBar.sendKeys("T-shirt");
        searchBar.submit();

    //  wybranie 4 produktów o losowej ilości i dodanie do koszyka

        // pierwszy produkt
        driver.findElement(By.xpath("//*[@id=\"post-43\"]/header/div/div[2]/h2/a")).click();
        WebElement quantity = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[2]/form/div/div/input"));
        quantity.clear();
        Random rand = new Random();
        int quantityValue = rand.nextInt(100) + 1; // generates a random number between 1 and 100 (inclusive)
        String quantityString = Integer.toString(quantityValue); // convert the number to a string
        quantity.sendKeys(quantityString);
        WebElement add2Cart = driver.findElement(By.name("add-to-cart"));
        add2Cart.click();

    //  Pętla dla dowolnej liczby produktów, zmienić trzeba wartość przy int numberOfProducts

        int numberOfProducts = 9;
        String[] quantityStrings = new String[numberOfProducts];
        int[] quantityValues = new int[numberOfProducts];

        for (int i = 0; i < numberOfProducts; i++) {
            // Kliknij w pierwszy obrazek produktu
            driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/section/ul/li[1]/a[1]/img")).click();

            // Wygeneruj losową ilość produktu i wpisz ją do pola ilości
            quantityValues[i] = rand.nextInt(100) + 1;
            quantityStrings[i] = Integer.toString(quantityValues[i]);
            WebElement quantitys = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[2]/form/div/div/input"));
            quantitys.clear();
            quantitys.sendKeys(quantityStrings[i]);

            // Kliknij w przycisk dodawania do koszyka i przejdź do strony koszyka
            WebElement add2Cartt = driver.findElement(By.name("add-to-cart"));
            add2Cartt.click();
        }
        Thread.sleep(1000);
        driver.findElement(By.className("top-cart")).click();

    //  sprawdzenie czy ilość zamówionych rzeczy z drugiej  listy zgadza się z ceną ostateczną

        for (int i = 0; i < numberOfProducts; i++) {
            try {
                driver.findElement(By.xpath("//*[@id=\"post-6\"]/div[2]/form/table/tbody/tr[" + (i + 2) + "]/td[4]/span"));
            } catch (NoSuchElementException e) {
                System.out.println("Nie znaleziono elementu na stronie");
                return; // przerwanie działania metody
            }

            WebElement cenaElement = driver.findElement(By.xpath("//*[@id=\"post-6\"]/div[2]/form/table/tbody/tr[" + (i + 2) + "]/td[4]/span"));
            WebElement liczbaElement = driver.findElement(By.xpath("//*[@id=\"post-6\"]/div[2]/form/table/tbody/tr[" + (i + 2) + "]/td[5]/div/div/input"));

            double cena = 0;
            int liczba = 0;

            String cenaString = cenaElement.getText().replaceAll("[^0-9]", "");
            cena = Double.parseDouble(cenaString);
            System.out.println("Cena produtku nr " + (i + 1) + " wynosi " + cena);

            String liczbaString = liczbaElement.getAttribute("value");
            liczba = Integer.parseInt(liczbaString);
            System.out.println("Ilość zamówionego produktu nr " + (i + 1) + " wynosi " + liczba);

            double suma = cena * liczba;
            System.out.println("Suma za " + liczba + " produktów nr " + (i + 1) + " w cenie " + cena + " zł za sztukę wynosi " + suma + " zł.");

            WebElement sumaElement = driver.findElement(By.xpath("//*[@id=\"post-6\"]/div[2]/form/table/tbody/tr[" + (i + 2) + "]/td[6]/span"));
            String sumaString = sumaElement.getText().replaceAll("[^0-9]", "");
            double sumaDouble = Double.parseDouble(sumaString);

            // Porównanie czy ilość pomnożona z ceną zgadza się z wyświetlaną na stronie sumą
            if (suma == sumaDouble) {
                System.out.println("Dla produktu " + (i + 1) + " cena ostateczna się zgadza");
            } else {
                System.out.println("Dla produktu " + (i + 1) + " cena ostateczna nie się zgadza");
            }
        }
    }
}
