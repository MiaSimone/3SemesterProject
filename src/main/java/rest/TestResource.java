
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.TestDTO;
import entities.TestEntity;
import errorhandling.AlreadyInUseException;
import facades.TestFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.WebApplicationException;
import utils.EMF_Creator;

//Todo Remove or change relevant parts before ACTUAL use
@Path("test")
public class TestResource {

    
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    
    private static final TestFacade FACADE =  TestFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
 
   
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }


    @POST	
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addTestObject(String object){
        try {
            TestDTO tDTO = GSON.fromJson(object, TestDTO.class);
            TestEntity t = new TestEntity(
                tDTO.getProp_id(),
                tDTO.getRdc_web_url(),
                tDTO.getProp_type(),
                tDTO.getSize(),
                tDTO.getUnits(),
                tDTO.getThumbnail(),
                tDTO.getCity(),
                tDTO.getLine(),
                tDTO.getPostal_code(),
                tDTO.getState_code(),
                tDTO.getState(),
                tDTO.getCounty(),
                tDTO.getPrice()
            );
        
            TestDTO tAdded = FACADE.addTestObject(t);
            return GSON.toJson(tAdded);
        } catch (AlreadyInUseException ex) {
            throw new WebApplicationException(ex.getMessage(), 400);
        }
    }
    

}
