package SearchTestCases;

import org.testng.annotations.Test;

import com.qa.RestAPI.BaseTest;
import com.qa.RestClient.RestClient;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;

public class TestAutosugestion {
	
	BaseTest t;
	String URI ;
	String Response ;
	RestClient r;
	
  @Test
  public void VerifyAutosugesstionResult() throws IOException {
		
        
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  
	  t=new BaseTest();
	  URI= t.prop.getProperty("URL")+t.prop.getProperty("searchautosuggestAPI");
	  System.out.println(URI);
	  r= new RestClient();
	  Response= r.GetAPI(URI);
	  
  }	  
}
