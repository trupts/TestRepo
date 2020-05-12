package com.qa.RestClient;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.qa.RestAPI.BaseTest;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

public class RestClient {

	
	public String GetAPI(String Request) throws ClientProtocolException, IOException
	{
		//Request = "https://uat2.tataunistore.com/marketplacewebservices/v2/mpl/searchAndSuggest?searchString=sams&category=all";
	CloseableHttpClient httpClient = HttpClients.createDefault();
	HttpGet httpGet = new HttpGet(Request);  //"https://uat2.tataunistore.com/marketplacewebservices/v2/mpl/searchAndSuggest?searchString=sams&category=all");
	CloseableHttpResponse httpResponse= httpClient.execute(httpGet);
	System.out.println(httpResponse.getStatusLine().getStatusCode());
	
	//use entity utils to get the response in string 
	 String ResponseinString = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
	 System.out.println("Priniting Response in String"+ ResponseinString);
	
	 // header 
	 Header[] ResponseHeaders = httpResponse.getAllHeaders();
	
	 System.out.println("Printing Header");
	 //store header in hash map 
	 //System.out.println("Header Length" + ResponseHeaders.length);
	// System.out.println("First in Header " + ResponseHeaders[0]);
	 HashMap<String,String> allHeader= new HashMap<String,String>();
	 for (Header r :ResponseHeaders)
	 {
	   allHeader.put(r.getName(),r.getValue());	 
   
	 }
	 System.out.println(allHeader);
     httpClient.close();
     return ResponseinString;
	}
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		RestClient b= new RestClient();
	   // b.GetAPI("td");
	}
	
}
