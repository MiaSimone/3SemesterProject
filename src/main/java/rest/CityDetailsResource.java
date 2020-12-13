package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import fetchers.CityDetailsFetcher;
import fetchers.PropertyFetcher;
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
import utils.HttpUtils;
/**
 *
 * @author miade and selina
 */
@Path("citydetails")
public class CityDetailsResource {
    
    @Context
    private UriInfo context;
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static ExecutorService es = Executors.newCachedThreadPool();
    private static String cachedResponse;
    
    @GET
    @Path("/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCityDetails(@PathParam("city") String city) throws Exception {
        
        if (city.contains(" ")){
            city = city.replace(" ", "%20");
        }

        
        String cityWikiId = CityDetailsFetcher.responseFromGeoDBCity(es, GSON, 
                "https://wft-geo-db.p.rapidapi.com/v1/geo/cities?namePrefix=" + city);
        
        Thread.sleep(2000);
        
        String cityDetails = CityDetailsFetcher.responseFromGeoDBCityDetails(es, GSON, 
                "https://wft-geo-db.p.rapidapi.com/v1/geo/cities/" + cityWikiId);
        cachedResponse = cityDetails;
        
        return cityDetails;
    }
    
}
