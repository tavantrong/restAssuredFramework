package restAPI;



import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC02_Put {

	@SuppressWarnings("unchecked")
	@Test
	public void TC01_Post_New_Data() {
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type","application/json");
		
		JSONObject json = new JSONObject();
		json.put("id", "1");
		json.put("title", "Selenium WebDriver");
		
		request.body(json.toJSONString());
		Response response = request.put("https://my-json-server.typicode.com/tavantrong/restAssuredFramework/posts/1");
		
		int code = response.getStatusCode();
		System.out.println("Update data response code is: " + code);
		Assert.assertEquals(code, 200);
	}

}
