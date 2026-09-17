package tests;

import base.BaseTest;
import config.TestConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestRunTest extends BaseTest {
    @Test
    @DisplayName("UI-09 Переход во вкладку Test Runs & Results")
    void checkTestRuns() {
        loginPage.login(TestConfig.LOGIN, TestConfig.PASSWORD);
        dashboardPage.openPageDashboard();
        dashboardPage.shouldBeOpened();
        dashboardPage.openPracticeProject();
        testRunPage.openTestRun();
        testRunPage.textTestRun();
    }

    @Test
    @DisplayName("UI-10 Создание Test Run")
    void addTestRun() {
        loginPage.login(TestConfig.LOGIN, TestConfig.PASSWORD);
        dashboardPage.openPageDashboard();
        dashboardPage.shouldBeOpened();
        dashboardPage.openPracticeProject();
        testRunPage.openTestRun();
        testRunPage.textTestRun();
        testRunPage.addTestRun();
        testRunPage.shouldOpenTestRun();
        String runName = "Auto Test Run " + System.currentTimeMillis();
        testRunPage.nameTestRun(runName);
        testRunPage.saveTestRun();
        testRunPage.checkCreatedTestRun(runName);
    }
}
