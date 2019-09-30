package com.company.mobile.WordPressApp.iOS;


import com.company.mobile.WordPressApp.LoginScreen;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IosLoginScreen implements LoginScreen {

    private AppiumDriver driver;

    private WebDriverWait wait;

    public IosLoginScreen(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait (driver,60); {
        }
    }

    @Override
    public void enterEmail (String email) {
        wait.until ( ExpectedConditions.presenceOfElementLocated ( By.id("Login Email Address") ) );

        driver.findElement ( By.id("Login Email Address")).click ();
        driver.findElement ( By.id("Login Email Address")).sendKeys ( email );

    }

    @Override
    public void clickNextButton() {
        wait.until ( ExpectedConditions.presenceOfElementLocated ( By.id("Login Email Next Button") ) );
        driver.findElement ( By.id ( "Login Email Next Button" ) ).click ();

    }

    @Override
    public String getErrorMessage() {
        wait.until ( ExpectedConditions.presenceOfElementLocated ( By.id("This email address is not registered on WordPress.com.") ) );
        String errorMessage = driver.findElement ( By.id ("This email address is not registered on WordPress.com."  ) ).getText ();
        return errorMessage;

    }
}
