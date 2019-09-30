package com.company.mobile.WordPressApp;
import com.company.Infrastructure.config.ConfigurationManager;
import com.company.Infrastructure.wdm.capabilities.PlatformCapabilities;
import com.company.mobile.WordPressApp.android.AndroidWordPressApp;
import com.company.mobile.WordPressApp.iOS.IosWordPressApp;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class WordPressLoginTests {


    @Test
    public void testIncorrectEmail () throws InterruptedException, MalformedURLException {

        System.out.println ("Start applications");
        WordPressApp app = getMobileApp ();



        System.out.println ("Click login button");
        app.welcomeScreen().clickLoginButton();


        System.out.println ("Enter Email");
        app.loginScreen ().enterEmail ( "igodqa777@gmail.com" );

        System.out.println ("Click Next");
        app.loginScreen ().clickNextButton ();

        System.out.println ("Check Error message");
        app.loginScreen ().getErrorMessage ().contains ( "email address" );
    }

    private WordPressApp getMobileApp () throws MalformedURLException {
        URL url = new URL ( "http://127.0.0.1:4723/wd/hub" );
        WordPressApp app;

        if (ConfigurationManager.getInstance ().getMobilePlatform ().equals ( "iOS" )) {
            IOSDriver driver = new IOSDriver ( url, PlatformCapabilities.iosCapabilities () );
            app = new IosWordPressApp ( driver );

        } else {
            AndroidDriver driver = new AndroidDriver ( url, PlatformCapabilities.androidCapabilities () );
            app = new AndroidWordPressApp ( driver );

        }

        return app;

    }
}


