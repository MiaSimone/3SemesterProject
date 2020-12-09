
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@NamedQuery(name = "FavoriteProperty.deleteAllRows", query = "DELETE from FavoriteProperty")
@Table(name = "favoriteProperties")
public class AddFavoriteEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String prop_id;
    
    private String rdc_web_url;
    private String type;
    private String size;
    private String units;
    private String thumbnail;
    private String city;
    private String line;
    private String postal_code;
    private String state_code;
    private String state;
    private String county;
    private String price;

    public AddFavoriteEntity() {}

    public AddFavoriteEntity(String prop_id, String rdc_web_url, String prop_type, String size, 
            String units, String thumbnail, String city, String line, String postal_code, 
            String state_code, String state, String county, String price) {
        this.prop_id = prop_id;
        this.rdc_web_url = rdc_web_url;
        this.type = prop_type;
        this.size = size;
        this.units = units;
        this.thumbnail = thumbnail;
        this.city = city;
        this.line = line;
        this.postal_code = postal_code;
        this.state_code = state_code;
        this.state = state;
        this.county = county;
        this.price = price;
    }

    public String getProp_id() {
        return prop_id;
    }

    public void setProp_id(String prop_id) {
        this.prop_id = prop_id;
    }

    public String getRdc_web_url() {
        return rdc_web_url;
    }

    public void setRdc_web_url(String rdc_web_url) {
        this.rdc_web_url = rdc_web_url;
    }

    public String getProp_type() {
        return type;
    }

    public void setProp_type(String prop_type) {
        this.type = prop_type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    

    
}
