# Runners Thymeleaf Project

Ten projekt to aplikacja internetowa zaprojektowana do zarządzania i wyświetlania informacji o biegaczach. Wykorzystuje Spring Boot i Thymeleaf do tworzenia frontend, oferując solidny i przyjazny dla użytkownika interfejs.

## Funkcjonalności
- **Zarządzanie użytkownikami**: Rejestracja, logowanie i zarządzanie profilami użytkowników.
- **Profile biegaczy**: Tworzenie i zarządzanie szczegółowymi profilami biegaczy.
- **Zarządzanie wydarzeniami**: Dodawanie i zarządzanie wydarzeniami biegowymi.
- **Śledzenie wyników**: Rejestrowanie i wyświetlanie wyników z wydarzeń biegowych.
- **Responsywny design**: Interfejs użytkownika zoptymalizowany zarówno dla urządzeń stacjonarnych, jak i mobilnych.

## Wykorzystane technologie
- **Spring Boot**: Backendowy framework zapewniający solidną i skalowalną aplikację.
- **Thymeleaf**: Silnik szablonów do renderowania dynamicznej treści webowej.
- **Hibernate**: ORM do interakcji z bazą danych.
- **H2 Database**: Baza danych w pamięci do celów rozwojowych i testowych.
- **Bootstrap**: Framework frontendowy zapewniający responsywny design.
- **Java**: Główny język programowania używany w aplikacji.

## Struktura projektu

### Folder główny:
- **.gitignore**: Określa, które pliki powinny być ignorowane przez system kontroli wersji (Git).
- **README.md**: Prawdopodobnie zawiera dokumentację lub instrukcje dotyczące projektu.
- **build.gradle**: Główny skrypt Gradle, który definiuje zależności, zadania i wtyczki używane w projekcie.
- **gradle**, **gradlew**, **gradlew.bat**: Pliki związane z Gradle wrapper, umożliwiające budowanie projektu bez konieczności lokalnej instalacji Gradle.
- **settings.gradle**: Plik konfiguracyjny dla Gradle.

### Struktura katalogu `src/main`:
- **java/pl/bialek/runnersthymeleafproject**: Główny pakiet zawierający kod Java projektu.
    - **DTO**: Zawiera obiekty DTO (Data Transfer Objects), które są używane do przenoszenia danych pomiędzy różnymi warstwami aplikacji.
    - **RunnersThymeleafProjectApplication.java**: Główna klasa uruchamiająca aplikację Spring Boot.
    - **controllers**: Zawiera klasy kontrolerów odpowiedzialne za obsługę żądań HTTP i przekierowywanie ich do odpowiednich serwisów.
    - **entity**: Zawiera klasy encji, które reprezentują model danych lub tabele w bazie danych.
    - **mapper**: Prawdopodobnie zawiera klasy odpowiedzialne za mapowanie pomiędzy obiektami encji a DTO.
    - **repository**: Interfejsy rozszerzające `JpaRepository` lub podobne, służące do interakcji z bazą danych.
    - **security**: Pakiet prawdopodobnie odpowiada za zagadnienia związane z bezpieczeństwem, takie jak uwierzytelnianie i autoryzacja.
    - **service**: Zawiera klasy serwisów odpowiedzialne za logikę biznesową aplikacji.

### Struktura katalogu `src/main/resources`:
- Zwykle zawiera pliki konfiguracyjne, zasoby statyczne oraz szablony Thymeleaf do renderowania interfejsu użytkownika.

### Struktura katalogu `src/test`:
- Zawiera klasy testowe, odpowiedzialne za testowanie aplikacji.

## Użytkowanie

1. Sklonuj repozytorium:
   ```bash
   git clone <URL repozytorium>
