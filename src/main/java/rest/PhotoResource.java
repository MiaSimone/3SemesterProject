
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.StandartDTO;
import fetchers.PhotoFetcher;
import fetchers.PropertyFetcher;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

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
    
    @GET
    @Path("placeref/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPlaceRef(@PathParam("city") String city) throws Exception {
        Dotenv dotenv = Dotenv.load(); 
        String key;
        boolean isDeployed = (System.getenv("DEPLOYED") != null);
        if(isDeployed){
          //Will read the environment variable set in your droplets docker-compose.yml file
          key = System.getenv("MY_API_KEY");
        }
        else {
          //Will read the key from the .env file in development
          
          key = dotenv.get("MY_API_KEY"); 
        }
        System.out.println("HEEEEEEEEEEEEEER");
        System.out.println("Value of my secret key: "+key);

        
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

