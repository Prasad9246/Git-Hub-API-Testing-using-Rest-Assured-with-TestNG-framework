package com.chiacon.readProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.chiacon.constants.FrameworkConstant;

public class ReadProperties {
	public static Properties prop = new Properties();

	private ReadProperties() {
	}

	public static Properties readPropertyFile() {
		try (FileInputStream fis = new FileInputStream(FrameworkConstant.getConfigPath())) {
			prop.load(fis);
		} catch (IOException e) {
			throw new RuntimeException(
					"Error reading or loading config.properties file: " + FrameworkConstant.getConfigPath(), e);
		}
		return prop;
	}


}
