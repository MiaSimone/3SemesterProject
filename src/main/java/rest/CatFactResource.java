
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import dto.CatFactDTO;
import fetchers.CatFactFetcher;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import utils.HttpUtils;

/**
 *
 * @author miade
 */
@Path("catfacts")
public class CatFactResource {
    
    
    @Context
    private UriInfo context;
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static ExecutorService es = Executors.newCachedThreadPool();
    private static String cachedResponse;
    
    
    @GET
    @Path("characters")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCharacters() throws Exception {
        /*
        URL url = new URL("https://realtor.p.rapidapi.com/properties/v2/list-for-sale?city=New%20York%20City&limit=1&offset=0&state_code=NY&sort=relevance");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("x-rapidapi-key", "d12379afb6msh4e1abe29e50bca0p15e49ejsn56af46069613");
        con.setRequestProperty("x-rapidapi-host", "realtor.p.rapidapi.com");
        */
        
        /*
        HttpResponse<JsonNode> response = Unirest.get("https://realtor.p.rapidapi.com/properties/v2/list-for-sale?city=New%20York%20City&limit=1&offset=0&state_code=NY&sort=relevance")
	.header("x-rapidapi-key", "d12379afb6msh4e1abe29e50bca0p15e49ejsn56af46069613")
	.header("x-rapidapi-host", "realtor.p.rapidapi.com")
	.asJson();
        
        JSONObject myObject = response.getBody().getObject();
        
        System.out.println(myObject);
        //return GSON.toJson(response.getBody());
        */
        
        HttpResponse<JsonNode> response = Unirest.get("https://realtor.p.rapidapi.com/properties/v2/list-for-sale?city=New%20York%20City&limit=1&offset=0&state_code=NY&sort=relevance")
	.header("x-rapidapi-key", "d12379afb6msh4e1abe29e50bca0p15e49ejsn56af46069613")
	.header("x-rapidapi-host", "realtor.p.rapidapi.com")
	.asJson();
        
        Gson gson = new Gson();
        String responseJSONString = response.getBody().toString();
        
        return responseJSONString;
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getRandomFacts() throws Exception {
        String result = CatFactFetcher.responseFromExternalServerParrallel(es, GSON);
        cachedResponse = result;
        return result;
    }
    
    
}
