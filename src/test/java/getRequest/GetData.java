package getRequest;





import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetData {

	
	@Test
	public void TC01_Test_ResponseCode() {
		Response resp = RestAssured.get("https://api.openweathermap.org/data/2.5/weather?q=London,uk&callback=test&appid=df8ecb31a4b9a69404847aa61bd6c55c");
		int code = resp.getStatusCode();
		System.out.println("Status code is: " + code);
		
		Assert.assertEquals(code, 200);
	}
	
	@Test
	public void TC02_Test_Body() {
		Response resp = RestAssured.get("https://api.openweathermap.org/data/2.5/weather?q=London,uk&callback=test&appid=df8ecb31a4b9a69404847aa61bd6c55c");
		String data = resp.asString();
		
		System.out.println("Data is: " + data);
		System.out.println("Response time is: " + resp.getTime());
	}
	
	
}
