package Test3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Random;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;

public class Test3 {

// Wybranie losowej liczby 4 produktów i sprawdzenie czy zgadza się cena na końcu (bez pętli)
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
    // wejście do sklepu

        driver.get("https://skleptest.pl/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
    // wpisanie T-shirt

        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"search-field-top-bar\"]"));
        searchBar.sendKeys("T-shirt");
        searchBar.submit();

    // wybranie 3 produktów o losowej ilości i dodanie do koszyka

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

        // początek kodu do skopiowania
        // 2 produkt
        driver.findElement(By.xpath("//*[@id=\"product-43\"]/section/ul/li[1]/a[1]/img")).click();
        int quantityValue2 = rand.nextInt(100) + 1; // generates a random number between 1 and 100 (inclusive)
        String quantityString2 = Integer.toString(quantityValue2); // convert the number to a string */
        quantity = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[2]/form/div/div/input"));
        quantity.clear();
        quantity.sendKeys(quantityString2);
        add2Cart = driver.findElement(By.name("add-to-cart"));
        add2Cart.click();
        // koniec kodu do skopiowania

        // 3 produkt
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/section/ul/li[1]/a[1]/img")).click();
        int quantityValue3 = rand.nextInt(100) + 1; // generates a random number between 1 and 100 (inclusive)
        String quantityString3 = Integer.toString(quantityValue3); // convert the number to a string */
        quantity = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[2]/form/div/div/input"));
        quantity.clear();
        quantity.sendKeys(quantityString3);
        add2Cart = driver.findElement(By.name("add-to-cart"));
        add2Cart.click();

        // 4 produkt
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/section/ul/li[1]/a[1]/img")).click();
        int quantityValue4 = rand.nextInt(100) + 1; // generates a random number between 1 and 100 (inclusive)
        String quantityString4 = Integer.toString(quantityValue4); // convert the number to a string */
        quantity = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[2]/form/div/div/input"));
        quantity.clear();
        quantity.sendKeys(quantityString4);
        add2Cart = driver.findElement(By.name("add-to-cart"));
        add2Cart.click();

    //  przejście do koszyka i sprawdzenie czy ilość zamówionych rzeczy zgadza się z ceną ostateczną
        Thread.sleep(1000);
        driver.findElement(By.className("top-cart")).click();

    //  sprawdzenie czy ilość zamówionych rzeczy z pierwszej listy zgadza się z ceną ostateczną
        try {
            driver.findElement(By.cssSelector("span.woocommerce-Price-amount.amount"));
        } catch (NoSuchElementException e) {
            System.out.println("Nie znaleziono elementu na stronie");
            return; // przerwanie działania metody
        }
        WebElement cena = driver.findElement(By.cssSelector("span.woocommerce-Price-amount.amount"));
        WebElement liczba = driver.findElement(By.cssSelector("input[type='number'][name='cart[17e62166fc8586dfa4d1bc0e1742c08b][qty]']"));
        double cenaDouble = 0;
        int liczbaInt = 0;

        String cena_1 = cena.getText().replaceAll("[^0-9]", "");
        cenaDouble = Double.parseDouble(cena_1);
        System.out.println("tu powinna być cena " + cenaDouble);

        String liczba_1 = liczba.getAttribute("value");
        liczbaInt = Integer.parseInt(liczba_1);
        System.out.println("tu powinna być ilość produktu " + liczbaInt);

        double suma = cenaDouble * liczbaInt;
        System.out.println("Suma wynosi: " + suma);

        WebElement sumaElement = driver.findElement(By.xpath("//*[@id=\"post-6\"]/div[2]/form/table/tbody/tr[1]/td[6]/span"));
        String sumaString = sumaElement.getText().replaceAll("[^0-9]", "");
        double sumaDouble = Double.parseDouble(sumaString);

        if (suma == sumaDouble) {
            System.out.println("Cena ostateczna się zgadza");
        } else {
            System.out.println("Cena ostateczna nie się zgadza");
        }

    //  sprawdzenie czy ilość zamówionych rzeczy z drugiej  listy zgadza się z ceną ostateczną
        try {
            driver.findElement(By.xpath("//*[@id=\"post-6\"]/div[2]/form/table/tbody/tr[2]/td[4]/span"));
        } catch (NoSuchElementException e) {
            System.out.println("Nie znaleziono elementu na stronie");
            return; // przerwanie działania metody
        }
        WebElement cena2 = driver.findElement(By.xpath("//*[@id=\"post-6\"]/div[2]/form/table/tbody/tr[2]/td[4]/span"));
        WebElement liczba2 = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/main/article/div[2]/form/table/tbody/tr[2]/td[5]/div/div/input"));
        double cenaDouble1 = 0;
        int liczbaInt1 = 0;

        String cena_3 = cena2.getText().replaceAll("[^0-9]", "");
        cenaDouble1 = Double.parseDouble(cena_3);
        System.out.println("tu powinna być cena " + cenaDouble1);

        String liczba_3 = liczba2.getAttribute("value");
        liczbaInt1 = Integer.parseInt(liczba_3);
        System.out.println("tu powinna być ilość produktu " + liczbaInt1);

        double suma1 = cenaDouble1 * liczbaInt1;
        System.out.println("Suma wynosi: " + suma1);

        WebElement sumaElement1 = driver.findElement(By.xpath("//*[@id=\"post-6\"]/div[2]/form/table/tbody/tr[2]/td[6]/span"));
        String sumaString1 = sumaElement1.getText().replaceAll("[^0-9]", "");
        double sumaDouble1 = Double.parseDouble(sumaString1);

        if (suma1 == sumaDouble1) {
            System.out.println("Cena ostateczna się zgadza");
        } else {
            System.out.println("Cena ostateczna nie się zgadza");
        }

    //  sprawdzenie czy ilość zamówionych rzeczy z trzeciej  listy zgadza się z ceną ostateczną
        try {
        driver.findElement(By.xpath("//*[@id=\"post-6\"]/div[2]/form/table/tbody/tr[3]/td[4]/span"));
        } catch (NoSuchElementException e) {
            System.out.println("Nie znaleziono elementu na stronie");
        }
        WebElement cena3 = driver.findElement(By.xpath("//*[@id=\"post-6\"]/div[2]/form/table/tbody/tr[3]/td[4]/span"));
        WebElement liczba3 = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/main/article/div[2]/form/table/tbody/tr[3]/td[5]/div/div/input"));
        double cenaDouble2 = 0;
        int liczbaInt2 = 0;

        String cena_4 = cena3.getText().replaceAll("[^0-9]", "");
        cenaDouble2 = Double.parseDouble(cena_4);
        System.out.println("tu powinna być cena " + cenaDouble2);

        String liczba_4 = liczba3.getAttribute("value");
        liczbaInt2 = Integer.parseInt(liczba_4);
        System.out.println("tu powinna być ilość produktu " + liczbaInt2);

        double suma2 = cenaDouble2 * liczbaInt2;
        System.out.println("Suma wynosi: " + suma2);

        WebElement sumaElement2 = driver.findElement(By.xpath("//*[@id=\"post-6\"]/div[2]/form/table/tbody/tr[3]/td[6]/span"));
        String sumaString2 = sumaElement2.getText().replaceAll("[^0-9]", "");
        double sumaDouble2 = Double.parseDouble(sumaString2);

        if (suma2 == sumaDouble2) {
            System.out.println("Cena ostateczna się zgadza");
        } else {
            System.out.println("Cena ostateczna nie się zgadza");
        }
    //  sprawdzenie czy ilość zamówionych rzeczy z czwartej  listy zgadza się z ceną ostateczną
        try {
            driver.findElement(By.xpath("//*[@id=\"post-6\"]/div[2]/form/table/tbody/tr[4]/td[4]/span"));
        } catch (NoSuchElementException e) {
            System.out.println("Nie znaleziono elementu na stronie");
            return; // przerwanie działania metody
        }
        WebElement cena4 = driver.findElement(By.xpath("//*[@id=\"post-6\"]/div[2]/form/table/tbody/tr[4]/td[4]/span"));
        WebElement liczba4 = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/main/article/div[2]/form/table/tbody/tr[4]/td[5]/div/div/input"));
        double cenaDouble3 = 0;
        int liczbaInt3 = 0;

        String cena_5 = cena4.getText().replaceAll("[^0-9]", "");
        cenaDouble3 = Double.parseDouble(cena_5);
        System.out.println("tu powinna być cena " + cenaDouble3);

        String liczba_5 = liczba4.getAttribute("value");
        liczbaInt3 = Integer.parseInt(liczba_5);
        System.out.println("tu powinna być ilość produktu " + liczbaInt3);

        double suma3 = cenaDouble3 * liczbaInt3;
        System.out.println("Suma wynosi: " + suma3);

        WebElement sumaElement3 = driver.findElement(By.xpath("//*[@id=\"post-6\"]/div[2]/form/table/tbody/tr[4]/td[6]/span"));
        String sumaString3 = sumaElement3.getText().replaceAll("[^0-9]", "");
        double sumaDouble3 = Double.parseDouble(sumaString3);

        if (suma3 == sumaDouble3) {
            System.out.println("Cena ostateczna się zgadza");
        } else {
            System.out.println("Cena ostateczna nie się zgadza");
        }
    //  zamknięcie przeglądarki
        driver.quit();

    }
}
