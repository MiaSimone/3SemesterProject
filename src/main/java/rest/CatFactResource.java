
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fetchers.CatFactFetcher;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

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
    @Produces(MediaType.APPLICATION_JSON)
    public String getRandomFacts() throws Exception {
        String result = CatFactFetcher.responseFromExternalServerParrallel(es, GSON);
        cachedResponse = result;
        return result;
    }
    
    
}
