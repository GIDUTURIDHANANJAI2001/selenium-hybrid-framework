package utilities;

import org.openqa.selenium.*;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName){

        try{

            File src =
                    ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            String path = "screenshots/" + testName + ".png";

            File dest = new File(path);

            FileUtils.copyFile(src,dest);

            return path;

        }

        catch(Exception e){

            e.printStackTrace();

            return null;

        }

    }

}