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
        R.CONFIG.put("capabilities.platformName", "Android");
        R.CONFIG.put("capabilities.deviceName", "nightwatch-android-11"); // Replace "emulator-5554" with the name of your emulated device
        R.CONFIG.put("capabilities.appium:address", "10.35.11.208"); // Specify the IP address of the machine running the Appium server
        R.CONFIG.put("capabilities.appium:port", "4723"); // Specify the port of the Appium server
        R.CONFIG.put("capabilities.app", "https://github.com/appium/java-client/raw/master/src/test/resources/apps/ApiDemos-debug.apk");
        R.CONFIG.put("capabilities.appActivity", ".view.DragAndDropDemo");
        R.CONFIG.put("capabilities.automationName", "UiAutomator2");


        

        DragAndDropPage dragAndDropPage = new DragAndDropPage(getDriver());
        dragAndDropPage.dragDown();
        dragAndDropPage.dragRight();
        dragAndDropPage.dragDiagonal();
        Assert.assertTrue(dragAndDropPage.isDragAndDropMessagePresent(), "Should be provided pop up message after successful drag and drop");
    }




}
