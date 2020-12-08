
package dto;

import entities.TestEntity;
import java.util.Objects;


public class TestDTO {
    
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

    public TestDTO() {}

    public TestDTO(TestEntity t) {
        this.prop_id = t.getProp_id();
        this.rdc_web_url = t.getRdc_web_url();
        this.type = t.getProp_type();
        this.size = t.getSize();
        this.units = t.getUnits();
        this.thumbnail = t.getThumbnail();
        this.city = t.getCity();
        this.line = t.getLine();
        this.postal_code = t.getPostal_code();
        this.state_code = t.getState_code();
        this.state = t.getState();
        this.county = t.getCounty();
        this.price = t.getPrice();
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

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TestDTO other = (TestDTO) obj;
        if (!Objects.equals(this.prop_id, other.prop_id)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
