package zad07;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.given;

import javax.ws.rs.core.MediaType;

import org.junit.BeforeClass;
import org.junit.Test;

import com.example.restejbjpa.domain.Bicycle;
import com.example.restejbjpa.domain.Producer;
import com.jayway.restassured.RestAssured;

public class BicycleTest {

	   @BeforeClass
	    public static void setUp() {
	        RestAssured.baseURI = "http://localhost";
	        RestAssured.port = 8080;
	        RestAssured.basePath = "/restejbjpademo/api/bicycle";
	    }
	   
	   @Test
	    public void addBicycle() {
	        Bicycle bicycle = new Bicycle("LEVEL A1", 100);

	        given().
	                contentType(MediaType.APPLICATION_JSON).
	                body(bicycle).
	                when().
	                post("/").then().assertThat().statusCode(201);
	   }
	   
	    @Test
	    public void deleteBicycle() {
	        delete("/").then().assertThat().statusCode(200);
	    }
	    
	    
	    @Test
	    public void getAll() {
	        given().
	                contentType(MediaType.APPLICATION_JSON).
	                when().
	                get("/allBicycles").then().assertThat().statusCode(200);

	    }
	    
	    @Test
	    public void getBicycle() {
	        given().
	                contentType(MediaType.APPLICATION_JSON).
	                when().
	                get("/1").then().assertThat().statusCode(204);

	    }
}