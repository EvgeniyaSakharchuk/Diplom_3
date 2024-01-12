
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pageobject.MainPage;
import static config.Config.BASE_URL;

public class PersonalAccToMainPage extends BaseTest{
    @Test
    @DisplayName("Переход из личного кабинета на главную по кнопке Конструктор")
    @Description("Утверждение, что главная страница отображается")
    public void switchFromProfileByConstructor() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage()
                .clickProfileButton()
                .authFromLoginPage(user.getEmail(), user.getPassword())
                .clickLoginEnterButton()
                .clickProfileButtonFromAuthorizedUser()
                .clickConstructorButton();
        Assert.assertEquals(BASE_URL + "/", driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход из личного кабинета на главную по Лого")
    @Description("Утверждение, что главная страница отображается")
    public void switchFromProfileByLogo() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage()
                .clickProfileButton()
                .authFromLoginPage(user.getEmail(), user.getPassword())
                .clickLoginEnterButton()
                .clickProfileButtonFromAuthorizedUser()
                .clickOnLogo();
        Assert.assertEquals(BASE_URL+ "/", driver.getCurrentUrl());
    }


}
