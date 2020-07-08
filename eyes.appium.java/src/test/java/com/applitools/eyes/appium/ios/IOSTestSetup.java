package com.applitools.eyes.appium.ios;

import com.applitools.eyes.appium.TestSetup;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class IOSTestSetup extends TestSetup {

    @Override
    protected void setCapabilities() {
        super.setCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 8");
        capabilities.setCapability("os_version", "13.3");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("newCommandTimeout", 300);
        setResetMode();
    }

    @Override
    protected void initDriver() throws MalformedURLException {
        driver = new IOSDriver<>(new URL(appiumServerUrl), capabilities);
    }

    @Override
    protected void setAppCapability() {
        // TODO: upload https://applitools.bintray.com/Examples/IOSTestApp/1.1/IOSTestApp-1.1.zip on runtime in travis.yml
        capabilities.setCapability("app", "bs://a55cc1555d1bf6c0b464e2b1fa37cd8c96dcb953");
    }

    protected void setResetMode() {
        capabilities.setCapability("fullReset", true);
    }

    @Override
    protected String getApplicationName() {
        return "Java Appium - IOS";
    }
}
