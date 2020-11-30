package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Malthe
 */

public class GeoCityDetails implements Serializable {
    
    public String city;
    public String country;
    public String elevationMeters;
    public String population;
    
}
