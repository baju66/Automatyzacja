@zadanie1
Feature: Dodawanie nowego adresu

  Scenario: Dodawanie nowego adresu

    Given Jestem zalogowany jako użytkownik
    When Klikam w kafelek Addresses
    And Klikam w przycisk + Create new address
    And Wypełniam formularz New address danymi alias "<alias>" address "<address>" city "<city>" country "<country>" zipPostalCode "<zipPostalCode>" phone "<phone>"
    And Klikam przycisk Save
    Then Sprawdzam, czy dodany adres zawiera poprawne dane alias "<alias>" address "<address>" city "<city>" country "<country>" zipPostalCode "<zipPostalCode>" phone "<phone>"
    And usunie powyższy adres klikając w delete
    Then sprawdzi czy adres został usunięty.
    And Zamykam przeglądarkę

    Examples:
      | alias  | address         | city     | country        | zipPostalCode | phone           |
      | adres1 | ul. Testowa 1/2 | Warszawa | United Kingdom | 00-001        | +48 123 456 789 |
      | adres2 | ul. Dluga 5/6   | Krakow   | United Kingdom | 30-001        | +48 987 654 321 |
      | adres3 | ul. Krotka 10/2 | Wroclaw  | United Kingdom | 50-001        | +48 555 555 555 |