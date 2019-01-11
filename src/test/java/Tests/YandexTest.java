package Tests;

import Step.YandexMarketStep;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class YandexTest {

    private  YandexMarketStep yandexMarketStep;

    private static WebDriver driver;

    @BeforeClass
    public void initBrowser() {

       yandexMarketStep = new YandexMarketStep("chrome","https://market.yandex.ru/");
    }
    @Feature("ujhj")
    @Test(description = "jekfhkfjh")

    public void testYandexMarketTechCategory() throws InterruptedException {
//        yandexMarketStep = new YandexMarketStep("chrome","https://market.yandex.ru/");
        yandexMarketStep.goToLaptop();
        yandexMarketStep.setPriceTo("18000");
        yandexMarketStep.checkProducer();
        yandexMarketStep.checkColor();
      yandexMarketStep.waitLoadPage();
        yandexMarketStep.pringMinMaxAndDifference();
        yandexMarketStep.getAndSortLaptops();
        yandexMarketStep.getBattery1();
        //yandexMarketStep.printPopup();
    }

    @Feature("ujhj")
    @Test(description = "jekfhkfjh")
    public void testFinish()  {
        yandexMarketStep.finishStep();
    }

    }

