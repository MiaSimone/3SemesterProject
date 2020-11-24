
package entities;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author miade
 */
public class Property {
    
    private String property_id;
    private String houseAtWebsite;
    private int price;
    private int size;
    private String units;
    private DateTime last_update;
    private String prop_type;
    private String officeName;
    private String agentName;
    private String agentPhoto;
    private String mainPhoto;

    public Property(String property_id, String houseAtWebsite, 
            int price, int size, String units, DateTime last_update, 
            String prop_type, String officeName, String agentName, 
            String agentPhoto, String mainPhoto) {
        this.property_id = property_id;
        this.houseAtWebsite = houseAtWebsite;
        this.price = price;
        this.size = size;
        this.units = units;
        this.last_update = last_update;
        this.prop_type = prop_type;
        this.officeName = officeName;
        this.agentName = agentName;
        this.agentPhoto = agentPhoto;
        this.mainPhoto = mainPhoto;
    }

    public String getProperty_id() {
        return property_id;
    }

    public void setProperty_id(String property_id) {
        this.property_id = property_id;
    }

    public String getHouseAtWebsite() {
        return houseAtWebsite;
    }

    public void setHouseAtWebsite(String houseAtWebsite) {
        this.houseAtWebsite = houseAtWebsite;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public DateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(DateTime last_update) {
        this.last_update = last_update;
    }

    public String getProp_type() {
        return prop_type;
    }

    public void setProp_type(String prop_type) {
        this.prop_type = prop_type;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentPhoto() {
        return agentPhoto;
    }

    public void setAgentPhoto(String agentPhoto) {
        this.agentPhoto = agentPhoto;
    }

    public String getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(String mainPhoto) {
        this.mainPhoto = mainPhoto;
    }
    
    
    
    
}

