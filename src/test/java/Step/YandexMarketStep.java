package Step;

import Page.LaptopPage;
import Page.YandexMarketPage;
import base.BaseSetup;
import cucumber.api.java.ast.Ya;
import io.qameta.allure.Step;
import javafx.util.Pair;
import model.BatteryModel;
import model.LaptopBatteryModel;
import model.LaptopModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class YandexMarketStep extends BaseSetup {

    YandexMarketPage yandexMarketPage;
    LaptopPage laptopPage;

    public YandexMarketStep(String browserType,String url) {
        initializeTest(browserType);
        yandexMarketPage = new YandexMarketPage(driver);
        laptopPage = new LaptopPage(driver);
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

    @Step("Перейти в раздел ноутбуки")
    public YandexMarketStep goToLaptop() {
        yandexMarketPage.clickCompTech();
        yandexMarketPage.clickComp();
        yandexMarketPage.clickLaptop();
        return  this;

    }

    @Step("Ввести цену до")
    public YandexMarketStep setPriceTo(String strPriceTo){
        yandexMarketPage.setPriceTo(strPriceTo);
        //return  new YandexMarketStep(driver);
        return  this;
    }
    @Step("Выбрать производителя")
    public  YandexMarketStep  checkProducer(){
        yandexMarketPage.clickHP();
        yandexMarketPage.clickLenovo();
        return  this;
    }
    @Step("Выбрать цвет")
    public YandexMarketStep checkColor(){
        yandexMarketPage.clickBlackColor();
        yandexMarketPage.clickWhiteColor();
        return  this;

    }

    public Pair<String, String> getLaptopWithMinPrice() {
        yandexMarketPage.minSort();
        reloadPage();
        Pair<String, String> result = new Pair<>(
                driver.findElement(By.xpath("//div[@data-id][1]/descendant::div[@class='n-snippet-card2__title']/a")).getText(),
                driver.findElement(By.xpath("//div[@data-id][1]/descendant::div[@class='price']")).getText()
        );
        System.out.println();
        System.out.println("Laptop with min prise:");
        System.out.println("Name: " + result.getKey());
        System.out.println("Price: " + result.getValue());
        System.out.println();
        return result;
    }

    public Pair<String, String> getLaptopWithMaxPrice() {
        yandexMarketPage.maxSort();
        reloadPage();
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
   @Step("Вывести самый дешевый и самый дорогой ноутбук и разницу в цене")
    public YandexMarketStep  pringMinMaxAndDifference() {
        String minPrice = getLaptopWithMinPrice().getValue().replace(" ", "");
        String maxPrice = getLaptopWithMaxPrice().getValue().replace(" ", "");
        Integer difference = Integer.valueOf(maxPrice.substring(0, maxPrice.length()-1)) - Integer.valueOf(minPrice.substring(0, minPrice.length()-1));
        System.out.println("Разница в цене= " + difference);
        return  this;
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
    @Step("Вывести отсортированный список ноутбуков по названию")
    public YandexMarketStep getAndSortLaptops()  {
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
        for(LaptopModel laptop: laptopModels) {
            System.out.println("[" + index + "] Название: " + laptop.getName());
            index++;
        }
    return  this;}


   @Step("Создать класс питание")
    public YandexMarketStep getBattery() {
        driver.get("https://market.yandex.ru/product--noutbuk-hp-stream-14-ax014ur-intel-celeron-n3060-1600-mhz-14-1366x768-2gb-32gb-emmc-dvd-net-intel-hd-graphics-400-wi-fi-bluetooth-windows-10-home/1863692401/spec?track=tabs&glfilter=14871214%3A14899090&priceto=18000");
        laptopPage.goToSpecTab();
        BatteryModel batteryModel = new BatteryModel(
                driver.findElement(By.xpath("//div[@class='layout__col layout__col_size_p75 n-product-spec-wrap']/div[12]//dl[1]")).getText(),
                driver.findElement(By.xpath("//div[@class='layout__col layout__col_size_p75 n-product-spec-wrap']/div[12]//dl[2]")).getText(),
                driver.findElement(By.xpath("//div[@class='layout__col layout__col_size_p75 n-product-spec-wrap']/div[12]//dl[3]")).getText(),
                driver.findElement(By.xpath("//div[@class='layout__col layout__col_size_p75 n-product-spec-wrap']/div[12]//dl[4]")).getText());
        return  this;}

    @Step("Вывести подсказку")
    public YandexMarketStep printPopup() {
        laptopPage.printPopup();
        return  this;
    }
    @Step("Задание выполнено")
    public YandexMarketStep finishStep(){
        System.out.print("Я молодец!!!");
        return  this;
    }

    public YandexMarketPage getYandexMarketPage() {
        return yandexMarketPage;
    }


}