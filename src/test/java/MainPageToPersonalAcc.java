import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.MainPage;
import java.time.Duration;

import static config.Config.*;

public class MainPageToPersonalAcc extends BaseTest  {

    @Test
    @DisplayName("Переход в личный кабинет с главной страницы по кнопке Личный кабинет неавторизованным пользователем")
    @Description("Утверждение что страница входа отображается")
    public void clickOnProfileByUnauthorizedUserShowsLoginPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickProfileButton();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
        Assert.assertEquals(LOGIN_PAGE_URL, driver.getCurrentUrl());
    }
}
