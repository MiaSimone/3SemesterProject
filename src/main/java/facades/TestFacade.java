
package facades;

import dto.TestDTO;
import entities.TestEntity;
import errorhandling.AlreadyInUseException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class TestFacade {

    
    private static TestFacade instance;
    private static EntityManagerFactory emf;
    
    private TestFacade() {}
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static TestFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new TestFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public TestDTO addTestObject(TestEntity t) throws AlreadyInUseException{
        
        EntityManager em = getEntityManager();
        
        try {
            em.getTransaction().begin();
                em.persist(t);
            em.getTransaction().commit();
            return new TestDTO(t);
        } catch (Exception e) {
            throw new AlreadyInUseException("This property is already saved to favorites.");
        }
            finally {
            em.close();
        }
    }
    
    
    
}
