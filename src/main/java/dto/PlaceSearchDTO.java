
package dto;

import entities.PhotoCandidates;
import java.util.List;

/**
 *
 * @author miade
 */
public class PlaceSearchDTO {
    
    // Class for Place Search - Get place ID
        // https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=New%20York%20City&inputtype=textquery&key=AIzaSyBiq63f5HkI1RqsxVsVcgNcVXKQIhdi3LQ

    public List<PhotoCandidates> candidates;

    public PlaceSearchDTO() {}
}


