package restAPI;



import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC02_Post {

	@SuppressWarnings("unchecked")
	@Test
	public void TC01_Post_New_Data() {
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type","application/json");
		
		JSONObject json = new JSONObject();
		json.put("id", "5");
		json.put("title", "Selenium WebDriver");
		
		request.body(json.toJSONString());
		Response response = request.post("https://my-json-server.typicode.com/tavantrong/restAssuredFramework/posts/");
		
		int code = response.getStatusCode();
		System.out.println("Post data response code is: " + code);
		Assert.assertEquals(code, 201);
	}

}
