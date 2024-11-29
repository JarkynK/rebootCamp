package mobil_testing;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDema {



    public static AppiumDriverLocalService appiumDriverLocalService;
    public static AndroidDriver androidDriver;


    @Before
    public void setUp() throws MalformedURLException {


        appiumDriverLocalService = AppiumDriverLocalService.buildDefaultService();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        appiumDriverLocalService.start();

        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_XL_API_29");
        desiredCapabilities.setCapability("avd", "Pixel_XL_API_29");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability("appPackage", "com.google.android.apps.maps");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability("appActivity", "com.google.android.maps.MapsActivity");

        desiredCapabilities.setCapability("autoGrantPermissions", true);
        desiredCapabilities.setCapability("autoAcceptAlerts", true);
        desiredCapabilities.setCapability("newCommandTimeout", 60000);
        desiredCapabilities.setCapability("noReset", true);
        try {
            androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        androidDriver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);

//        //set default service
//        appiumDriverLocalService = AppiumDriverLocalService.buildDefaultService();
//
//        //initiating desired capabilities
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setCapability("appPackage", "com.google.android.apps.maps");
//        desiredCapabilities.setCapability("automationName", "UiAutomator2");
//        desiredCapabilities.setCapability("platformName","Android");
//        desiredCapabilities.setCapability("platformVersion", "10");
//        desiredCapabilities.setCapability("deviceName","Pixel");
//        desiredCapabilities.setCapability("appActivity","com.google.android.maps.MapsActivity");
//
//        desiredCapabilities.setCapability("autoGrantPermissions",true);
//        desiredCapabilities.setCapability("autoAcceptAlerts",true);
//        desiredCapabilities.setCapability("newCommandTimeout","60000"); // when you are going to debug something,is gonna increa
//
//        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
    }

    @Test
    public void test(){
        System.out.println ("Launching appium emulator");
        androidDriver.findElement (By.xpath ("//[*text='SKIP']"));
        androidDriver.findElement (By.xpath ("//*[content-desc='Menu']"));
    }

    @After
    public void tearDown(){
        androidDriver.quit();
        appiumDriverLocalService.stop();
    }
}