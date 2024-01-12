package pageobject;
import static config.Config.RECOVERY_PASSWORD_URL;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPasswordPage {
    private static final By enterButtonOnRecoverPage = By.xpath(".//a[text()='Войти']");
    private final WebDriver driver;
    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Открыть страницу восстановления")
    public ResetPasswordPage openRecoveryPage() {
        driver.get(RECOVERY_PASSWORD_URL);
        return this;
    }

    @Step("Клик на кнопку Восстановить")
    public LoginPage clickEnterButtonOnRecoveryPage() {
        driver.findElement(enterButtonOnRecoverPage).click();
        return new LoginPage(driver);
    }
}
