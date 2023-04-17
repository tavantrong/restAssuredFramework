package restAPI;



import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC02_Delete {

	@Test
	public void TC03_Delete_Data() {
		RequestSpecification request = RestAssured.given();
		
		Response response = request.delete("https://my-json-server.typicode.com/tavantrong/restAssuredFramework/posts/1");
		
		int code = response.getStatusCode();
		System.out.println("Delete data response code is: " + code);
		Assert.assertEquals(code, 200);
	}

}
