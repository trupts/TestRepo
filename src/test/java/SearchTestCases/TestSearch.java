package SearchTestCases;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.RestAPI.BaseTest;
import com.qa.RestClient.RestClient;

public class TestSearch {
	BaseTest t;
	String URI ;
	String Response ;
	RestClient r;
	
	
	@Test(dataProvider = "data-provider")
  public void SearchText(String SearchText) {
		
		String QueryParameter = "=shirts%3Arelevance%3AinStockFlag%3Atrue&isKeywordRedirect=false&isKeywordRedirectEnabled=true&channel=WEB&isTextSearch=false&isFilter=false&page=0&isPwa=true&pageSize=40&typeID=all";
        String QueryParameter_Final= QueryParameter.replaceAll("shirts",SearchText);
        
		URI = t.prop.getProperty("URL")+t.prop.getProperty("SearchAPI")+QueryParameter_Final;
        //System.out.println("Printing Final QP"+URI);
		try {
			Response = r.GetAPI(URI);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][] { { "jeans"} };
    }
  @BeforeMethod
  
  public void Beforeethod() throws IOException
  {
	  t=new BaseTest();
		//URI= t.prop.getProperty("URL")+t.prop.getProperty("SearchAPI");
		 System.out.println(URI);
		   r= new RestClient();
		  //Response= r.GetAPI(URI);
		   System.out.println("changing for git, pull request testing");
	  
	  
  }
}
