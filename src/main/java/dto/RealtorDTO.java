package dto;

import java.util.List;

/**
 *
 * @author Malthe and Selina
 */
public class RealtorDTO {
    public List<Properties> properties;
    
    
    //Nyt, ikke testet 
    public RealtorDTO(List<Properties> pList) {
    this.properties = pList;
    }
    
    //Nyt, ikke testet
    public List<Properties> getPropertyList() {
        return properties;
    }
}

class Properties{
    public String property_id;
    public String rdc_web_url;
    public String prop_type;
    Address address;
    public String price;
    BuildingSize building_size;
    public String thumbnail;
    
}

class Address{
    public String city;
    public String line;
    public String postal_code;
    public String state_code;
    public String state;
    public String county;
}

class BuildingSize{
    public String size;
    public String units;
}
