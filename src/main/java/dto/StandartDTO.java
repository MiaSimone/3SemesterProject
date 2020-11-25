
package dto;

/**
 *
 * @author miade
 */
public class StandartDTO {
    
    private String time;
    
    private AllDTO allDTO;
    
    private RealtorDTO realtorDTO;
    

    public StandartDTO(PropertyDTO factDTO, String time) {
        
    }

//    public StandartDTO(AllDTO allDTO, String time) {
//        this.allDTO = allDTO;
//    }
    
    public StandartDTO(RealtorDTO realtorDTO, String time) {
        this.realtorDTO = realtorDTO;
    }

    public AllDTO getAllDTO() {
        return allDTO;
    }
    
    
    
}
