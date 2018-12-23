package Tests;

import Page.YandexMarketPage;
import base.BaseSetup;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import Step.YandexMarketStep;
@Test
public class YandexTest {

    private YandexMarketStep yandexMarketStep;


    public void testYandexMarketTechCategory(){
        yandexMarketStep = new YandexMarketStep("chrome","https://market.yandex.ru/");

        yandexMarketStep.goToLaptop();
        yandexMarketStep.setPriceTo("30000");
        yandexMarketStep.checkProducer();
        yandexMarketStep.checkColor();
        yandexMarketStep.minPriceLaptop();

    }
}
