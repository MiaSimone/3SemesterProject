/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dto.FavoritePropertyDTO;
import dto.RealtorDTO;
import entities.FavoriteProperty;
import errorhandling.AlreadyInUseException;
import errorhandling.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Malthe
 */
public class FavoritePropertyFacade {
    
    private static EntityManagerFactory emf;
    private static FavoritePropertyFacade instance;
    
    private FavoritePropertyFacade() {
    }
    
    public static FavoritePropertyFacade getFavePropFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FavoritePropertyFacade();
        }
        return instance;
    }
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public FavoritePropertyDTO getAllFaveProps() throws NotFoundException {
        EntityManager em = emf.createEntityManager();
        try {
            List<FavoriteProperty> favePropsList = em.createQuery("SELECT f FROM FavoriteProperty f").getResultList();
            FavoritePropertyDTO faveDTO = new FavoritePropertyDTO(favePropsList);
            return faveDTO;
        } finally {
            em.close();
        }
    }
    
    public String deleteFavePropById(String id) throws NotFoundException {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("DELETE FROM FavoriteProperty f WHERE f.propId = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            em.getTransaction().commit();
            return "Property with ID: " + id + " successfully deleted from your list.";
        } catch (Exception e) {
            throw new NotFoundException("Property with that ID does not exist");
        } finally {
            em.close();
        }
    }
    
    public String fillDB() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            
            FavoriteProperty fp1 = new FavoriteProperty("ABC123", "www.url.com", "House", "300", "Square KM", "www.thumbnail.com", "New York City", "Test Avenue 1", "54321", "NTC", "Testsas", "Test County", "1,000,000");
            FavoriteProperty fp2 = new FavoriteProperty("DEF456", "www.url.com", "Condo", "100", "Square KM", "www.thumbnail.com", "New York City", "Test Road 9", "98765", "NTC", "Testsas", "Test County", "300,000");
            
            em.persist(fp1);
            em.persist(fp2);
            
            em.getTransaction().commit();
            
            return "{\"status\":\"filled\"}";
        } finally {
            em.close();
        }
    }
}
