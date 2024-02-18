package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.chiacon.constants.FrameworkConstant;

public class ExtentReportM {

	private static ExtentReports extent;
	private static ExtentTest extentTest;

	private ExtentReportM() {
	}

	public static void initReports() {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstant.getReportPath());
		spark.config().setReportName("Test API Automation Report");
		spark.config().setDocumentTitle("Test Execution Report");
		spark.config().setTheme(Theme.DARK);
		spark.config().setEncoding("utf-8");
		extent.attachReporter(spark);
	}

	public static void flushReport() {
		extent.flush();
	}

	public static void createTest(String testCaseName) {
		extentTest = extent.createTest(testCaseName);
		ExtentManagerReport.setExtentTest(extentTest);
	}

}
