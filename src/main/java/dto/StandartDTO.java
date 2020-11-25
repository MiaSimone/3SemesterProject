
package dto;

/**
 *
 * @author miade
 */
public class StandartDTO {
    
    private String time;
    
    private AllDTO allDTO;
    

    public StandartDTO(PropertyDTO factDTO, String time) {
        
    }

    public StandartDTO(AllDTO allDTO, String time) {
        this.allDTO = allDTO;
    }

    public AllDTO getAllDTO() {
        return allDTO;
    }
    
    
    
}
