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

alias:
  
address: 

city:

country:

zipPostalCode

phone
  
* Użytkownik klika przycisk "Save".
* Sprawdza, czy dodany adres zawiera poprawne dane:
* Użytkownik usuwa powyższy adres, klikając w przycisk "Delete".
* Sprawdza, czy adres został usunięty.
* Zamyka przeglądarkę.
  
**Oczekiwany rezultat: Adres zostaje dodany poprawnie i zawiera podane dane. Po usunięciu, adres zostaje usunięty.**
