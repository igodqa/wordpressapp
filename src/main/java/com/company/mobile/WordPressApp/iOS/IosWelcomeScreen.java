package com.company.mobile.WordPressApp.iOS;
import com.company.mobile.WordPressApp.WelcomeScreen;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IosWelcomeScreen implements WelcomeScreen {


    private AppiumDriver driver;
    private WebDriverWait wait;

    public IosWelcomeScreen(AppiumDriver driver) {
        this.driver = driver;
        wait =  new WebDriverWait (driver,30);
    }

    @Override
    public void clickLoginButton() {
        driver.findElement ( By.id ( "Prologue Log In Button" )).click ();
        wait.until ( ExpectedConditions.presenceOfElementLocated ( By.id("Log in with Email Button") ) );
        driver.findElement ( By.id("Log in with Email Button" )).click();


    }
}
