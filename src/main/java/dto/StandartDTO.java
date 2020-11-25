
package dto;

/**
 *
 * @author miade
 */
public class StandartDTO {
    
    private String time;
    
    private MetaDTO metaDTO;
    

    public StandartDTO(PropertyDTO factDTO, String time) {
        
    }

    public StandartDTO(MetaDTO metaDTO, String time) {
        this.metaDTO = metaDTO;
    }

    public MetaDTO getMetaDTO() {
        return metaDTO;
    }
    
    
    
}
