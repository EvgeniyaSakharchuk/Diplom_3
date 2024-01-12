
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
import pageobject.RegisterPage;
import user.User;
import user.UserGenerator;

import java.time.Duration;

import static config.Config.ERROR_MESSAGE_OF_WRONG_PASSWORD;
import static pageobject.RegisterPage.registerWrongPasswordMessageInRegisterPage;

public class WrongPasswordSet {
    private WebDriver driver;
    private User user;
    @Before
    @Step("Предусловия для тестов")
    public void setUp() {
        System.setProperty("web-driver.http.factory", "\\src\\main\\resources\\chrome.exe");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        user = UserGenerator.usersRandomCreate();
    }

    @Test
    @DisplayName("Создание заказа с неверным паролем")
    @Description("Проверка пароля состоящего из 3 символов")
    public void shownErrorMessageWithWrongPassword() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.openRegisterPage()
                .enterRegisterName(user.getName())
                .enterRegisterEmail(user.getEmail())
                .enterRegisterPassword("123")
                .clickRegistrationButton();
        Assert.assertEquals("Ошибка не появилась", ERROR_MESSAGE_OF_WRONG_PASSWORD,
                driver.findElement(registerWrongPasswordMessageInRegisterPage).getText());
    }

    @After
    @Step("Закрыть браузер")
    public void tearDown() {
        driver.quit();
    }
}
