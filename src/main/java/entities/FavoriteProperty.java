package entities;

import dto.RealtorDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Malthe
 */
@Entity
//@NamedQuery(name = "FavoriteProperty.deleteAllRows", query = "DELETE from FavoriteProperty")
@Table(name = "favoriteProperties")
public class FavoriteProperty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "prop_id", length = 25)
    private String propId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "rdc_web_url")
    private String rdcWebUrl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "size")
    private String size;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "units")
    private String units;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "thumbnail")
    private String thumbnail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "line")
    private String line;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "postal_code")
    private String postalCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "state_code")
    private String stateCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "county")
    private String county;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "price")
    private String price;
    
    //@ManyToMany (mappedBy = "faveProps", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @ManyToMany (mappedBy = "faveProps", cascade = CascadeType.PERSIST)
    private List<User> users = new ArrayList<>();
    
    
    public FavoriteProperty() {
    }

    public FavoriteProperty(String propId, String rdcWebUrl, String type, String size, String units, String thumbnail, String city, String line, String postalCode, String stateCode, String state, String county, String price) {
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    public void addUser(User user) {
        this.users.add(user);
    }
    
    public void removeUser(User user){
        User userToBeRemoved = null;
        for (User user_ : this.users){
            if (user_.getUserName().equals(user.getUserName())){
                userToBeRemoved = user_;
            }
        }
                this.users.remove(userToBeRemoved);
    }
    
    

    @Override
    public String toString() {
        return "entities.FavoriteHouse[ id=" + propId + " ]";
    }
    
}
