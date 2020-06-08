package ru.ozon;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import ru.ozon.HomePage;
import ru.ozon.ProfileUserPage;
import ru.ozon.ShoppingPage;

public class Tests extends WebDriverSettings {

    private String city = "Вольск";
    
    @Test
    public void login() throws InterruptedException {

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        ProfileUserPage profileUserPage = PageFactory.initElements(driver, ProfileUserPage.class);

        homePage.open();
        homePage.openLoginForm();
        homePage.fillPhone();
        profileUserPage.checkAuthorization();
    }
    
    @Test
    public void changeCity() throws InterruptedException {

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        ProfileUserPage profileUserPage = PageFactory.initElements(driver, ProfileUserPage.class);

        homePage.open();
        homePage.changeCity();
        homePage.fillCity(city);
        homePage.checkCurrentCity(city);
        homePage.openLoginForm();
        homePage.fillPhone();
        profileUserPage.open();
        homePage.checkCurrentCity(city);
    }
    
    @Test
    public void filtrationByPrice() throws InterruptedException {

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        homePage.open();
        homePage.fillSearchQuery();

        ShoppingPage shoppingPage = PageFactory.initElements(driver, ShoppingPage.class);

        shoppingPage.fillPriceFromFilter();
        shoppingPage.fillPriceToFilter();
        shoppingPage.changeFiltrationMethod();
        shoppingPage.addSecondPositionToCart();
        shoppingPage.checkCart();
    }
    
    @Test
    public void filtrationByPower() throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        homePage.open();
        homePage.fillSearchQuery();

        ShoppingPage shoppingPage = PageFactory.initElements(driver, ShoppingPage.class);

        shoppingPage.fillPowerFromFilter();
        shoppingPage.changeFiltrationMethod();
        shoppingPage.addSecondPositionToCart();
        shoppingPage.checkCart();
    }
}
