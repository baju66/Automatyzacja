# PRZYPADKI TESTOWE
## TEST 1
**Przypadek testowy: Dodawanie nowego adresu**

Opis:
Test sprawdza poprawność dodawania nowego adresu przez zalogowanego użytkownika.

Kroki:

* Użytkownik jest zalogowany
* Użytkownik klika w kafelek "Addresses".
* Użytkownik klika w przycisk "+ Create new address".
* Użytkownik wypełnia formularz "New address" danymi:

  * alias:
  
  * address: 

  * city:

  * country:

  * zipPostalCode

  * phone
  
* Użytkownik klika przycisk "Save".
* Sprawdza, czy dodany adres zawiera poprawne dane:
* Użytkownik usuwa powyższy adres, klikając w przycisk "Delete".
* Sprawdza, czy adres został usunięty.
  
**Oczekiwany rezultat: Adres zostaje dodany poprawnie i zawiera podane dane. Po usunięciu, adres zostaje usunięty.**

## TEST 2
**Przypadek testowy: Złożenie zamówienia i sprawdzenie statusu**

Opis:
Test sprawdza proces złożenia zamówienia na stronie internetowej oraz sprawdzenie poprawności statusu zamówienia.

Kroki:

* Otwórz przeglądarkę Chrome.
* Przejdź do strony logowania: "https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account".
* Wprowadź poprawny adres e-mail w polu "field-email".
* Wprowadź poprawne hasło w polu "field-password".
* Kliknij przycisk "Sign In" (Zaloguj się).
* Wybierz kategorię "Hummingbird Printed Sweater".
* Kliknij na wybrany produkt.
* Wybierz rozmiar "M" z rozwijanej listy.
* Wyczyść pole "quantity_wanted".
* Wprowadź wartość "5" do pola "quantity_wanted".
* Kliknij przycisk "Add to cart" (Dodaj do koszyka).
* Kliknij przycisk "Proceed to checkout" (Przejdź do kasy).
* Kliknij przycisk "Continue" (Kontynuuj) w sekcji "Addresses" (Adresy).
* Wybierz metodę odbioru "PrestaShop pick up in store".
* Wybierz metodę płatności "Pay by Check".
* Zaznacz zgodę na warunki.
* Kliknij przycisk "Order with an obligation to pay" (Zamów z obowiązkiem zapłaty).
* Pobierz dane o kwocie zamówienia.
* Kliknij na swoje konto użytkownika.
* Kliknij na link "Order history" (Historia zamówień).
* Sprawdź, czy zamówienie znajduje się na liście ze statusem "Awaiting check payment" (Oczekuje na zapłatę czekiem) z tą samą kwotą jak na zamówieniu.

**Oczekiwany rezultat:**

* Zamówienie zostaje poprawnie złożone.
* Zamówienie znajduje się na liście historii zamówień ze statusem "Awaiting check payment" (Oczekuje na zapłatę czekiem).
* Kwota zamówienia na liście historii zamówień jest taka sama jak na potwierdzeniu zamówienia.

## TEST 3
**Przypadek testowy: Wybranie losowej liczby produktów i sprawdzenie, czy cena końcowa się zgadza.**

Opis:
Test sprawdza, czy możliwe jest wybranie losowej liczby produktów, dodanie ich do koszyka, a następnie porównanie ostatecznej ceny z oczekiwaną wartością.

Kroki:

* Przejdź do strony sklepu: "https://skleptest.pl/".
* Dodaj różne produkty z różną ilością do koszyka
* Przejdź do koszyka klikając w przycisk "My Cart" w górnym lewym rogu strony
* Dla każdego produktu w koszyku:
* Sprawdź, czy wybrane produkty znajduje się na stronie z koszykiem
* Oblicz sumę za zamówioną ilość produktów
* Porównaj obliczoną sumę z ostateczną ceną.

**Oczekiwany rezultat:**

* Na stronie z koszykiem wybrana liczba produktów jest dodana do koszyka oraz ostateczna cena za zamówione produkty na stronie jest zgodna z obliczoną sumą cen.

## TEST 4
**Przypadek testowy: Zaznaczanie pierwszych odpowiedzi w teście i dotarcie do tablicy końcowej.**

Opis:
Test sprawdza, czy możliwe jest zaznaczenie pierwszych odpowiedzi przy wszystkich 12 pytaniach w teście, a następnie dotarcie do tablicy końcowej.

Kroki:

* Otwórz przeglądarkę Chrome.
* Przejdź do strony logowania: "https://pro-test.qa.m.goit.global/auth".
* Zaloguj się używając poprawnych danych:
* Wprowadź poprawny adres e-mail w polu "email".
* Wprowadź poprawne hasło w polu "password".
* Kliknij przycisk "Zaloguj się".
* Zmień język na polski:
  * Znajdź pole wyboru języka (element "language").
  * Kliknij na pole wyboru języka.
  * Wprowadź "PL" jako wartość języka.
* Wybierz kategorię "Teoria Testów".
* Kliknij na pierwszy test w kategorii.
* Zaznacz pierwszą odpowiedź przy każdym z 12 pytań.


**Oczekiwany rezultat:**

* Po zaznaczeniu odpowiedzi przy wszystkich pytaniach, test przechodzi do tablicy końcowej.



