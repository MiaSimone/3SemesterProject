package dto;

import java.util.List;

/**
 *
 * @author Malthe and Selina
 */
public class GeoCityDTO {
    public List<Data> data;
    
    
    //Nyt, ikke testet 
    public GeoCityDTO(List<Data> dList) {
    this.data = dList;
    }
    
    //Nyt, ikke testet
    public List<Data> getDataList() {
        return data;
    }
}

class Data{
    public String wikiDataId;
}
