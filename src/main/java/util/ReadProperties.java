package util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ReadProperties {

	String fileName;
	Properties properties;

	public ReadProperties(String fileName) {
		this.fileName = fileName;
	}

	public void loadProperties() {
		properties = new Properties();
		String path = "./src/main/resources/" + fileName + ".properties";
		try {
			properties.load(new FileReader(path));
		} catch (IOException e) {
			throw new RuntimeException("File not available in the specified path: " + path);
		}
	}

	public String getProperty(String propertyName) {
		if(properties==null)		{
			loadProperties();
		}
		return properties.getProperty(propertyName);
	}
}
