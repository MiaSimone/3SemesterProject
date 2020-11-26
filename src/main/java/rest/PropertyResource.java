
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import fetchers.PropertyFetcher;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import utils.HttpUtils;
/**
 *
 * @author miade and selina
 */
@Path("properties")
public class PropertyResource {
    
    @Context
    private UriInfo context;
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static ExecutorService es = Executors.newCachedThreadPool();
    private static String cachedResponse;
    
    @GET
    @Produces
    @Path("/all")
    public String getAllProperties() throws Exception {
        String result = PropertyFetcher.responseFromExternalServerParrallel(es, GSON, 
                "https://realtor.p.rapidapi.com/properties/v2/list-for-sale?city=New%20York&limit=10&offset=0&state_code=NY&sort=relevance");
        cachedResponse = result;
        return result;
    }
    
    @GET
    @Path("/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCharacters(@PathParam("city") String city) throws Exception {
        
        if (city.contains(" ")){
            city = city.replace(" ", "%20");
        }

        String result = PropertyFetcher.responseFromExternalServerParrallel(es, GSON, 
                "https://realtor.p.rapidapi.com/properties/v2/list-for-sale?city="+city+"&limit=10");
        cachedResponse = result;
        return result;
    }
    
}
