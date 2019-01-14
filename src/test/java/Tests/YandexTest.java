package Tests;

import Page.YandexMarketPage;
import Step.YandexMarketStep;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
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

    @Feature("Выполнение тестового задания")
    @Test(description = "Автоматизация яндекс маркета")
    public void testYandexMarketTechCategory() throws InterruptedException {
        yandexMarketStep.goToLaptop()
                .setPriceTo("18000")
                .checkProducer()
                .checkColor()
                //.printMaxLaptop(yandexMarketStep.getLaptopWithMaxPrice())//Вывод самого дорогого ноутбука
                //.printMinLaptop(yandexMarketStep.getLaptopWithMinPrice())//Вывод самого дешевого ноутбука
                //.pringMinMaxAndDifference()//Вывод разницы в цене
                .pringMinMaxAndDifference()
                .getAndSortLaptops()//вывод отсортированных ноутбуков
                .getBattery()// создан класс питание
                .printPopup()//вывод текста подсказки
                .finishStep();//



//        yandexMarketStep.goToLaptop(); //перешли в раздел Ноутбуки
//        yandexMarketStep.setPriceTo("18000"); // задан параметр поиска
//        yandexMarketStep.checkProducer();// Выбран  производитель HP и Lenovo
//        yandexMarketStep.checkColor();//•	Выбран черный, белый цвет
//        yandexMarketStep.waitLoadPage();//ожидание
//        yandexMarketStep.printMaxLaptop(yandexMarketStep.getLaptopWithMaxPrice());//Вывод самого дорогого ноутбука
//        yandexMarketStep.printMinLaptop(yandexMarketStep.getLaptopWithMinPrice());//Вывод самого дешевого ноутбука
//        yandexMarketStep.pringMinMaxAndDifference();//Вывод разницы в цене
//        yandexMarketStep.getAndSortLaptops();//вывод отсортированных ноутбуков
//        yandexMarketStep.getBattery();// создан класс питание
//        yandexMarketStep.printPopup();//вывод текста подсказки
//        yandexMarketStep.finishStep();//
    }

    }

