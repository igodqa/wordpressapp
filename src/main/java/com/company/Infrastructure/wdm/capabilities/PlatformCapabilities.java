package com.company.Infrastructure.wdm.capabilities;

import com.company.Infrastructure.config.ConfigurationManager;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class PlatformCapabilities  {


    public static DesiredCapabilities androidCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability( MobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,ConfigurationManager.getInstance ().getPlatformVersion ());
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigurationManager.getInstance ().getDeviceName ());
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability(MobileCapabilityType.APP,ConfigurationManager.getInstance ().getApp ());
        caps.setCapability( AndroidMobileCapabilityType.APP_ACTIVITY,"org.wordpress.android.ui.WPLaunchActivity");
        caps.setCapability( AndroidMobileCapabilityType.APP_PACKAGE,"org.wordpress.android");
        caps.setCapability(MobileCapabilityType.NO_RESET,true);
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"800");
        return caps;
    }

    public static  DesiredCapabilities iosCapabilities () {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability( MobileCapabilityType.PLATFORM_NAME, "iOS" );
        caps.setCapability( MobileCapabilityType.PLATFORM_VERSION, ConfigurationManager.getInstance ().getPlatformVersion () );
        caps.setCapability( MobileCapabilityType.DEVICE_NAME, ConfigurationManager.getInstance ().getDeviceName () );
        caps.setCapability( MobileCapabilityType.APPLICATION_NAME, "XCUITest" );
        caps.setCapability( MobileCapabilityType.APP, ConfigurationManager.getInstance ().getApp () );
        caps.setCapability( MobileCapabilityType.NEW_COMMAND_TIMEOUT, "700" );
        return caps;

    }

    //    public static DesiredCapabilities window10() {
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("os", "Windows");
//        caps.setCapability("os_version", "10");
//        return caps;
//    }
//
//    public static DesiredCapabilities mojave() {
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("os", "OS X");
//        caps.setCapability("os_version", "Mojave");
//        return caps;
//    }

}
