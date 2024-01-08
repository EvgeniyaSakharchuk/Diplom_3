
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import user.CreateUserRequest;
import user.*;


import java.time.Duration;

public class NavigateSectionTest {
    User user;
    String accessToken;
    WebDriver driver;
    CreateUserRequest userClient;

    @Before
    @Step("Предусловия для тестов")
    public void setUp() {

        ChromeOptions option = new ChromeOptions();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        user = UserGenerator.usersRandomCreate();
        userClient = new CreateUserRequest();
        ValidatableResponse responseCreateUser = userClient.createUser(user);
        accessToken = responseCreateUser.extract().path("accessToken").toString().substring(7);
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
