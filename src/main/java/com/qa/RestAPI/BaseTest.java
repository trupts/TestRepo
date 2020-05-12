package com.qa.RestAPI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {
	
	public Properties prop ;
	
	
	public BaseTest() throws IOException
	{
		prop = new Properties();
		InputStream input = new FileInputStream("E://Selenium Workspace//selenium_tk//RestAPITest//src//main//java//com//qa//config//config.properties");
		prop.load(input);
		System.out.println("Proerty File is loaded");
		System.out.println(prop.getProperty("URL"));
        System.out.println(prop.getProperty("apiurl"));
        System.out.println(prop.getProperty("searchautosuggestAPI"));
        
        
	}
	
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BaseTest b= new BaseTest();
		

	}

}
