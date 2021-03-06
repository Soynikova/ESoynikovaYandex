package Page;


import com.google.common.base.Stopwatch;
import jdk.internal.instrumentation.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static sun.plugin2.message.HeartbeatMessage.DEFAULT_TIMEOUT;


@Test
public class YandexMarketPage  {


    private  WebDriver driver;

    public YandexMarketPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        this.driver = driver;


    }


    @FindBy(xpath = "//div[@class='n-w-tab n-w-tab_interaction_hover-navigation-menu n-w-tab_type_navigation-menu i-bem n-w-tab_js_inited']//span[@class='n-w-tab__control-caption'][contains(text(),'Компьютерная техника')]")
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
    @FindBy(xpath = "//div[@data-id][1]/div[4]/div[1]/div[1]/a")
    private WebElement firstLaptopLink;
    @FindBy(xpath = "//a[text()='по цене']")
    private WebElement sortButton;
    @FindBy(xpath = "//div[contains(@class, 'n-filter-sorter_sort_asc')]")
    private List<WebElement> minSortButton;
    @FindBy(xpath = "//div[contains(@class, 'n-filter-sorter_sort_desc')]")
    private List<WebElement> maxSortButton;
    @FindBy(xpath = "//div[@class='pager-more__button pager-loader_preload']")
    private WebElement showMoreButton;




    public  Wait<WebDriver> checkIsElementVisible(WebElement webElement){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5).withMessage("Element was not found");
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return wait ;


    }

     public  WebElement checkIsElementClickable(WebElement webElement){
         checkIsElementVisible(webElement).until(ExpectedConditions.elementToBeClickable(webElement));
         return webElement;
     }

    public  void  clickCompTech() {
        checkIsElementClickable(CompTech).click();

    }

    public void clickComp() {

        checkIsElementClickable(Comp).click();
    }

    public void clickLaptop() {

        checkIsElementClickable(Laptop).click();
    }

    public void setPriceTo(String strPriceTo) {
        checkIsElementVisible(PriceTo);
        PriceTo.sendKeys(strPriceTo);

    }

    public void clickHP() {

        checkIsElementClickable(HP).click();
    }

    public void minSort() {

        if(minSortButton.size() > 0){
            return;
        }
        checkIsElementClickable(sortButton).click();
    }

    public void maxSort() {

        if(maxSortButton.size() > 0){
            return;
        }
        checkIsElementClickable(sortButton).click();

    }

    public void clickLenovo() {

        checkIsElementClickable(Lenovo).click();
    }

    public void clickBlackColor() {

            checkIsElementClickable(BlackColor).click();
    }

    public void clickWhiteColor() {

       checkIsElementClickable(WhiteColor).click();
    }

    public void clickFirstLaptopLink() {

        checkIsElementClickable(firstLaptopLink).click();
    }

    public void showAllLaptops() throws InterruptedException {
        while (driver.findElements(By.xpath("//span[text()='Показать еще']/parent::*[contains(@class, 'button_disabled_yes')]")).size() < 1) {
            while(driver.findElements(By.xpath("//div[contains(@class, 'spin_progress_yes')]")).size() > 0){
                Thread.sleep(1000);
            }
            if(driver.findElements(By.xpath("//a[@class='button button_size_m button_theme_pseudo i-bem button_js_inited button_disabled_yes']")).size() > 0){
                break;
            }
            showMoreButton.click();
        }

    }

}





