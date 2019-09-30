package com.company.Infrastructure.utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class SeleniumUtils {
    private String parentWindow = "";
    private WebDriver webDriver;

    public SeleniumUtils(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void switchToWindow(String windowTitle) {
        parentWindow = webDriver.getWindowHandle();
        Set<String> windows = webDriver.getWindowHandles();
        if (windows.size() > 2) {
            throw new RuntimeException("New window was not opened");
        }
        for (String winHandle : windows) {
            webDriver.switchTo().window(winHandle);
            if (webDriver.getTitle().equals(windowTitle)) {
                break;
            }
        }
    }

    public void switchToParent() {
        if (!parentWindow.isEmpty()) {
            webDriver.switchTo().window(parentWindow);
        }
    }

    public void closeAllExtraTabs() {
        for (String winHandle : webDriver.getWindowHandles()) {
            if (!winHandle.equals(parentWindow)) {
                webDriver.switchTo().window(winHandle).close();
            }
        }
        switchToParent();
    }

}
