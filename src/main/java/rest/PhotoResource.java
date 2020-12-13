
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fetchers.PhotoFetcher;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import utils.EMF_Creator;

/**
 *
 * @author miade
 */

@Path("photo")
public class PhotoResource {
    
    
    @Context
    private UriInfo context;
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static ExecutorService es = Executors.newCachedThreadPool();
    private static String cachedResponse;
    
    @GET
    @Path("placeref/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPlaceRef(@PathParam("city") String city) throws Exception {
       
        String key = "";
        
        //String key = "REAL VALUE"; //We will hide this in a gitignored file tomorrow
        boolean isDeployed = (System.getenv("DEPLOYED") != null);
        if(isDeployed) {
          key = System.getenv("MY_API_KEY");
        } else {
            try {
                //File myObj = new File("C:/Users/miade/Documents/NetBeansProjects/3SemesterProject-Backend/apikey.txt");
                //File myObj = new File("C:/apikey.txt");
                File myObj = new File(System.getProperty("c.home"), "C:/apikey.txt");
                File apiTxt = new File (myObj, "apikey.txt");
                
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

