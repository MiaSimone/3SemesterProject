/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fetcher;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import rest.*;
import fetchers.PhotoFetcher;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Mia
 */

//@Disabled

public class PhotoFetcherTest {
    private static final int SERVER_PORT = 7777;
    private static final String SERVER_URL = "http://localhost/api";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static ExecutorService es = Executors.newCachedThreadPool();

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
    public void testFetchPlaceID() throws Exception {
        System.out.println("TESTING - fetch place id");
        
        String key = "";
        
        //String key = "REAL VALUE"; //We will hide this in a gitignored file tomorrow
        boolean isDeployed = (System.getenv("DEPLOYED") != null);
        if(isDeployed) {
          key = System.getenv("MY_API_KEY");
        } else {
            try {
                //File myObj = new File("C:/Users/miade/Documents/NetBeansProjects/3SemesterProject-Backend/apikey.txt");
                File myObj = new File("C:/apikey.txt");
                
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                  String data = myReader.nextLine();
                  key = data;
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        
        String result = PhotoFetcher.retrievePlaceID(es, GSON, 
                "https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=London&inputtype=textquery&key="+key);
        
        String expResult = "ChIJdd4hrwug2EcRmSrV3Vo6llI";
        
        assertEquals(expResult, result);
    }
    
}
