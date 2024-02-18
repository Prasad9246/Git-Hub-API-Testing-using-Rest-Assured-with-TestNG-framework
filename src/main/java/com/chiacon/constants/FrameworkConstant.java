package com.chiacon.constants;

public class FrameworkConstant {
	private FrameworkConstant() {
	}

	private static final String REPORT_PATH = System.getProperty("user.dir") + "/src/test/resources/report/index_"
			+ System.currentTimeMillis() + ".html";

	private static final String CONFIG_FILE_PATH = System.getProperty("user.dir")
			+ "/src/test/resources/config/config.properties";

	private static final String POST_BODY = System.getProperty("user.dir")
			+ "/src/test/resources/jsonBody/postBody.json";
	private static final String PATCH_BODY = System.getProperty("user.dir")
			+ "/src/test/resources/jsonBody/patchBody.json";

	public static String getConfigPath() {
		return CONFIG_FILE_PATH;
	}

	public static String getPostBodyFilePath() {
		return POST_BODY;
	}

	public static String getPatchBodyFilePath() {
		return PATCH_BODY;
	}

	public static String getReportPath() {
		return REPORT_PATH;
	}
}
