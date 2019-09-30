package com.company.Infrastructure.wdm.factory;

// где будут запускаться тесты, облако, локалка, удаленно...

import org.openqa.selenium.WebDriver;

public interface WebDriverFactory {
    WebDriver create();
}
