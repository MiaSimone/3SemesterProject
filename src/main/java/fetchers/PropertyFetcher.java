
package fetchers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.MetaDTO;
import dto.PropertyDTO;
import dto.StandartDTO;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import utils.HttpUtils;

/**
 *
 * @author miade
 */
public class PropertyFetcher {
    
    
    private static final String FACT_SERVER = "https://realtor.p.rapidapi.com/properties/v2/list-for-sale?city=New%20York%20City&limit=20&offset=0&state_code=NY&sort=relevance";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    public static String responseFromExternalServerParrallel(ExecutorService threadPool, final Gson gson) throws Exception{
        long start = System.nanoTime();
        
        Callable<StandartDTO> task = new Callable<StandartDTO>(){
            @Override
            public StandartDTO call() throws Exception {
                String data = HttpUtils.fetchData2(FACT_SERVER);
                System.out.println("DATA: " + data);
                StandartDTO standart = GSON.fromJson(data, StandartDTO.class);
                System.out.println("DTO: " + standart);
                return standart;
            }
            
        };
        Future<StandartDTO> futureFact = threadPool.submit(task);
        
        StandartDTO standart = futureFact.get(30, TimeUnit.SECONDS);
        
        long end = System.nanoTime(); 
        String time = "Time Parallel: " + ((end-start)/1_000_000) + " ms.";
        
        //StandartDTO sDTO = new StandartDTO(meta, time);
        
        String standartJSON = gson.toJson(standart);
        
        System.out.println(standartJSON);
        return standartJSON;
    }
    
    
    /*
    public static String responseFromExternalServerParrallel(ExecutorService threadPool, final Gson gson) throws Exception{
        long start = System.nanoTime();
        
        Callable<PropertyDTO> task = new Callable<PropertyDTO>(){
            @Override
            public PropertyDTO call() throws Exception {
                String data = HttpUtils.fetchData2(FACT_SERVER);
                System.out.println("DATA: " + data);
                PropertyDTO propertyDTO = GSON.fromJson(data, PropertyDTO.class);
                System.out.println("DTO: " + propertyDTO.getAddress());
                return propertyDTO;
            }
            
        };
        Future<PropertyDTO> futureFact = threadPool.submit(task);
        
        PropertyDTO property = futureFact.get(30, TimeUnit.SECONDS);
        
        long end = System.nanoTime(); 
        String time = "Time Parallel: " + ((end-start)/1_000_000) + " ms.";
        
        //StandartDTO sDTO = new StandartDTO(property, time);
        
        //String standartJSON = gson.toJson(sDTO);
        //System.out.println(property.getPrice());
        
        String standartJSON = gson.toJson(property);
        System.out.println(standartJSON);
        return standartJSON;
    }
*/
}
