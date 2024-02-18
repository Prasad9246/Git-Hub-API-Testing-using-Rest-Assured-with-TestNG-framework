package reports;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentLoggerReport {

	public static void logPassDetails(String log) {
		ExtentManagerReport.getExtentTest().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
	}

	public static void logFailDetails(String log) {
		ExtentManagerReport.getExtentTest().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
	}

	public static void logInfoDetails(String log) {
		ExtentManagerReport.getExtentTest().info(MarkupHelper.createLabel(log, ExtentColor.GREY));
	}

}
