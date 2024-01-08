
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegisterPage;
import user.AuthData;
import user.CreateUserRequest;
import user.User;
import user.UserGenerator;

import java.time.Duration;

public class RegisterTest {
    WebDriver driver;
    private User user;
    private CreateUserRequest createUserRequest;
    private String accessToken;
    private AuthData authData;

    @Before
    @Step("Предусловия для тестов")
    public void setUp() {
        ChromeOptions option = new ChromeOptions();
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        user = UserGenerator.usersRandomCreate();
    }

    @Test
    @DisplayName("Регистрация нового пользователя")
    @Description("Утверждение, что после регистрации отображается главная страница")
    public void successfullyRegistrationOnRegisterPage() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.openRegisterPage()
                .registerNewUser(user)
                .clickRegistrationButton()
                .authFromLoginPage(user.getEmail(), user.getPassword())
                .clickLoginEnterButton();
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isManePageOpen());
    }

    @Test
    @DisplayName("Регистрация через страницу входа")
    @Description("Утверждение, что после регистрации отображается главная страница")
    public void successfullyRegistrationOnLoginPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage()
                .clickRegisterButtonLoginPage()
                .registerNewUser(user)
                .clickRegistrationButton()
                .authFromLoginPage(user.getEmail(), user.getPassword())
                .clickLoginEnterButton();
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isManePageOpen());
    }

    @Test
    @DisplayName("Регистрация через главную страницу")
    @Description("CУтверждение, что после регистрации отображается главная страница")
    public void successfullyRegistrationOnMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage()
                .clickAccountButton()
                .clickRegisterButtonLoginPage()
                .registerNewUser(user)
                .clickRegistrationButton()
                .authFromLoginPage(user.getEmail(), user.getPassword())
                .clickLoginEnterButton();
        Assert.assertTrue(mainPage.isManePageOpen());
    }

    @After
    @Step("закрытие браузера")
    public void tearDown() {
        if (driver != null){
            driver.quit();}
    }


}
