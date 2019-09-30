package com.company.Infrastructure.wdm.capabilities;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

public class BrowserCapabilities {

    public static ChromeOptions getChromeOptions() {
       ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type", "start-maximized", "disable-popup-blocking", "disable-infobars");
        return options;
    }

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.setLogLevel(FirefoxDriverLogLevel.FATAL);
        return options;
    }

    public static EdgeOptions getEdgeOptions() {
        return new EdgeOptions();
    }

    public static SafariOptions getSafariOptions() {
        SafariOptions options = new SafariOptions();
        options.setCapability("cleanSession", true);
        return options;
    }




}
