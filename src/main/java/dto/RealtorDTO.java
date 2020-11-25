package dto;

import java.util.List;

/**
 *
 * @author Malthe
 */
public class RealtorDTO {
    public List<Properties> properties;
    
    public RealtorDTO() {}
    
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
