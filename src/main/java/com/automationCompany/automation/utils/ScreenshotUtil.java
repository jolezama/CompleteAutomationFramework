package com.automationCompany.automation.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String name) {

        String screenshotsDir =
                ExtentManager.getReportDir() + "/screenshots/";

        String fullPath = screenshotsDir + name + ".png";

        try {
            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(fullPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "screenshots/" + name + ".png";
    }

}
