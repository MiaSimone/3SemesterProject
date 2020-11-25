
package dto;

/**
 *
 * @author miade
 */
public class MetaDTO {
    
    /*
    "build": "3.23.125",
        "schema": "core.3",
        "tracking_params": {}
    "tracking": "type|meta|data|resource_type|property_list|query|client_id|rdc_mobile_native,13.3.0.53|prop_status|for_sale|schema|core.3|limit|offset|city|New+York+City|state_code|NY|sort|relevance|count|total^2|0|2|TR4^^$0|1|2|$3|4|5|$6|7|8|9|A|B|C|M|D|N|E|F|G|H|I|J]|8|9|K|O|L|P]]",
        "returned_rows": 2,
        "matching_rows": 38560
    */
    
    private String build;
    private String schema;
    
    private TrackingParamsDTO tracking_paramsDTO;
    
    private String tracking;
    private int returned_rows;
    private int matching_rows;

    public MetaDTO(String build, String schema, TrackingParamsDTO tracking_paramsDTO, 
            String tracking, int returned_rows, int matching_rows) {
        this.build = build;
        this.schema = schema;
        this.tracking_paramsDTO = tracking_paramsDTO;
        this.tracking = tracking;
        this.returned_rows = returned_rows;
        this.matching_rows = matching_rows;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public TrackingParamsDTO getTracking_paramsDTO() {
        return tracking_paramsDTO;
    }

    public void setTracking_paramsDTO(TrackingParamsDTO tracking_paramsDTO) {
        this.tracking_paramsDTO = tracking_paramsDTO;
    }

    public String getTracking() {
        return tracking;
    }

    public void setTracking(String tracking) {
        this.tracking = tracking;
    }

    public int getReturned_rows() {
        return returned_rows;
    }

    public void setReturned_rows(int returned_rows) {
        this.returned_rows = returned_rows;
    }

    public int getMatching_rows() {
        return matching_rows;
    }

    public void setMatching_rows(int matching_rows) {
        this.matching_rows = matching_rows;
    }
    
    
    
}
