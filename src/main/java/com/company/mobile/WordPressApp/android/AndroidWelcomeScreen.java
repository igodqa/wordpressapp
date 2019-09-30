package com.company.mobile.WordPressApp.android;

import com.company.mobile.WordPressApp.WelcomeScreen;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AndroidWelcomeScreen implements WelcomeScreen {


    private AppiumDriver driver;
    private WebDriverWait wait;

    public AndroidWelcomeScreen(AppiumDriver driver) {
        this.driver = driver;
        wait =  new WebDriverWait (driver,30);
    }

    @Override
    public void clickLoginButton() {
        driver.findElement ( By.id ( "org.wordpress.android:id/login_button" )).click ();
    }
}
