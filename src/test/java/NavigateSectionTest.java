
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import user.CreateUserRequest;
import user.*;
import pageobject.MainPage;


import java.time.Duration;

public class NavigateSectionTest {
    User user;
    String accessToken;
    WebDriver driver;
    CreateUserRequest userClient;
    private MainPage mainPage;

    @Before
    @Step("Предусловия для тестов")
    public void setUp() {
        System.setProperty("web-driver.http.factory", "\\src\\main\\resources\\chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mainPage = new MainPage(driver);
    }
    @Test
    @DisplayName("Утверждение что раздел соус активен")
    @Description("Сравнить название выбранного раздела")
    public void menuSauceIsActiveByClick() {
        mainPage.openMainPage()
                .clickMenuSauce();
        Assert.assertEquals("Соусы", mainPage.getTextFromSelectedMenu());
    }

    @Test
    @DisplayName("Утверждение что раздел Булки активен")
    @Description("Сравнить название выбранного раздела")
    public void menuBunIsActiveByClick() {
         mainPage.openMainPage()
                .clickMenuSauce()
                .clickMenuBun();
        Assert.assertEquals("Булки", mainPage.getTextFromSelectedMenu());
    }

    @Test
    @DisplayName("Утверждение что раздел Начинки активен")
    @Description("Сравнить название выбранного раздела")
    public void menuFillingsIsActiveByClick() {
        mainPage.openMainPage()
                .clickMenuFillings();
        Assert.assertEquals("Начинки", mainPage.getTextFromSelectedMenu());
    }

    @After
    @Step("Удаление тестового пользователя и закрыть браузер")
    public void tearDown() {
        if (accessToken != null) {
            userClient.deleteUser(accessToken);
        }
        driver.quit();
    }
}
