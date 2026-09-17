package pages;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage {
    private final SelenideElement dashboardHeader = $("[data-testid=\"testCaseContentHeaderTitle\"]");
    private final SelenideElement practiceProject = $x("//a[text()='practice_ui' and @href='index.php?/projects/overview/1' and not(contains(@class,'dropdown-menu-link'))]");
    private final SelenideElement dashboardLink = $("[data-testid='bannerLink']");

    public void shouldBeOpened() {
        dashboardHeader.shouldBe(visible);
    }
    public void openPracticeProject() {
        practiceProject.click();
    }
    public void openPageDashboard() {
        dashboardLink.shouldBe(visible).click();
        dashboardHeader.shouldBe(visible);
    }
}




