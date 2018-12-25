package Tests;

import Step.YandexMarketStep;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.annotations.Test;


public class YandexTest {

    private YandexMarketStep yandexMarketStep;


    @Feature("ujhj")
    @Test(description = "jekfhkfjh")

    public void testYandexMarketTechCategory() throws InterruptedException {
        yandexMarketStep = new YandexMarketStep("chrome","https://market.yandex.ru/");
    yandexMarketStep.goToLaptop();
    yandexMarketStep.setPriceTo("18000");
    yandexMarketStep.checkProducer();
    yandexMarketStep.checkColor();
    yandexMarketStep.waitLoadPage();
    yandexMarketStep.getAndSortLaptops();
    yandexMarketStep.pringMinMaxAndDifference();
    yandexMarketStep.getBatteryInfo();
    yandexMarketStep.printPopup();
    }

}
