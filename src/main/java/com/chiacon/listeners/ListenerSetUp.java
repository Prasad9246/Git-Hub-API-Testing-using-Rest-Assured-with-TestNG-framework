package com.chiacon.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import reports.ExtentLoggerReport;
import reports.ExtentReportM;

public class ListenerSetUp implements ITestListener {

	public void onTestStart(ITestResult result) {
		ExtentReportM.createTest("Test Name :"+result.getTestClass().getName()+" - "+result.getMethod().getMethodName());
	}

	public void onStart(ITestContext context) {
		ExtentReportM.initReports();
	}

	public void onFinish(ITestContext context) {
		ExtentReportM.flushReport();
	}

	public void onTestSuccess(ITestResult result) {
		ExtentLoggerReport.logPassDetails(result.getMethod().getMethodName()+" is Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		ExtentLoggerReport.logFailDetails(result.getMethod().getMethodName()+" is Failed");
	}

}
