package tests;

import base.BaseTest;
import config.TestConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProfileTest extends BaseTest {
    @Test
    @DisplayName("UI-07 Переход в настройки профиля")
    void settingProfile() {
        loginPage.login(TestConfig.LOGIN, TestConfig.PASSWORD);
        dashboardPage.openPageDashboard();
        dashboardPage.shouldBeOpened();
        profilePage.openDropMenu();
        profilePage.settingMenu();
        profilePage.checkMySettings();

    }
}
