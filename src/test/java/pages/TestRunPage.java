package pages;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

public class TestRunPage {
    private final SelenideElement testRunButton = $("#navigation-runs-dropdown");
    private final SelenideElement resultRun = $x("//div[@class='content-header-title page_title']");
    private final SelenideElement addTestRunButton = $("[data-testid=\"navigationRunsAdd\"]");
    private final SelenideElement checkOpenTestRun = $("[data-testid=\"testCaseContentHeaderTitle\"]");
    private final SelenideElement inputNameRun = $("[data-testid=\"addRunFormName\"]");
    private final SelenideElement saveButton = $("[data-testid=\"addRunFormOkButton\"]");
    private final SelenideElement createdTestRunTitle = $("[data-testid='testCaseContentHeaderTitle']");

    public void openTestRun() {
        testRunButton.click();
    }
    public void textTestRun() {
        resultRun.shouldBe(visible);
        resultRun.shouldHave(text("Test Runs & Results"));
    }
    public void addTestRun() {
        addTestRunButton.click();
    }
    public void shouldOpenTestRun() {
        checkOpenTestRun.shouldBe(visible);
        checkOpenTestRun.shouldHave(text("Add Test Run"));
    }
    public void nameTestRun(String name) {
        inputNameRun.shouldBe(editable).click();
        inputNameRun.setValue(name);
        inputNameRun.shouldHave(value(name));
    }
    public void saveTestRun() {
        saveButton.click();
    }
    public void checkCreatedTestRun(String runName) {
        createdTestRunTitle.shouldBe(visible);
        createdTestRunTitle.shouldHave(text(runName));
    }
}
