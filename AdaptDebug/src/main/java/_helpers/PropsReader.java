package _helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropsReader {
	
	
	protected Properties prop = null;

	public PropsReader(String fileName) {
		InputStream input = PropsReader.class.getClassLoader().getResourceAsStream(fileName);
		prop = new Properties();
		try {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getContactEmail() {
		return prop.getProperty("contact_email");
	}
		

	public String getUrl() {
		return prop.getProperty("url");
	}

	public String getUserName() {
		return prop.getProperty("user_name");
	}

	public String getUserPassword() {
		return prop.getProperty("user_pwd");
	}

	public String dely() {
		return prop.getProperty("delay");
	}

	public String getEmail() {
		return prop.getProperty("Email");
	}

	public String getBrowser() {
		return prop.getProperty("browser");
	}

	public String getRemoteHost() {
		return prop.getProperty("RemoteHost");
	}

	public String getChromeProfile() {
		return prop.getProperty("ChromeProfile");
	}

	public String getFireFoxDriverPath() {
		return prop.getProperty("driverPath");
	}
	
	
	
	/*====================================
	* Getters
	======================================*/
	
	
	public String getProperty (String property ) {
		return prop.getProperty(property);
	}
	
	public int getIntProperty(String paramName) {
		return Integer.parseInt(prop.getProperty(paramName));
	}
	
	/*====================================
	* Setters
	======================================*/
	
/**
 * 
 * @param property
 * @param value
 * @param savedFileName
 * @throws IOException 
 */
//	public void setValue (String property, String value, String savedFileName) throws IOException {
//		
//		FileOutputStream fr = new FileOutputStream (savedFileName);
//		prop.setProperty (fr, property + "=" + value);
//		prop.store(fr, null);
//		fr.close();
//	}
	
	public void setProperty(String fileName, String property, String value, String comment) {
		File file = new File(fileName);
		Properties prop = new Properties();
		try (InputStream in = new FileInputStream(file)) {
			prop.load(in);
			prop.setProperty(property, value);
			OutputStream out = new FileOutputStream(file);
			prop.store(out, comment);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
