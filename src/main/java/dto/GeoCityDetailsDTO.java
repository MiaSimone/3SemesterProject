package dto;

/**
 *
 * @author Malthe
 */
public class GeoCityDetailsDTO {
    public DetailsData data;

    public GeoCityDetailsDTO(DetailsData data) {
        this.data = data;
    }

    public DetailsData getData() {
        return data;
    }
    
}

class DetailsData{
    public String city;
    public String country;
    public String elevationMeters;
    public String population;
}
