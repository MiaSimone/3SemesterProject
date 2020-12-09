
package facades;

import dto.AddFavoriteDTO;
import entities.AddFavoriteEntity;
import errorhandling.AlreadyInUseException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class AddFavoriteFacade {

    
    private static AddFavoriteFacade instance;
    private static EntityManagerFactory emf;
    
    private AddFavoriteFacade() {}
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static AddFavoriteFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new AddFavoriteFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public AddFavoriteDTO addTestObject(AddFavoriteEntity t) throws AlreadyInUseException{
        
        EntityManager em = getEntityManager();
        
        try {
            em.getTransaction().begin();
                em.persist(t);
            em.getTransaction().commit();
            return new AddFavoriteDTO(t);
        } catch (Exception e) {
            throw new AlreadyInUseException("This property is already saved to favorites.");
        }
            finally {
            em.close();
        }
    }
    
    
    
}
