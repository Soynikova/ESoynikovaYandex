package Page;

import javafx.util.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class LaptopPage {
    private WebDriver driver;

    public LaptopPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//li[@data-name='spec']/a")
    private WebElement specLink;

    @FindBy(xpath = "//h2[text()='Питание']")
    private WebElement battarySpecs;

    public void goToSpecTab() {
        specLink.click();
    }

    public Pair<String, String> getPartOfBatterySpec(int partNumber) {
        String key = driver.findElement(By.xpath("//h2[text()='Питание']/following-sibling::*[" + partNumber + "]/dt/span")).getText();
        String value = driver.findElement(By.xpath("//h2[text()='Питание']/following-sibling::*[" + partNumber + "]/dd/span")).getText();
        return new Pair<>(key, value);
    }

    public Integer getBatterySpecSize() {
        return driver.findElements(By.xpath("//h2[text()='Питание']/following-sibling::*")).size();
    }

    public void printPopup() {
        driver.findElement(By.xpath("//span[text()='Процессор']/div/span")).click();
        String content = driver.findElement(By.xpath("//div[contains(@class, 'popup_visibility_visible')]/descendant::*/div[@class='n-hint-button__article']")).getText();
        System.out.println("Popup content: " + content);
    }

}
