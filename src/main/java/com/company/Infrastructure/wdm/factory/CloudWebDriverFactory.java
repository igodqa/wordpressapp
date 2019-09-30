package com.company.Infrastructure.wdm.factory;

import com.company.Infrastructure.config.ConfigurationManager;
import com.company.Infrastructure.wdm.capabilities.BrowserCapabilities;
import com.company.Infrastructure.wdm.enums.BrowserType;
import com.company.Infrastructure.wdm.enums.CloudService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class CloudWebDriverFactory implements WebDriverFactory {

    @Override
    public WebDriver create() {
        BrowserType option = BrowserType.valueOf( ConfigurationManager.getInstance().getTestBrowser().toUpperCase());
        DesiredCapabilities caps = new DesiredCapabilities();

        switch (option) {
            case CHROME: {
                 caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
                caps.setCapability(CapabilityType.VERSION, "74.0");
                caps.merge( BrowserCapabilities.getChromeOptions());
                break;
            }
            case FIREFOX:{
                caps.setCapability(CapabilityType.BROWSER_NAME, "firefox");
                caps.setCapability(CapabilityType.VERSION, "67");
                caps.merge(BrowserCapabilities.getFirefoxOptions());
                break;
            }
            case EDGE:{
                caps.setCapability(CapabilityType.BROWSER_NAME, "edge");
                caps.setCapability(CapabilityType.VERSION, "17");
                caps.merge(BrowserCapabilities.getEdgeOptions());
                break;
            }
            case SAFARI:{
                caps.setCapability(CapabilityType.BROWSER_NAME, "safari");
                caps.setCapability(CapabilityType.VERSION, "12.0");
                caps.merge(BrowserCapabilities.getSafariOptions());
                break;
            }
            default:
                throw new RuntimeException("Unsupported browser / platform: ");

        }

        CloudService service = CloudService.valueOf(ConfigurationManager.getInstance().getCloudService().toUpperCase());
        String url = "";
        switch (service){
            case SAUCELABS: {
                url = "http://" + ConfigurationManager.getInstance().getSauceLabsUser()
                        + ":" + ConfigurationManager.getInstance().getSauceLabsSecrete()
                        + "@ondemand.eu-central-1.saucelabs.com:80/wd/hub";
                break;}
            case BRAWSERSTACK: {
                url = "http://" + ConfigurationManager.getInstance().getBrowserStackUser()
                        + ":" + ConfigurationManager.getInstance().getBrowserStackSecrete()
                        + "@hub-cloud.browserstack.com/wd/hub";
                break;}
            default:
                throw new RuntimeException("Unknown cloud Service");
        }

        try{
            return new RemoteWebDriver(new URL(url), caps);
            } catch (MalformedURLException e){
                throw new RuntimeException(e);
        }
    }
}
