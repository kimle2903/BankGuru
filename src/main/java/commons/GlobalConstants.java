package commons;

import java.io.File;

public class GlobalConstants {
	public static long LONG_TIMEOUT = 40;
	public static long SHORT_TIMEOUT = 15;

	public static String PROJECT_PATH = System.getProperty("user.dir");
	public static String OS_NAME = System.getProperty("os.name");
	public static String JAVA_VERSION = System.getProperty("java.version");
	public static String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static String USER_PAGE_URL = "https://demo.guru99.com/";
	public static String USER_ADMIN_URL = "https://demo.guru99.com/v4/";

	public static String BROWSER_USERNAME = "kiml_Sd5AOR";
	public static String AUTOMATE_KEY = "pxpXLpkwUXKmA4Bnqrvt";
	public static String BROWSER_STACK_URL = "https://" + BROWSER_USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
}
