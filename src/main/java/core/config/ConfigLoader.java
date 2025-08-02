package core.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

	private static Properties properties = new Properties();

	static {
		try {
			FileInputStream fis = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fis);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load config file", e);
		}
	}

	public static String get(String key) {
		return properties.getProperty(key);
	}

}
