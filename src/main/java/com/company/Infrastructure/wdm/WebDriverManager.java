package com.company.Infrastructure.wdm;

// Управляет браузерами, запускает и закрывает

import org.openqa.selenium.WebDriver;


public interface WebDriverManager {

    WebDriver getWebDriver();
    void destroyWebDriver(WebDriver webDriver);
}
