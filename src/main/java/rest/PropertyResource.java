
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import dto.FavoritePropertyDTO;
import facades.FavoritePropertyFacade;
import entities.FavoriteProperty;
import errorhandling.AlreadyInUseException;
import errorhandling.NotFoundException;
import fetchers.PropertyFetcher;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import utils.EMF_Creator;
import utils.HttpUtils;
/**
 *
 * @author miade and selina
 */
@Path("properties")
public class PropertyResource {
    
    @Context
    private UriInfo context;
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final FavoritePropertyFacade FACADE = FavoritePropertyFacade.getFavePropFacade(EMF);
    private static ExecutorService es = Executors.newCachedThreadPool();
    private static String cachedResponse;
    
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
    
    @GET
    @Path("/saved")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllFaveProps() {
        try {
            return GSON.toJson(FACADE.getAllFaveProps());
        } catch (NotFoundException ex) {
            throw new WebApplicationException(ex.getMessage(), 400);
        }
    }
    
    @POST
    @Path("/saveprop")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addToFavorites(FavoritePropertyDTO faveProp) {
        try {
            return GSON.toJson(FACADE.addFaveProp(faveProp));
        } catch (AlreadyInUseException ex) {
            throw new WebApplicationException(ex.getMessage(), 400);
        }
    }
    
    @DELETE
    @Path("/deleteprop/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteFavePropById(@PathParam("id") String propId) {
        try {
            return GSON.toJson(FACADE.deleteFavePropById(propId));
        } catch (NotFoundException ex) {
            throw new WebApplicationException(ex.getMessage(), 400);
        }
    }
    
    // Only use this endpoint ONCE if your db is empty.
    @GET
    @Path("/filldb")
    @Produces(MediaType.APPLICATION_JSON)
    public String getFilling() {
        return FACADE.fillDB();
    }
    
}
