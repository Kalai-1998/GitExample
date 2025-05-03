package com.restassured;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class TestRestAssured {
 @Test
	public void getData() {
		
		RestAssured.given()
		          .baseUri("https://jsonplaceholder.typicode.com/posts")
		       
		         .when()
		             .get()
		             
		          .then()
		              .log().all()
		              .statusCode(200);
		
	}
 @Test
 public void postMethod()
 {
	 RestAssured.given()
	       .baseUri("https://jsonplaceholder.typicode.com/posts/1/comments")
	       .contentType("application/json")
	       .body("{\r\n"
	       		+ "    \"name\":\"kalaivani\",\r\n"
	       		+ "    \"age\":\"25\",\r\n"
	       		+ "    \"address\": \"vadapalani\"\r\n"
	       		+ "}")
	       .when()
	        .post()
	        
	        .then()
            .log().all()
            .statusCode(201);
	 }
 @Test
 public void patchCall()
 {
	 RestAssured.given()
     .baseUri("https://jsonplaceholder.typicode.com/posts/2")
     .contentType("application/json")
     .body("{\r\n"
     		+ " \"address\":\"Channai\",\r\n"
     		+ "  \"mobile\":\"998774561\"\r\n"
     		+ "}")
     .when()
      .patch()
      
      .then()
      .log().all()
      .statusCode(200);
	 
 }
 @Test
 public void putCall()
 {
	 RestAssured.given()
     .baseUri("https://jsonplaceholder.typicode.com/posts/4")
     .contentType("application/json")
     .body("{\r\n"
     		+ "    \"userId\": 1,\r\n"
     		+ "    \"title\": \"qui est esse\",\r\n"
     		+ "    \"body\": \"Hello world,welcome to Api\",\r\n"
     		+ "    \"address\": \"Channai\",\r\n"
     		+ "    \"mobile\": \"998774561\",\r\n"
     		+ "    \"email\":\"n9898@gmail.com\"\r\n"
     		+ "}")
     .when()
      .put()
      
      .then()
      .log().all()
      .statusCode(200);
	 
 }
 @Test
 public void deleteCall() {
	 RestAssured.given()
     .baseUri("https://jsonplaceholder.typicode.com/posts/6")
     .contentType("application/json")
     .body("{\r\n"
     		+ "    \"userId\": 1,\r\n"
     		+ "    \"title\": \"dolorem eum magni eos aperiam quia\",\r\n"
     		+ "    \"body\": \"ut aspernatur corporis harum nihil quis provident sequi\\nmollitia nobis aliquid molestiae\\nperspiciatis et ea nemo ab reprehenderit accusantium quas\\nvoluptate dolores velit et doloremque molestiae\"\r\n"
     		+ "}")
     .when()
      .delete()
      
      .then()
      .log().all()
      .statusCode(200);
     
}
}
