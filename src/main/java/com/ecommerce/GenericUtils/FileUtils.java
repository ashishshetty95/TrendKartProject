package com.ecommerce.GenericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {
	/**
	 * This method is used to read the data from Property File
	 * @author Ashish Shetty
	 * @param key
	 * @return String
	 * @throws IOException 
	 */
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream(iPathConstants.PROPERTYFILEPATH);
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;
	}
}
