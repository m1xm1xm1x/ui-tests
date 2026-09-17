package tests;
import org.junit.jupiter.api.DisplayName;
import config.TestConfig;
import org.junit.jupiter.api.Test;
import base.BaseTest;

public class TestCasesTest extends BaseTest {
    @Test
    @DisplayName("UI-05 Создание Test Case")
    void addTestCase() {
        loginPage.login(TestConfig.LOGIN, TestConfig.PASSWORD);
        dashboardPage.openPageDashboard();
        dashboardPage.shouldBeOpened();
        dashboardPage.openPracticeProject();
        testCasesPage.openTestCases();
        testCasesPage.addCase();
        String caseTitle = "Auto test " + System.currentTimeMillis();
        testCasesPage.nameTitle(caseTitle);
        testCasesPage.saveTestCase();
        testCasesPage.check(caseTitle);
    }

    @Test
    @DisplayName("UI-06 Удаление Test Case")
    void deleteTestCase() {
        loginPage.login(TestConfig.LOGIN, TestConfig.PASSWORD);
        dashboardPage.openPageDashboard();
        dashboardPage.shouldBeOpened();
        dashboardPage.openPracticeProject();
        testCasesPage.openTestCases();
        testCasesPage.addCase();
        String caseTitle = "Auto delete " + System.currentTimeMillis();
        testCasesPage.nameTitle(caseTitle);
        testCasesPage.saveTestCase();
        testCasesPage.check(caseTitle);
        testCasesPage.navigateTest();
        testCasesPage.deleteButton(caseTitle);
        testCasesPage.endDelete();
        testCasesPage.confirmPermDelete();
        testCasesPage.checkCaseDeleted(caseTitle);
    }

    @Test
    @DisplayName("UI-08 Переход во вкладку Test Cases")
    void goTestCases(){
        loginPage.login(TestConfig.LOGIN, TestConfig.PASSWORD);
        dashboardPage.openPageDashboard();
        dashboardPage.shouldBeOpened();
        dashboardPage.openPracticeProject();
        testCasesPage.openTestCases();
        testCasesPage.check("Test Cases");
    }
}
