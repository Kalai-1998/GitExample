package com.restassured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojoClass.PoloClass;

public class RestAssuredClass {
	@Test
	public void mapMethod(){
		
		   String baseURI ="http://localhost:3000/VelanStudents";
		
		 Map<Object,Object> mapData=new LinkedHashMap<>();
				 mapData.put("name","Kalaivani");
			     mapData.put("age",26);
			     mapData.put("address","Chennai");
			     
			     
			     given()
			        .baseUri(baseURI)
			        .body(mapData)
			        
			    .when()
			        .post()
			     
			     .then()
			         .log().all()
			         .statusCode(201)
			         .statusLine("HTTP/1.1 201 Created");
			     
			     
	   }
	@Test
	public void jsonMethod() {
		   String baseURI ="https://jsonplaceholder.typicode.com/posts";
			
			 JSONObject object=new JSONObject();
					object.put("name","Kumarguru");
				     object.put("age",28);
				     object.put("address","Thambaram");
				     
				     
				     given()
				        .baseUri(baseURI)
				        .contentType("application/json")
				        .body(object)
				        
				    .when()
				        .post()
				     
				     .then()
				         .log().all()
				         .statusCode(201)
				         .statusLine("HTTP/1.1 201 Created");
				     
		
	}
	@Test
	public void fileMethod() {
		   String baseURI ="https://jsonplaceholder.typicode.com/posts";
		    
		   
		   File file=new File("FileData.json");
				     
				     
				     given()
				        .baseUri(baseURI)
				        .contentType("application/json")
				        .body(file)
				        
				    .when()
				        .post()
				     
				     .then()
				         .log().all()
				         .statusCode(201)
				         .statusLine("HTTP/1.1 201 Created");
		}
	@Test
	public void pojoMethod() {
		   String baseURI ="https://jsonplaceholder.typicode.com/posts";
		    
		   
		   PoloClass data=new PoloClass();
		   data.setAddress("Chennai");
		   data.setName("Basil");
		   data.setAge(25);
				     
				     
				     given()
				        .baseUri(baseURI)
				        .contentType("application/json")
				        .body(data)
				        
				    .when()
				        .post()
				     
				     .then()
				         .log().all()
				         .statusCode(201)
				         .statusLine("HTTP/1.1 201 Created");
		}
	@Test
	public void serialization_De() throws JsonProcessingException {
		 String baseURI ="https://jsonplaceholder.typicode.com/posts";
		
		 Map<Object,Object> mapData=new LinkedHashMap<>();
		 mapData.put("name","Vijay");
	     mapData.put("age",26);
	     mapData.put("address","Chennai");
		   
		 System.out.println("mapData");
		 
		 System.out.println("---------------------------------------------------------");
		 
		 ObjectMapper mapper =new ObjectMapper();
		 
		 String jsonBody=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapData);
		 
		 System.out.println(jsonBody);
		 
		System.out.println("---------------------------------------------------------");
		
		PoloClass value = mapper.readValue(jsonBody,PoloClass.class);
		
		System.out.println("name: "+value.getName());
		System.out.println("age: "+value.getAge());
		System.out.println("address: "+value.getAddress());
		
	}
	
//	@Test 
//	public void validation() {
//		
//		 String baseURI ="https://jsonplaceholder.typicode.com/posts";
//		  	     
//				     
//				     given()
//				        .baseUri(baseURI)
//				        .contentType("application/json")
//				   
//				        
//				    .when()
//				        .get()
//				     
//				     .then()
//				         .log().all()
//				         .statusCode(200)
//				         .assertThat()
//				         .body("[1].title",equalsTo("qui est esse"));
//				      
//		   
//	}
	

				  

	
	

}
