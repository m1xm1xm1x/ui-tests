package tests;
import org.junit.jupiter.api.DisplayName;
import config.TestConfig;
import org.junit.jupiter.api.Test;
import base.BaseTest;

public class LoginTest extends BaseTest {
    @Test
    @DisplayName("UI-01 Успешная авторизация и переход на Dashboard")
    void successfulLoginTest() {
        loginPage.login(TestConfig.LOGIN, TestConfig.PASSWORD);
        dashboardPage.openPageDashboard();
        dashboardPage.shouldBeOpened();
    }

    @Test
    @DisplayName("UI-02 Авторизация с пустым полем паролем")
    void loginWithEmptyPassword() {
        loginPage.login(TestConfig.LOGIN, "");
        loginPage.checkPasswordError();
    }

    @Test
    @DisplayName("UI-03 Авторизация с пустым полем email")
    void loginWithEmptyEmail() {
        loginPage.login("", TestConfig.PASSWORD);
        loginPage.checkEmailError();
    }

    @Test
    @DisplayName("UI-04 Авторизация с неверным паролем")
    void loginWrongPassword() {
        loginPage.login(TestConfig.LOGIN,"WROngPasswprsd");
        loginPage.checkErrorAuth();
    }
}