package com.company.mobile.WordPressApp.android;
import com.company.mobile.WordPressApp.LoginScreen;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AndroidLoginScreen implements LoginScreen {

    private AppiumDriver driver;
    private WebDriverWait wait;

    public AndroidLoginScreen(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait (driver,60); {
        }
    }

    @Override
    public void enterEmail (String email) {
        wait.until ( ExpectedConditions.presenceOfElementLocated ( By.id("org.wordpress.android:id/input") ) );

        driver.findElement ( By.id("org.wordpress.android:id/input")).click ();
        driver.findElement ( By.id("org.wordpress.android:id/input")).sendKeys ( email );

    }

    @Override
    public void clickNextButton() {
        wait.until ( ExpectedConditions.presenceOfElementLocated ( By.id("org.wordpress.android:id/primary_button") ) );
        driver.findElement ( By.id ( "org.wordpress.android:id/primary_button" ) ).click ();

    }

    @Override
    public String getErrorMessage() {
        String errorMessage = driver.findElement ( By.id ("org.wordpress.android:id/textinput_error"  ) ).getText ();
        return errorMessage;
    }
}
