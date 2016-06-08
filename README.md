## Opis projektu

Aplikacja ma za zadanie pobierać dane z ogłoszeń na portalu Otomoto oraz 
zapisywać je do pliku w postacji JSON. Aplikacja pobiera dane wielowątkowo, 
dla każdaj marki samochodu jest przydzielany osobny wątek.

## Opis parametrów konfiguracyjnych (application.yml)

|Nazwa parametru                   |Opis parametru                                                                  |
|----------------------------------|--------------------------------------------------------------------------------|
|otomoto.connection.requestMethod  |Metoda HTTP używana do połączenia z serwerem                                    |
|otomoto.connection.userAgent      |Nagłówek określający typ klienta łączącego się z serwerem                       |
|otomoto.connection.contentType    |Typ kontentu zwracanej strony                                                   |
|otomoto.connection.readTimeout    |Timeout dla odczytu danej strony                                                |
|otomoto.www.searchSiteTemplate    |Template strony wyszukiwania w postacji adresu URL                              |
|otomoto.search.pages.fromPageNo   |Wyszukiwanie ofert zaczynając od podanej strony                                 |
|otomoto.search.pages.toPageNo     |Wyszukiwanie ofert kończąc na danej stronie                                     |
|otomoto.search.vehicleMarks       |Marki samochodów uwzględnione przy wyszukiwaniu                                 |
|txt.output.file.path              |Ścieżka do pliku tekstowego w którym będą zapisywane wyniki działania aplikacji |

## Zrzuty ekranu

![alt text](https://github.com/DanielMichalski/otomoto-crawler/blob/master/src/main/resources/screens/1.png "Screen 1")

![alt text](https://github.com/DanielMichalski/otomoto-crawler/blob/master/src/main/resources/screens/2.png "Screen 2")