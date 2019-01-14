package Step;

import Page.LaptopPage;
import Page.YandexMarketPage;
import base.BaseSetup;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.То;
import cucumber.api.java.ru.Тогда;
import javafx.util.Pair;
import model.BatteryModel;
import model.LaptopModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class YandexMarketStepForCucumber extends BaseSetup {


    YandexMarketStep yandexMarketStep;
    YandexMarketPage yandexMarketPage;
    LaptopPage laptopPage;

    public YandexMarketStepForCucumber() {
        initializeTest("chrome");
        yandexMarketPage = new YandexMarketPage(driver);
        laptopPage = new LaptopPage(driver);
        HtmlElementLoader.populatePageObject(this, driver);

    }


    @Тогда("^Перейти в раздел ноутбуки$")
    public void перейти_в_раздел_ноутбуки() {
        driver.navigate().to("https://market.yandex.ru/");
        yandexMarketPage.clickCompTech();//
        yandexMarketPage.clickComp();
        yandexMarketPage.clickLaptop();

    }

    @Тогда("Задать цену до (.*)")
    public void задать_цену_до(String strPriceTo) {
        yandexMarketPage.setPriceTo(strPriceTo);

    }

    @Тогда("^Выбрать производителя$")
    public void выбрать_производителя() {
        yandexMarketPage.clickHP();
        yandexMarketPage.clickLenovo();
    }

    @Тогда("^Выбрать цвет$")
    public void выбрать_цвет() {
        yandexMarketPage.clickBlackColor();
        yandexMarketPage.clickWhiteColor();
    }
    public Pair<String, String> getLaptopWithMinPrice() {
        yandexMarketPage.minSort();
        //reloadPage();
        Pair<String, String> result = new Pair<>(
                driver.findElement(By.xpath("//div[@data-id][1]/descendant::div[@class='n-snippet-card2__title']/a")).getText(),
                driver.findElement(By.xpath("//div[@data-id][1]/descendant::div[@class='price']")).getText()
        );
        System.out.println();
        System.out.println("Самый дешевый ноутбук:");
        System.out.println("Название: " + result.getKey());
        System.out.println("Цена: " + result.getValue());
        System.out.println();
        return result;
    }

    public Pair<String, String> getLaptopWithMaxPrice() {
        yandexMarketPage.maxSort();
        //reloadPage();
        Pair<String, String> result = new Pair<>(
                driver.findElement(By.xpath("//div[@data-id][1]/descendant::div[@class='n-snippet-card2__title']/a")).getText(),
                driver.findElement(By.xpath("//div[@data-id][1]/descendant::div[@class='price']")).getText()
        );
        System.out.println();
        System.out.println("Самый дорогой ноутбук:");
        System.out.println("Название: " + result.getKey());
        System.out.println("Цена: " + result.getValue());
        System.out.println();
        return result;
    }
    @Тогда("^Вывести разницу$")

    public void  вывести_разницу() {
        String minPrice = getLaptopWithMinPrice().getValue().replace(" ", "");
        String maxPrice = getLaptopWithMaxPrice().getValue().replace(" ", "");
        Integer difference = Integer.valueOf(maxPrice.substring(0, maxPrice.length()-1)) - Integer.valueOf(minPrice.substring(0, minPrice.length()-1));
        System.out.println("Разница в цене = " + difference);

    }


    //public void getBatteryInfo() {
    //  yandexMarketPage.clickFirstLaptopLink();
    // Map<String, String> specs = new HashMap<>();
    // laptopPage.goToSpecTab();
    // for (int i = 1; i <= laptopPage.getBatterySpecSize(); i++) {
    //   Pair<String, String> specPart = laptopPage.getPartOfBatterySpec(i);
    //  specs.put(specPart.getKey(), specPart.getValue());
    //}
    //LaptopBatteryModel battery = new LaptopBatteryModel(specs);
    // System.out.println();
    //}
    @Тогда("^Сортировка по названию$")
    public void сортировка_по_имени() {
        // reloadPage();
        // yandexMarketPage.showAllLaptops();
        List<LaptopModel> laptopModels = new ArrayList<>();
        Integer laptopListSize = driver.findElements(By.xpath("//div[@data-id]")).size();
        for (int i = 1; i <= laptopListSize; i++) {
            laptopModels.add(new LaptopModel(
                    driver.findElement(By.xpath("//div[@data-id][" + i + "]/div[4]/div[1]/div[1]/a")).getText(),
                    driver.findElement(By.xpath("//div[@data-id][" + i + "]/div[5]/div/div/div/div/a/div")).getText()
            ));
        }
        laptopModels = laptopModels.stream().sorted(Comparator.comparing(LaptopModel::getName)).collect(Collectors.toList());
        int index = 1;
        for (LaptopModel laptop : laptopModels) {
            System.out.println("[" + index + "] Название: " + laptop.getName());
            index++;
        }

    }

    @Тогда("^Создать класс Питание$")
    public void создать_класс_питание() {
        driver.get("https://market.yandex.ru/product--noutbuk-hp-stream-14-ax014ur-intel-celeron-n3060-1600-mhz-14-1366x768-2gb-32gb-emmc-dvd-net-intel-hd-graphics-400-wi-fi-bluetooth-windows-10-home/1863692401/spec?track=tabs&glfilter=14871214%3A14899090&priceto=18000");
        laptopPage.goToSpecTab();
        BatteryModel batteryModel = new BatteryModel(
                driver.findElement(By.xpath("//div[@class='layout__col layout__col_size_p75 n-product-spec-wrap']/div[12]//dl[1]")).getText(),
                driver.findElement(By.xpath("//div[@class='layout__col layout__col_size_p75 n-product-spec-wrap']/div[12]//dl[2]")).getText(),
                driver.findElement(By.xpath("//div[@class='layout__col layout__col_size_p75 n-product-spec-wrap']/div[12]//dl[3]")).getText(),
                driver.findElement(By.xpath("//div[@class='layout__col layout__col_size_p75 n-product-spec-wrap']/div[12]//dl[4]")).getText());
    }

    @Тогда("^Вывести подсказку$")
    public void вывести_подсказку() {
        laptopPage.printPopup();
    }
    @Тогда("^Задание выполнено$")
    public void задание_выполнено() {
        System.out.print("Все сделала! Я молодец");

    }
}