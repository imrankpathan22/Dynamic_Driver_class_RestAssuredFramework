package test_pkg;

import java.io.IOException;

import java.time.LocalDate;

import org.testng.Assert;

import commonFunction.common_class;
import commonFunction.utility_common_function;
import io.restassured.path.json.JsonPath;
import req_repository.req_rep_class;
public class test_class1 {
public static void execute() throws IOException {
	for (int i=0; i<5; i++) //retry method
	{
		String baseURI= req_rep_class.Base_URI();
		String resource=req_rep_class.post_resource();
		String requestBody=req_rep_class.post_req2();
		int statusCode=common_class.res_status_code(baseURI, resource, requestBody);
		if (statusCode==201) {
			String responsebody=common_class.res_responsebody(baseURI, resource, requestBody);
			System.out.println(responsebody);
			test_class1.validator(responsebody, requestBody);
			utility_common_function.EvidenceCreator("test_class1", responsebody, requestBody);
			break;
		}
		else {
			System.out.println("corretc status code not found hence retrying ");
		}}}
public static void validator(String responsebody,String requestBody) 
 {
		// step 5 parse the response body
			JsonPath jspresponse=new JsonPath(responsebody);
			String res_name=jspresponse.getString("name");
			String res_job=jspresponse.getString("job");
			String res_id=jspresponse.getString("id");
			String res_createdAt=jspresponse.getString("createdAt");
			
			JsonPath jsprequest= new JsonPath(requestBody);
			   String req_name = jsprequest.getString("name");
			   String req_job =jsprequest.getString("job");
			   
			// step6 validation
			Assert.assertEquals(res_name, req_name);
			Assert.assertEquals(res_job, req_job);
			Assert.assertNotNull(res_id);
			//date
			String actualdate=res_createdAt.substring(0,10);
			String currentdate=LocalDate.now().toString();
			Assert.assertEquals(actualdate, currentdate);
			   }
	}

