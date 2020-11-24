
package dto;

import entities.Address;
import entities.Property;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author miade
 */
public class PropertyDTO {
    
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
    
    private Address address;

    public PropertyDTO() {}

    public PropertyDTO(Property p, Address address) {
        this.property_id = p.getProperty_id();
        this.houseAtWebsite = p.getHouseAtWebsite();
        this.price = p.getPrice();
        this.size = p.getSize();
        this.units = p.getUnits();
        this.last_update = p.getLast_update();
        this.prop_type = p.getProp_type();
        this.officeName = p.getOfficeName();
        this.agentName = p.getAgentName();
        this.agentPhoto = p.getAgentPhoto();
        this.mainPhoto = p.getMainPhoto();
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    
    
}
