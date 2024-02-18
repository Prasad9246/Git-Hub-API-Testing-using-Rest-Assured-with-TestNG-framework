package baseTest;

import java.util.Properties;

import org.testng.annotations.BeforeSuite;

import com.chiacon.readProperties.ReadProperties;

public class BaseTest {

	static Properties prop = null;

	@BeforeSuite
	public void loadPropertyFile() {
		prop = ReadProperties.readPropertyFile();
	}

}
