package dto;

import entities.FavoriteProperty;
import java.util.List;

/**
 *
 * @author Malthe
 */
public class FavoritePropertyDTO {
    
    private String propId;
    private String rdcWebUrl;
    private String type;
    private String size;
    private String units;
    private String thumbnail;
    private String city;
    private String line;
    private String postalCode;
    private String stateCode;
    private String state;
    private String county;
    private String price;
    private List<FavoriteProperty> favorites;

    public FavoritePropertyDTO() {
    }
    
    public FavoritePropertyDTO(List<FavoriteProperty> faveProps) {
        this.favorites = faveProps;
    }
    
    //Constructor for making personDTOs with data from the DB
    
    public FavoritePropertyDTO(FavoriteProperty faveProp) {
        this.propId = faveProp.getPropId();
        this.rdcWebUrl = faveProp.getRdcWebUrl();
        this.type = faveProp.getType();
        this.size = faveProp.getSize();
        this.units = faveProp.getUnits();
        this.thumbnail = faveProp.getThumbnail();
        this.city = faveProp.getCity();
        this.line = faveProp.getLine();
        this.postalCode = faveProp.getPostalCode();
        this.stateCode = faveProp.getStateCode();
        this.state = faveProp.getState();
        this.county = faveProp.getCounty();
        this.price = faveProp.getPrice();
    }
    
    //Constructor for making PersonDTOs with data from a POST
    public FavoritePropertyDTO(String propId, String rdcWebUrl, String type, String size, String units, String thumbnail, String city, String line, String postalCode, String stateCode, String state, String county, String price) {
        this.propId = propId;
        this.rdcWebUrl = rdcWebUrl;
        this.type = type;
        this.size = size;
        this.units = units;
        this.thumbnail = thumbnail;
        this.city = city;
        this.line = line;
        this.postalCode = postalCode;
        this.stateCode = stateCode;
        this.state = state;
        this.county = county;
        this.price = price;
    }

    public String getPropId() {
        return propId;
    }

    public void setPropId(String propId) {
        this.propId = propId;
    }
    
    public String getRdcWebUrl() {
        return rdcWebUrl;
    }

    public void setRdcWebUrl(String rdcWebUrl) {
        this.rdcWebUrl = rdcWebUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
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
