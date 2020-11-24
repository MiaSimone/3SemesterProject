
package entities;

/**
 *
 * @author miade
 */
public class Address {
    /*
        "city":"Staten Island",
        "line":"461 Oakdale St",
        "county":"Richmond",
        "neighborhood_name":"South Shore",
        "state":"New York",
        "postal_code":"10312",
        "state_code":"NY",
    */
    
    
    private String city;
    private String line;
    private String country;
    private String neighborhood_name;
    private String state;
    private int postal_code;
    private String state_code;

    public Address(String city, String line, String country, String neighborhood_name, String state, int postal_code, String state_code) {
        this.city = city;
        this.line = line;
        this.country = country;
        this.neighborhood_name = neighborhood_name;
        this.state = state;
        this.postal_code = postal_code;
        this.state_code = state_code;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNeighborhood_name() {
        return neighborhood_name;
    }

    public void setNeighborhood_name(String neighborhood_name) {
        this.neighborhood_name = neighborhood_name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }
    
    
    
    
}
