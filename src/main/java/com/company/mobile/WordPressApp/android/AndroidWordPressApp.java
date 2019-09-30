package com.company.mobile.WordPressApp.android;
import com.company.mobile.WordPressApp.LoginScreen;
import com.company.mobile.WordPressApp.WelcomeScreen;
import com.company.mobile.WordPressApp.WordPressApp;
import io.appium.java_client.AppiumDriver;

public class AndroidWordPressApp implements WordPressApp {

    private AppiumDriver driver;

    public AndroidWordPressApp(AppiumDriver driver) {
        this.driver = driver;
    }

    @Override
    public WelcomeScreen welcomeScreen() {
        return new AndroidWelcomeScreen ( driver );
    }

    @Override
    public LoginScreen loginScreen() {
        return new AndroidLoginScreen(driver);
    }
}


