# UI Test Automation

Проект автоматизированного UI-тестирования TestRail.

## Технологии

- Java 17
- Gradle
- JUnit 5
- Selenide
- Chrome

## Настройка

Для запуска тестов необходимо задать переменные окружения:

- `testRailUrl` — URL TestRail
- `testRailLogin` — логин пользователя
- `testRailPassword` — пароль пользователя

Пример для PowerShell:

```powershell
$env:testRailUrl = "https://your-instance.testrail.io/index.php?/dashboard"
$env:testRailLogin = "your-login"
$env:testRailPassword = "your-password"

```
## Запуск тестов

Запуск всех тестов:

```powershell
.\gradlew.bat clean test --no-daemon
```

Запуск одного теста:

```powershell
.\gradlew.bat test --tests "tests.LoginTest.successfulLoginTest" --no-daemon
```
## UI-тесты

| ID | Сценарий | Класс | Метод |
|---|---|---|---|
| UI-01 | Успешная авторизация и переход на Dashboard | LoginTest | successfulLoginTest |
| UI-02 | Авторизация с пустым полем пароля | LoginTest | loginWithEmptyPassword |
| UI-03 | Авторизация с пустым полем email | LoginTest | loginWithEmptyEmail |
| UI-04 | Авторизация с неверным паролем | LoginTest | loginWrongPassword |
| UI-05 | Создание Test Case | TestCasesTest | addTestCase |
| UI-06 | Удаление Test Case | TestCasesTest | deleteTestCase |
| UI-07 | Переход в настройки профиля | ProfileTest | settingProfile |
| UI-08 | Переход во вкладку Test Cases | TestCasesTest | goTestCases |
| UI-09 | Переход во вкладку Test Runs & Results | TestRunTest | checkTestRuns |
| UI-10 | Создание Test Run | TestRunTest | addTestRun |

## Отчёты

После запуска тестов Gradle HTML-отчёт находится в:

`build/reports/tests/test/index.html`

При падении UI-теста Selenide сохраняет screenshot и page source в:

`build/reports/tests/`

## Known limitations

Функциональность Search в используемом TestRail окружении возвращает `Unexpected Error` при ручной проверке.

Поэтому сценарий Search не включён в набор автоматизированных тестов. Ошибка приложения не используется как ожидаемый результат автотеста.