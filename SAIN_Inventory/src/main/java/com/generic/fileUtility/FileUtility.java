package com.generic.fileUtility;

/**
 * Contains method to fetch data from the properties file
 * 
 * @author Rajani
 * 
 */
import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	
	/**
	 * Fetches value of the specified key from the properties file
	 * @param key
	 * @return String
	 * @throws Throwable
	 */
	public String getDataFromPropertyFile(String key) throws Throwable {

		FileInputStream fisP = new FileInputStream("./src/main/resources/commonData.properties");
		Properties p = new Properties();
		p.load(fisP);
		String value = p.getProperty(key);
		return value;

	}

}
