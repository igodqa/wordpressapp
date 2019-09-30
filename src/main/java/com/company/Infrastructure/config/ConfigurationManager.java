package com.company.Infrastructure.config;


public class ConfigurationManager {

    private static final String testBrowser = "testBrowser";
    private static final String testEnv = "testEnv";
    public static String remoteAdress;
    private static ConfigurationManager instance;
    private static final String runOn = "runOn";
    private static final String mobilePlatform = "mobilePlatform";
    private static final String platformVersion = "platformVersion";
    private static final String deviceName = "platformVersion";
    private static final String app = "platformVersion";



    private static final String loggerType = "loggerType";


    private ConfigurationManager() { }

    public static ConfigurationManager getInstance() {
        if (instance == null)
            instance = new ConfigurationManager();
        return instance;
    }

    public String getTestBrowser () {
        return getEnvVarOrDefault(testBrowser, "CHROME");
    }

    public  String getTestEnv() {
        return getEnvVarOrDefault(testEnv, "production");
    }

    public String getRunOn() {return getEnvVarOrDefault(runOn, "local"); }

    public String getMobilePlatform() { return getEnvVarOrDefault(mobilePlatform,"iOS");  }

    public String getPlatformVersion() { return getEnvVarOrDefault(platformVersion,"12.1");  }

    public String getDeviceName() { return getEnvVarOrDefault(deviceName,"iPhone X");  }

    public String getApp() { return getEnvVarOrDefault(app,"/Users/sergejonishchuk/Downloads/WordPress.app");  }





    private String getEnvVarOrDefault (String  envVarName, String defaultValue) {
        return System.getenv(envVarName) != null ? System.getenv(envVarName) : defaultValue ;

    }

    public Object getLoggerType() {return getEnvVarOrDefault(loggerType,"std");
    }

    public String getCloudService() {return null;
    }

    public String getSauceLabsUser() { return null;
    }

    public String getSauceLabsSecrete() {
        return null;
    }

    public String getBrowserStackUser() {
        return null;
    }

    public String getBrowserStackSecrete() {
        return null;
    }
}
