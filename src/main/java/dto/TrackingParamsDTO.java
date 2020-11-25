
package dto;

/**
 *
 * @author miade
 */
public class TrackingParamsDTO {
    
    /*
    "channel": "for_sale",
            "siteSection": "for_sale",
            "city": "New York City",
            "county": "unknown",
            "neighborhood": "unknown",
            "searchCityState": "New York City, NY",
            "state": "NY",
            "zip": "unknown",
            "srpPropertyStatus": "srp:for_sale",
            "listingActivity": "unknown",
            "propertyStatus": "for_sale",
            "propertyType": "any",
            "searchBathrooms": "any",
            "searchBedrooms": "any",
            "searchMaxPrice": "unknown",
            "searchMinPrice": "unknown",
            "searchRadius": "unknown",
            "searchHouseSqft": "any",
            "searchLotSqft": "any",
            "searchResults": "2",
            "sortResults": "relevance",
            "searchCoordinates": "unknown",
            "version": "1.0"
    */
    
    private String channel;
    private String siteSection;
    private String city;
    private String country;
    private String neighborhood;
    private String searchCityState;
    private String state;
    private String zip;
    private String srpPropertyStatus;
    private String listingActivity;
    private String propertyStatus;
    private String propertyType;
    private String searchBathrooms;
    private String searchBedrooms;
    private String searchMaxPrice;
    private String searchMinPrice;
    private String searchRadius;
    private String searchHouseSqft;
    private String searchLotSqft;
    private int searchResults;
    private String sortResults;
    private String searchCoordinates;
    private String version;

    public TrackingParamsDTO(String channel, String siteSection, String city, 
            String country, String neighborhood, String searchCityState, 
            String state, String zip, String srpPropertyStatus, String listingActivity, 
            String propertyStatus, String propertyType, String searchBathrooms, 
            String searchBedrooms, String searchMaxPrice, String searchMinPrice, 
            String searchRadius, String searchHouseSqft, String searchLotSqft, 
            int searchResults, String sortResults, String searchCoordinates, String version) {
        this.channel = channel;
        this.siteSection = siteSection;
        this.city = city;
        this.country = country;
        this.neighborhood = neighborhood;
        this.searchCityState = searchCityState;
        this.state = state;
        this.zip = zip;
        this.srpPropertyStatus = srpPropertyStatus;
        this.listingActivity = listingActivity;
        this.propertyStatus = propertyStatus;
        this.propertyType = propertyType;
        this.searchBathrooms = searchBathrooms;
        this.searchBedrooms = searchBedrooms;
        this.searchMaxPrice = searchMaxPrice;
        this.searchMinPrice = searchMinPrice;
        this.searchRadius = searchRadius;
        this.searchHouseSqft = searchHouseSqft;
        this.searchLotSqft = searchLotSqft;
        this.searchResults = searchResults;
        this.sortResults = sortResults;
        this.searchCoordinates = searchCoordinates;
        this.version = version;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getSiteSection() {
        return siteSection;
    }

    public void setSiteSection(String siteSection) {
        this.siteSection = siteSection;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getSearchCityState() {
        return searchCityState;
    }

    public void setSearchCityState(String searchCityState) {
        this.searchCityState = searchCityState;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getSrpPropertyStatus() {
        return srpPropertyStatus;
    }

    public void setSrpPropertyStatus(String srpPropertyStatus) {
        this.srpPropertyStatus = srpPropertyStatus;
    }

    public String getListingActivity() {
        return listingActivity;
    }

    public void setListingActivity(String listingActivity) {
        this.listingActivity = listingActivity;
    }

    public String getPropertyStatus() {
        return propertyStatus;
    }

    public void setPropertyStatus(String propertyStatus) {
        this.propertyStatus = propertyStatus;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getSearchBathrooms() {
        return searchBathrooms;
    }

    public void setSearchBathrooms(String searchBathrooms) {
        this.searchBathrooms = searchBathrooms;
    }

    public String getSearchBedrooms() {
        return searchBedrooms;
    }

    public void setSearchBedrooms(String searchBedrooms) {
        this.searchBedrooms = searchBedrooms;
    }

    public String getSearchMaxPrice() {
        return searchMaxPrice;
    }

    public void setSearchMaxPrice(String searchMaxPrice) {
        this.searchMaxPrice = searchMaxPrice;
    }

    public String getSearchMinPrice() {
        return searchMinPrice;
    }

    public void setSearchMinPrice(String searchMinPrice) {
        this.searchMinPrice = searchMinPrice;
    }

    public String getSearchRadius() {
        return searchRadius;
    }

    public void setSearchRadius(String searchRadius) {
        this.searchRadius = searchRadius;
    }

    public String getSearchHouseSqft() {
        return searchHouseSqft;
    }

    public void setSearchHouseSqft(String searchHouseSqft) {
        this.searchHouseSqft = searchHouseSqft;
    }

    public String getSearchLotSqft() {
        return searchLotSqft;
    }

    public void setSearchLotSqft(String searchLotSqft) {
        this.searchLotSqft = searchLotSqft;
    }

    public int getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(int searchResults) {
        this.searchResults = searchResults;
    }

    public String getSortResults() {
        return sortResults;
    }

    public void setSortResults(String sortResults) {
        this.sortResults = sortResults;
    }

    public String getSearchCoordinates() {
        return searchCoordinates;
    }

    public void setSearchCoordinates(String searchCoordinates) {
        this.searchCoordinates = searchCoordinates;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    
    
    
}
