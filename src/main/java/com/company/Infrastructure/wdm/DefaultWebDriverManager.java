package com.company.Infrastructure.wdm;

import com.company.Infrastructure.config.ConfigurationManager;
import com.company.Infrastructure.wdm.enums.RunOn;
import com.company.Infrastructure.wdm.factory.CloudWebDriverFactory;
import com.company.Infrastructure.wdm.factory.LocalWebDriverFactory;
import com.company.Infrastructure.wdm.factory.RemoteWebDriverFactory;
import com.company.Infrastructure.wdm.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class DefaultWebDriverManager implements WebDriverManager {
    @Override
    public WebDriver getWebDriver(){
        RunOn runOn = RunOn.valueOf(
                ConfigurationManager.getInstance().getRunOn().toUpperCase());

        WebDriverFactory factory;
        switch (runOn) {   //решаем, где запускать(локально, в облаке...) а уже потом какой браузер
            case LOCAL: {
                factory = new LocalWebDriverFactory ();
                break;
            }
            case REMOTE: {
                factory = new RemoteWebDriverFactory ();
                break;
            }
            case CLOUD: {
                factory = new CloudWebDriverFactory ();
                break;
            }
            default: {
                throw new RuntimeException("Not supported");
            }
        }

        return factory.create();
    }

    @Override
    public void destroyWebDriver(WebDriver webDriver) {

        if (webDriver != null) {
            System.out.println("-->Closing browser " + webDriver);
            webDriver.quit();
        }
    }
}
