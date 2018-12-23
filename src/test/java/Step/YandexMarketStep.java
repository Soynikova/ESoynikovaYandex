package Step;
import Page.YandexMarketPage;
import base.BaseSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class YandexMarketStep extends BaseSetup {

    YandexMarketPage yandexMarketPage;

    public YandexMarketStep(String browserType,String url) {
        initializeTest(browserType);
        yandexMarketPage = new YandexMarketPage(driver);
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

    public void goToLaptop() {
        yandexMarketPage.clickCompTech();
        yandexMarketPage.clickComp();
        yandexMarketPage.clickLaptop();

    }
    public void setPriceTo(String strPriceTo){
        yandexMarketPage.setPriceTo(strPriceTo);

    }
    public  void  checkProducer(){
        yandexMarketPage.clickHP();
        yandexMarketPage.clickLenovo();
    }
    public void checkColor(){
        yandexMarketPage.clickBlackColor();
        yandexMarketPage.clickWhiteColor();

    }
    public void minPriceLaptop(){
    }






}
