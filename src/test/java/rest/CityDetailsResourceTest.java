/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import dto.GeoCityDTO;
import dto.GeoCityDetailsDTO;
import dto.StandartDTO;
import entities.GeoCityDetails;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import java.net.URI;
import java.util.List;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.util.HttpStatus;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Mia
 */

//@Disabled

public class CityDetailsResourceTest {
    private static final int SERVER_PORT = 7777;
    //private static final String SERVER_URL = "http://localhost/api";
    private static final String SERVER_URL = "https://swes.me/3semprojectbackend/api";

    static final URI BASE_URI = UriBuilder.fromUri(SERVER_URL).port(SERVER_PORT).build();
    private static HttpServer httpServer;

    static HttpServer startServer() {
        ResourceConfig rc = ResourceConfig.forApplication(new ApplicationConfig());
        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
    }

    @BeforeAll
    public static void setUpClass() {

        httpServer = startServer();
        //Setup RestAssured
        RestAssured.baseURI = SERVER_URL;
        RestAssured.port = SERVER_PORT;
        RestAssured.defaultParser = Parser.JSON;
    }

    @AfterAll
    public static void closeTestServer() {
        httpServer.shutdownNow();
    }
    @BeforeEach
    public void setUp(){
    }
    
    
    @Test
    public void testGetCityDetails() throws Exception {
        System.out.println("TESTING - City Details");
        
        String city = "New York City";
        
        given()
            .contentType("application/json")
            .get("/citydetails/"+city).then()
            .assertThat()
            .statusCode(HttpStatus.OK_200.getStatusCode())
            .body("geoCityDetailsDTO.data.city", is(city))
            .and()
            .body("geoCityDetailsDTO.data.population", is("8398748")); 
                
    }
    
    // Exceptions:
    
      @Test
        public void testGetRefException() throws Exception {
            System.out.println("TESTING - getting PhotoRef exception");
            
            String city = "bjkfdj f vdskjbv";

            given()
                .contentType("application/json")
                .get("/citydetails/"+city)
                .then()
                .assertThat()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR_500.getStatusCode())
                .body("message", equalTo("Internal Server Error"));
        }

}
