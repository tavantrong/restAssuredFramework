package getRequest;





import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC01_GetData_Example {

	
	@Test
	public void TC01_Test_ResponseCode() {
		Response resp = RestAssured.get("https://my-json-server.typicode.com/tavantrong/restAssuredFramework/posts");
		int code = resp.getStatusCode();
		System.out.println("Status code is: " + code);
		
		Assert.assertEquals(code, 200);
	}
	
	@Test
	public void TC02_Test_Body() {
		Response resp = RestAssured.get("https://my-json-server.typicode.com/tavantrong/restAssuredFramework/posts/1");
		String data = resp.asString();
		
		System.out.println("Data is: " + data);
		System.out.println("Response time is: " + resp.getTime());
	}
	
	
}
