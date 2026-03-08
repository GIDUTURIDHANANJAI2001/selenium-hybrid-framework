package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtent(){

        if(extent == null){

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("reports/AutomationReport.html");

            spark.config().setDocumentTitle("Automation Report");

            spark.config().setReportName("OrangeHRM Test Execution");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo("Framework","Selenium Hybrid");

            extent.setSystemInfo("Tester","Apex");

        }

        return extent;

    }

}