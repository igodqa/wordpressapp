package com.company.Infrastructure.base;
import com.company.Infrastructure.config.ConfigurationManager;
import com.company.Infrastructure.logger.FileTestLogger;
import com.company.Infrastructure.logger.StdTestLogger;
import com.company.Infrastructure.logger.TestLogger;
import com.company.Infrastructure.wdm.DefaultWebDriverManager;
import com.company.Infrastructure.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;



//тесты по созданию и закрытия браузера
public abstract class TestBase {
    protected static TestLogger logger;
    private static WebDriverManager wdm; // browser он нужен только 2 раз и поэтому приватный
    protected static WebDriver browser;

    @Before
    public void setUp() {
        logger = getLogger();
        wdm = new DefaultWebDriverManager (); // вернет нам веб-драйвер

        logger.log("Start Browser");
        browser = wdm.getWebDriver();
        System.out.println("--> Starting " + browser);

        //beforeTest();
    }

    @AfterClass
    public static void tearDown() {
        afterTest();
        logger.log("Close browser ");
        wdm.destroyWebDriver(browser);

    }

    protected void beforeTest() throws MalformedURLException { }

    protected static void afterTest() {browser.quit ();}



    private TestLogger getLogger() {
        return ConfigurationManager.getInstance().getLoggerType().equals("std") ?
                new StdTestLogger () : new FileTestLogger ();
    }
}
