package com.company.Infrastructure.wdm.factory;
import com.company.Infrastructure.config.ConfigurationManager;
import com.company.Infrastructure.wdm.capabilities.BrowserCapabilities;
import com.company.Infrastructure.wdm.enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class LocalWebDriverFactory implements WebDriverFactory {

    @Override
    public WebDriver create() {
        BrowserType option = BrowserType.valueOf( ConfigurationManager.getInstance().getTestBrowser().toUpperCase());

        switch (option) {
            case CHROME:
                return new ChromeDriver( BrowserCapabilities.getChromeOptions());
            case FIREFOX:
                return new FirefoxDriver(BrowserCapabilities.getFirefoxOptions());
            case EDGE:
                return new EdgeDriver(BrowserCapabilities.getEdgeOptions());
            case SAFARI:
                return new SafariDriver(BrowserCapabilities.getSafariOptions());
            //case IOS: return new SafariDriver(BrowserCapabilities.getSafariOptionsIos());
            //case ANDROID:
            default:
                throw new RuntimeException("Not supported");
        }

    }
}
