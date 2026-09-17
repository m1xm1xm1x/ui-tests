package pages;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class LoginPage {
    private final SelenideElement emailInput = $("[data-testid=\"loginIdName\"]");
    private final SelenideElement passwordInput = $("[data-testid=\"loginPasswordFormDialog\"]");
    private final SelenideElement loginButton = $("[data-testid=\"loginButtonPrimary\"]");
    private final SelenideElement passwordError = $x("//*[text()='Password is required.']");
    private final SelenideElement emailError = $x("//*[text()='Email/Login is required.']");
    private final SelenideElement errorAuth = $x("//*[text()='Email/Login or Password is incorrect. Please try again.']");

    public void login(String login, String password) {
        emailInput.shouldBe(editable).click();
        emailInput.shouldBe(editable).setValue(login);
        emailInput.shouldHave(value(login));
        passwordInput.shouldBe(editable).setValue(password);
        passwordInput.shouldHave(value(password));
        loginButton.click();
    }
    public void checkPasswordError() {
        passwordError.shouldBe(visible).shouldHave(text("Password is required."));
    }
    public void checkEmailError() {
        emailError.shouldBe(visible).shouldHave(text("Email/Login is required."));
    }
    public void shouldBeOpened() {
        emailInput.shouldBe(visible);
    }
    public void checkErrorAuth() {
        errorAuth.shouldBe(visible).shouldHave(text("Email/Login or Password is incorrect. Please try again."));
    }

}



