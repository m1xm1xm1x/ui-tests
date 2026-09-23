package pages;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TestCasesPage {
    private final SelenideElement casesButton = $("[data-testid=\"sidebarCasesOverview\"]");
    private final SelenideElement addTestCaseButton = $("[data-testid=\"sidebarCasesAdd\"]");
    private final SelenideElement titleInput = $("[data-testid=\"addEditCaseTitle\"]");
    private final SelenideElement saveButton = $("[id=\"accept\"]");
    private final SelenideElement idCase = $("[data-testid=\"testCaseContentHeaderTitle\"]");
    private final SelenideElement navigateTestButton = $("[data-testid=\"navigateToCasesButton\"]");


    public void openTestCases() {
        casesButton.click();
    }
    public void addCase() {
        addTestCaseButton.click();
    }
    public void nameTitle(String title) {
        titleInput.shouldBe(editable).click();
        titleInput.setValue(title);
        titleInput.shouldHave(value(title));
    }
    public void saveTestCase() {
        saveButton.click();
        $x("//*[contains(text(),'Successfully added the new test case')]").shouldBe(visible);
    }
    public void check(String idTitle) {
        idCase.shouldHave(text(idTitle));
    }
    public void deleteButton(String caseTitle) {
        SelenideElement caseRow = $x("//tr[.//span[@data-testid='sectionCaseTitle' and text()='" + caseTitle + "']]");
        caseRow.hover();
        caseRow.$("[data-testid=\"addSubsectionDeleteIcon\"]").click();
    }
    public void endDelete() {
        SelenideElement deleteDialog = $("[data-testid=\"casesDeletionDialog\"]");
        deleteDialog.$("[data-testid=\"deleteCaseDialogActionSecondary\"]").click();
    }
    public void confirmPermDelete() {
        SelenideElement confirmationDialog = $("[data-testid=\"casesDeletionConfirmationDialog\"]");
        confirmationDialog.$("[data-testid=\"deleteCaseDialogActionDefault\"]").click();
    }
    public void navigateTest() {
        navigateTestButton.click();
    }
    public void checkCaseDeleted(String caseTitle) {
        SelenideElement caseRow = $x("//tr[.//span[@data-testid='sectionCaseTitle' and text()='" + caseTitle + "']]");
        caseRow.shouldNot(exist);
    }
}
