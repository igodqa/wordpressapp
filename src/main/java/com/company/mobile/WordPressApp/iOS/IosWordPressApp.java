package com.company.mobile.WordPressApp.iOS;
import com.company.mobile.WordPressApp.LoginScreen;
import com.company.mobile.WordPressApp.WelcomeScreen;
import com.company.mobile.WordPressApp.WordPressApp;
import io.appium.java_client.AppiumDriver;

public class IosWordPressApp implements WordPressApp {

    private AppiumDriver driver;

    public IosWordPressApp(AppiumDriver driver) {
        this.driver = driver;
    }

    @Override
    public WelcomeScreen welcomeScreen() {
        return new IosWelcomeScreen ( driver );
    }

    @Override
    public LoginScreen loginScreen() {
        return new IosLoginScreen ( driver );
    }
}


