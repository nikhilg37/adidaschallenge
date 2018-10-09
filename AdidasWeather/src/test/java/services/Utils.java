package services;
import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utils {
	public static String WEATHERURL;
	public static String APP_ID;
	 static {
		System.out.println("testing");
		File file = new File("TestData.properties");

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();

		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		WEATHERURL =(String) prop.get("WeatherURL");
		APP_ID =(String) prop.get("AppID");
		
	}
}
