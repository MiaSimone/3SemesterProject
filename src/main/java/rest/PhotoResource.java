
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.StandartDTO;
import fetchers.PhotoFetcher;
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

/**
 *
 * @author miade
 */

@Path("photo")
public class PhotoResource {
    
    
    @Context
    private UriInfo context;
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static ExecutorService es = Executors.newCachedThreadPool();
    private static String cachedResponse;
    private String key = "";
    
    @GET
    @Path("placeref/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPlaceRef(@PathParam("city") String city) throws Exception {
        if (city.contains(" ")){
            city = city.replace(" ", "%20");
        }
        String placeID = PhotoFetcher.retrievePlaceID(es, GSON, 
                "https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input="
                        +city+"&inputtype=textquery&key="+key);
        
        String result = PhotoFetcher.retrievePhotoRef(es, GSON, 
                "https://maps.googleapis.com/maps/api/place/details/json?place_id="+placeID+"&key="+key);
        cachedResponse = result;
        return result;
    }
    
}

