package com.company.Infrastructure.wdm.factory;
import com.company.Infrastructure.config.ConfigurationManager;
import com.company.Infrastructure.wdm.capabilities.BrowserCapabilities;
import com.company.Infrastructure.wdm.enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteWebDriverFactory implements WebDriverFactory {

    @Override
    public WebDriver create() {
        BrowserType option = BrowserType.valueOf( ConfigurationManager.getInstance().getTestBrowser().toUpperCase());
        DesiredCapabilities caps = new DesiredCapabilities();

        switch (option) {
            case CHROME: {
                caps.merge( BrowserCapabilities.getChromeOptions());
                break;
            }
            case FIREFOX: {
                caps.merge(BrowserCapabilities.getFirefoxOptions());
                break;
            }
            case EDGE: {
                caps.merge(BrowserCapabilities.getEdgeOptions());
                break;
            }
            case SAFARI: {
                caps.merge(BrowserCapabilities.getSafariOptions());
                break;
            }
            default:
                throw new RuntimeException("Not supported");
        }
        try {
            return new RemoteWebDriver (new URL (ConfigurationManager.remoteAdress), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
