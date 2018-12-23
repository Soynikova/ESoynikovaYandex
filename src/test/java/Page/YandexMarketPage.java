package Page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.util.Comparator;
import java.util.List;


@Test
public class YandexMarketPage {

    private WebDriver driver;

    public YandexMarketPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//html/body/div[1]/div/div[3]/noindex/div/div[4]/a")
    private WebElement CompTech;
    @FindBy(xpath = "//a[@class='_2qvOOvezty SvBTI5gwNn _2EJs7HYaZ4'][contains(text(),'Компьютеры')]")
    private WebElement Comp;
    @FindBy(xpath = "//a[@class='_2qvOOvezty SvBTI5gwNn _2EJs7HYaZ4'][contains(text(),'Ноутбуки')]")
    private WebElement Laptop;
    @FindBy(xpath = "//*[@id=\"glpriceto\"]")
    private WebElement PriceTo;
    @FindBy(xpath = "//fieldset[@data-autotest-id='7893318']//label[@for='7893318_152722']")
    private WebElement HP;
    @FindBy(xpath = "//fieldset[@data-autotest-id='7893318']//label[@for='7893318_152981']")
    private WebElement Lenovo;
    @FindBy(xpath = "//*[@id=\"search-prepack\"]//fieldset[@data-autotest-id='13887626']//label[@for='13887626_13899071']")
    private WebElement BlackColor;
    @FindBy(xpath = "//*[@id=\"search-prepack\"]//fieldset[@data-autotest-id='13887626']//label[@for='13887626_13887686']")
    private WebElement WhiteColor;


    public void clickCompTech() {


        CompTech.click();
    }

    public void clickComp() {

        Comp.click();
    }

    public void clickLaptop() {

        Laptop.click();
    }

    public void setPriceTo(String strPriceTo) {
        PriceTo.sendKeys(strPriceTo);

    }

    public void clickHP() {
        HP.click();
    }

    public void clickLenovo() {
        Lenovo.click();
    }

    public void clickBlackColor() {
        if (BlackColor.isDisplayed() || BlackColor.isEnabled())
            BlackColor.click();
    }

    public void clickWhiteColor() {
        if (WhiteColor.isEnabled() || WhiteColor.isDisplayed())
            WhiteColor.click();
    }
    public  int getAndSortLaptops(){
       List<WebElement> laptopList = driver.findElements(By.xpath("//div[@class='n-filter-applied-results__content preloadable i-bem preloadable_js_inited']/div/div"));
//       laptopList.sort(new Comparator<WebElement>() {
//           @Override
//           public int compare(WebElement o1, WebElement o2) {
//               return o1.
//           }
//       });
        return 1;


    }


}





