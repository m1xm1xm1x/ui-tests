package pages;
import static com.codeborne.selenide.Condition.visible;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;

public class ProfilePage {
    private final SelenideElement dropMenuButton = $("[data-testid=\"userDropdown\"]");
    private final SelenideElement settingProfileButton = $("[data-testid=\"pageSettingsButton\"]");
    private final SelenideElement mySettings = $("[data-testid=\"testCaseContentHeaderTitle\"]");

    public void openDropMenu() {
        dropMenuButton.click();
    }
    public void settingMenu() {
        settingProfileButton.click();
    }
    public void checkMySettings() {
        mySettings.shouldBe(visible);
        mySettings.shouldHave(text("My Settings"));
    }
}
