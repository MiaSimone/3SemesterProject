package dto;

import entities.GeoCityDetails;

/**
 *
 * @author Malthe
 */
public class GeoCityDetailsDTO {
    public GeoCityDetails data;

    public GeoCityDetailsDTO(GeoCityDetails data) {
        this.data = data;
    }

    public GeoCityDetails getData() {
        return data;
    }
    
}
