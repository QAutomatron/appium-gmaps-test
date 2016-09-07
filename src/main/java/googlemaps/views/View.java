package googlemaps.views;

import applogic.InvisibilityOfElement;
import applogic.InvisibilityOfElementLocated;
import applogic.VisibilityOfElement;
import applogic.VisibilityOfElementLocated;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * Abstract View
 */
public abstract class View {

//    @Autowired
    private AndroidDriver driver;

    private Wait<WebDriver> wait;
//    private final String baseUrl = PropertyLoader.loadProperty("base.url");

    @Autowired
    View() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");

        //mandatory capabilities
        capabilities.setCapability("deviceName","Android");
        capabilities.setCapability("platformName","Android");

        //other caps
        capabilities.setCapability("appPackage", "com.google.android.apps.maps");
        capabilities.setCapability("appActivity", "com.google.android.maps.MapsActivity");

        URL appiumUrl;

        try {
            appiumUrl = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new Error(e);
        }

        this.driver = new AndroidDriver(appiumUrl, capabilities);
    }

    @PostConstruct
    public void init() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, 10, 500);
    }

	public AndroidDriver getDriver() {
		return driver;
	}

    /**
     * Stop Driver
     */
    public void stop() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }

    public void submit() {
        driver.pressKeyCode(AndroidKeyCode.ENTER);
    }

    /**
     * Wait until element is present
     * @param element element
     * @return boolean
     */
    protected boolean waitForElementPresent(WebElement element) {
        Boolean result = true;
        try {
            wait.until(new VisibilityOfElement(element));
        } catch (TimeoutException e) {
            result = false;
        } catch (Throwable t) {
            throw new Error(t);
        }
        return result;
    }

    /**
     * Wait until element not present
     * @param element element
     * @return boolean
     */
    protected boolean waitForElementNotPresent(WebElement element) {
        Boolean result = true;
        try {
            wait.until(new InvisibilityOfElement(element));
        } catch (TimeoutException e) {
            result = false;
        } catch (Throwable t) {
            throw new Error(t);
        }
        return result;
    }

    /**
     * Wait for element invisibility
     * @param locator element locator
     * @return boolean
     */
    protected boolean waitForElementNotPresent(By locator) {
        Boolean result = true;
        try {
            wait.until(new InvisibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            result = false;
        } catch (Throwable t) {
            throw new Error(t);
        }
        return result;
    }

    /**
     * Wait until element present by locator
     * @param locator locator
     * @return boolean
     */
    protected boolean waitForElementPresent(By locator) {
        Boolean result = true;
        try {
            wait.until(new VisibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            result = false;
        } catch (Throwable t) {
            throw new Error(t);
        }
        return result;
    }

    /**
     * Type string into element
     * @param element element
     * @param s string
     */
    protected void typeInto(WebElement element, String s) {
        element.clear();
        element.sendKeys(s);
    }

    /**
     * Get attribute "value" of the element
     * @param element element
     * @return value
     */
    protected String getValue(WebElement element) {
        return element.getAttribute("value");
    }

    /**
     * Get WebElement
     */
    protected WebElement $ (By by) {
        return getDriver().findElement(by);
    }

    public void start() {
        getDriver().startActivity("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
    }
}
