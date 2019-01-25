package zad07;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.given;

import javax.ws.rs.core.MediaType;

import org.junit.BeforeClass;
import org.junit.Test;

import com.example.restejbjpa.domain.Producer;
import com.jayway.restassured.RestAssured;

public class ProducerTest {

	   @BeforeClass
	    public static void setUp() {
	        RestAssured.baseURI = "http://localhost";
	        RestAssured.port = 8080;
	        RestAssured.basePath = "/restejbjpademo/api/producer";
	    }
	   
	   @Test
	    public void addProducer() {
	        Producer producer = new Producer("KROSS");

	        given().
	                contentType(MediaType.APPLICATION_JSON).
	                body(producer).
	                when().
	                post("/").then().assertThat().statusCode(201);
	   }
	    
	    @Test
	    public void getAll() {
	        given().
	                contentType(MediaType.APPLICATION_JSON).
	                when().
	                get("/allProducers").then().assertThat().statusCode(200);

	    }
	    
	    @Test
	    public void getProducer() {
	        given().
	                contentType(MediaType.APPLICATION_JSON).
	                when().
	                get("/0").then().assertThat().statusCode(204);

	    }
}