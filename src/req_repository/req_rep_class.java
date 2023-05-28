package req_repository;

import java.io.IOException;
import java.util.ArrayList;

import commonFunction.utility_common_function;
public class req_rep_class {
public static String Base_URI() {
		String Base_URI="https://reqres.in/";
		return Base_URI;
	}
	
	public static String post_resource() {
		String post_resource="/api/users";
		return post_resource;
	}
	
	public static String post_req1() throws IOException {
		
	ArrayList<String> data=utility_common_function.readdataexcel("testdata", "test_class");
	
	
	String  req_name=data.get(1);
	String req_job=data.get(2);
	String post_requestbody="{\r\n"
			+ "    \"name\": \""+req_name+"\",\r\n"
			+ "    \"job\": \""+req_job+"\"\r\n"
			+ "}";
	return post_requestbody;
}
	
	public static String post_req2() throws IOException {
		
	ArrayList<String> data=utility_common_function.readdataexcel("testdata", "test_class1");
	
	
	String  req_name=data.get(1);
	String req_job=data.get(2);
	String post_requestbody="{\r\n"
			+ "    \"name\": \""+req_name+"\",\r\n"
			+ "    \"job\": \""+req_job+"\"\r\n"
			+ "}";
	return post_requestbody;

}
public static String post_req3() throws IOException {
		
		ArrayList<String> data=utility_common_function.readdataexcel("testdata", "test_class2");
		String  req_name=data.get(1);
		String req_job=data.get(2);
		String post_requestbody="{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				+ "}";
		return post_requestbody;
	}}
