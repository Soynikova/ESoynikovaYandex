package Step;

import Page.LaptopPage;
import Page.YandexMarketPage;
import base.BaseSetup;
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



    public void goToLaptop() {
        yandexMarketPage.clickCompTech();
        yandexMarketPage.clickComp();
        yandexMarketPage.clickLaptop();

    }


    public void  setPriceTo(String strPriceTo){
        yandexMarketPage.setPriceTo(strPriceTo);
        //return  new YandexMarketStep(driver);
    }
    public  void  checkProducer(){
        yandexMarketPage.clickHP();
        yandexMarketPage.clickLenovo();
    }
    public void checkColor(){
        yandexMarketPage.clickBlackColor();
        yandexMarketPage.clickWhiteColor();

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
        System.out.println("Laptop with max prise:");
        System.out.println("Name: " + result.getKey());
        System.out.println("Price: " + result.getValue());
        System.out.println();
        return result;
    }

    public void pringMinMaxAndDifference() {
        String minPrice = getLaptopWithMinPrice().getValue().replace(" ", "");
        String maxPrice = getLaptopWithMaxPrice().getValue().replace(" ", "");
        Integer difference = Integer.valueOf(maxPrice.substring(0, maxPrice.length()-1)) - Integer.valueOf(minPrice.substring(0, minPrice.length()-1));
        System.out.println("Difference = " + difference);
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
        public void getAndSortLaptops()  {
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
                System.out.println("[" + index + "] Name: " + laptop.getName());
                index++;
            }
        }



    public void getBattery1(){
        driver.get("https://market.yandex.ru/product--noutbuk-lenovo-v130-15/197642238?nid=54544");


        laptopPage.goToSpecTab();

        BatteryModel batteryModel = new BatteryModel(
                driver.findElement(By.xpath("//div[@class='layout__col layout__col_size_p75 n-product-spec-wrap']/div[12]//dl[1]")).getText(),
                driver.findElement(By.xpath("//div[@class='layout__col layout__col_size_p75 n-product-spec-wrap']/div[12]//dl[2]")).getText(),
                driver.findElement(By.xpath("//div[@class='layout__col layout__col_size_p75 n-product-spec-wrap']/div[12]//dl[3]")).getText());

        System.out.print("Выполнено");
    }



    public void printPopup() {
        laptopPage.printPopup();
    }
    public void finishStep(){
        System.out.print("Я молодец!!!");
    }


}
