import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pageobject.MainPage;
import pageobject.RegisterPage;
import pageobject.ResetPasswordPage;

import static config.Config.LOGIN_PAGE_URL;

public class LoginTest extends BaseTest{
    @Test
    @DisplayName("Проверка входа по кнопке Войти в аккаунт на главной странице")
    @Description("Утверждение, что главная страница отображается")
    public void loginFromMainePageByEnterAccount() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage()
                .clickAccountButton()
                .authFromLoginPage(user.getEmail(), user.getPassword())
                .clickLoginEnterButton();
        Assert.assertTrue(mainPage.isManePageOpen());
    }

    @Test
    @DisplayName("Проверка входа с помощью кнопки Личный Кабинет на главной странице")
    @Description("Утверждение, что главная страница отображается")
    public void loginFromMainPageProfileButton() {
        driver.get(LOGIN_PAGE_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage()
                .clickProfileButton()
                .authFromLoginPage(user.getEmail(), user.getPassword())
                .clickLoginEnterButton();
        Assert.assertTrue(mainPage.isManePageOpen());
    }

    @Test
    @DisplayName("Проверка входа по кнопке Вход на странице регистрации")
    @Description("Утверждение, что главная страница отображается")
    public void loginFromRegistrationPage() {
        driver.get(LOGIN_PAGE_URL);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.openRegisterPage()
                .clickEnterButtonOnRegistrationPage()
                .authFromLoginPage(user.getEmail(), user.getPassword())
                .clickLoginEnterButton();
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isManePageOpen());
    }

    @Test
    @DisplayName("Проверка входа по кнопке Вход на странице восстановления")
    @Description("Утверждение, что главная страница отображается")
    public void loginFromRecoveryPage() {
        driver.get(LOGIN_PAGE_URL);
        ResetPasswordPage resetPasswordPage= new ResetPasswordPage(driver);
        resetPasswordPage.openRecoveryPage()
                .clickEnterButtonOnRecoveryPage()
                .authFromLoginPage(user.getEmail(), user.getPassword())
                .clickLoginEnterButton();
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isManePageOpen());
    }
}
