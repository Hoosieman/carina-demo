package com.zebrunner.carina.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.mobile.gui.pages.android.DragAndDropPage;
import com.zebrunner.carina.utils.R;

public class MobileDragAndDropTest implements IAbstractTest {



    






    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"mobile", "acceptance"})
    public void testDragAndDrop() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android"); //optional
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
        //options.setCapability("udid", "9889a4315133493650"); //CHANGE THE UDID BASED ON DEVICE, MAY NOT BE REQUIRED. S/N ENDS in 6T
        options.setDeviceName("amuthan-test-device");
        options.setApp(System.getProperty("user.dir") + "/apps/Android-MyDemoAppRN.1.3.0.build-244.apk"); //replace with BYUtv apk

        @SuppressWarnings("deprecation") //ADDED TO SUPPORT USB TESTING
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.findElement(AppiumBy.accessibilityId("open menu")).click();
        /*new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(e->e.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item log in\"]")));
 */
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item log in\"]"))
            .click();
        Thread.sleep(5000);
        driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("BYU BROADCASTING");
        driver.quit();
    }




}
