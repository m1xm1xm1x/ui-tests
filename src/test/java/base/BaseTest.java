package base;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import config.TestConfig;
import pages.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected TestCasesPage testCasesPage;
    protected ProfilePage profilePage;
    protected TestRunPage testRunPage;
@BeforeEach
    public void setUp() {
        open(TestConfig.BASE_URL);
        loginPage = new LoginPage();
        loginPage.shouldBeOpened();
        dashboardPage = new DashboardPage();
        testCasesPage = new TestCasesPage();
        profilePage = new ProfilePage();
        testRunPage = new TestRunPage();

    }
@AfterEach
    public void tearDown() {
    closeWebDriver();
    }
}
