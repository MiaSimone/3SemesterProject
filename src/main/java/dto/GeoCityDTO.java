package dto;

import java.util.List;
import entities.GeoCity;

/**
 *
 * @author Malthe and Selina
 */
public class GeoCityDTO {
    public List<GeoCity> data;
    
    
    //Nyt, ikke testet 
    public GeoCityDTO(List<GeoCity> dList) {
    this.data = dList;
    }
    
    //Nyt, ikke testet
    public List<GeoCity> getDataList() {
        return data;
    }
}

