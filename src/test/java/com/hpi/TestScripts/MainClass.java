package com.hpi.TestScripts;

import org.testng.TestNG;

public class MainClass {

	public static void main(String[] args) {
		TestNG testng = new TestNG();
		Class[] classes = new Class[]{Verify_ServiceCenter_AutomationFlow.class};
		testng.setTestClasses(classes);
		testng.run();
	}

}
