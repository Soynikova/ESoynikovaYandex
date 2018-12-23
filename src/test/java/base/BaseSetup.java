package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseSetup {

    protected WebDriver driver;
    static String driverPath = "C:\\Users\\Kate\\Downloads\\chromedriver_win32\\chromedriver.exe";

    public WebDriver getDriver() {
        return driver;
    }

    private void setDriver(String browserType) {
        switch (browserType) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            default:
                System.out.println("browser : " + browserType
                        + " is invalid, Launching Firefox as browser of choice..");
                driver = initFirefoxDriver();
        }
    }

    private static WebDriver initChromeDriver() {
        System.out.println("Launching google chrome with new profile..");
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    private static WebDriver initFirefoxDriver() {
        System.out.println("Launching Firefox browser..");
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public void initializeTest(String browserType) {
        try {
            setDriver(browserType);
        } catch (Exception e) {
            System.out.println("Error….." + e.getStackTrace());
        }
    }

}
