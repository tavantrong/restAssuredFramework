package restAPI;



import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Delete_PutExample {

	@SuppressWarnings("unchecked")
	@Test
	public void TC01_Post_New_Data() {
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type","application/json");
		
		JSONObject json = new JSONObject();
		json.put("id", "25");
		json.put("title", "Selenium WebDriver");
		json.put("author", "Learn Automation");
		
		request.body(json.toJSONString());
		Response response = request.post("http://localhost:3000/posts");
		
		int code = response.getStatusCode();
		Assert.assertEquals(code, 201);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void TC02_Put_Update_Data() {
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type","application/json");
		
		JSONObject json = new JSONObject();
		json.put("id", "25");
		json.put("title", "Selenium WebDriver");
		json.put("author", "Update Newdata");
		
		request.body(json.toJSONString());
		Response response = request.put("http://localhost:3000/posts/25");
		
		int code = response.getStatusCode();
		System.out.println("Update data response code is: " + code);
		Assert.assertEquals(code, 200);
	}
	
	@Test
	public void TC03_Delete_Data() {
		RequestSpecification request = RestAssured.given();
		
		Response response = request.delete("http://localhost:3000/posts/25");
		
		int code = response.getStatusCode();
		System.out.println("Delete data response code is: " + code);
		Assert.assertEquals(code, 200);
	}
}
