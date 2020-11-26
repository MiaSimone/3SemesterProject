
package dto;

import entities.Photo;
import entities.PhotoResult;
import java.util.List;

/**
 *
 * @author miade
 */
public class PhotoDTO {
    
    
    public List<String> linkList;

    
    
    
}


// Class for Place Search - Get place ID
    // https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=New%20York%20City&inputtype=textquery&key=AIzaSyBiq63f5HkI1RqsxVsVcgNcVXKQIhdi3LQ

// Class for Place Details - Get photo refference by place id
    // https://maps.googleapis.com/maps/api/place/details/json?place_id=ChIJOwg_06VPwokRYv534QaPC8g&key=AIzaSyBiq63f5HkI1RqsxVsVcgNcVXKQIhdi3LQ

// Class for Place Photos - Get list of photos by photo refference 
    // https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=ATtYBwKcHvNEwBhrnIRtJGN-bZCIdP6E_Uyg7HG-CpHfOCTJMXE6ALPs2FJO7Hl9xBOZonE1cE4YL-QM0NxvRATcwKrr7kEoo0a0FttcBcVpHd-nGPb1d1Ew27wJkILVxph96bIf9QtYYPZuP4pXmNRViFyMD2ZFVDEyPTd8Xo2jA5-qcMB_&key=AIzaSyBiq63f5HkI1RqsxVsVcgNcVXKQIhdi3LQ
