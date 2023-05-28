package commonFunction;

 import io.restassured.RestAssured;
  import static io.restassured.RestAssured.given;
 public class common_class {

	public static int res_status_code(String Base_URI,String post_resource,String post_requestbody) {
		RestAssured.baseURI=Base_URI;
		int Status_code=given().header("Content-Type","application/json").body(post_requestbody).when().post(post_resource).then().extract().statusCode();
		
		return Status_code; 
		
		
	}
	public static String res_responsebody(String Base_URI,String post_resource,String post_requestbody) {
		RestAssured.baseURI=Base_URI;
		String responsebody=given().header("Content-Type","application/json").body(post_requestbody).when().post(post_resource).then().extract().asString();
		
		return responsebody;
		
	}
	
	
}
