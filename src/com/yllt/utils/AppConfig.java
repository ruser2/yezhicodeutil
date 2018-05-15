package com.yllt.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {

	private static Properties properties ;
	
	static {
		InputStream inputStream = AppConfig.class.getClassLoader()
				.getResourceAsStream("system.properties");
		properties = new Properties();
		try {
			properties.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static Properties getProperties() {
		return properties;
	}
}
