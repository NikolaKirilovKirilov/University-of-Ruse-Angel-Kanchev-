package beans;

import java.util.List;
import com.google.gson.Gson;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class Database {
	
	@PersistenceContext(unitName = "JPADefaultDataBaseConnection")
    private EntityManager em;

    public void RegisterUser(User registration) {
        em.persist(registration);
    }
    
    public User checkUserPass(String name, String password)
    {
    	return em.createQuery("Select t From user t Where t.name = :name AND t.password = :password", User.class)
    			 .setParameter("name", name)
    			 .setParameter("password", password)
    			 .getSingleResult();
    }

    public String getUsersAsJson() {
        return new Gson().toJson(getAllUsers());
    }
    
    public List<User> getAllUsers() {
        return em.createQuery("SELECT t FROM user t", User.class).getResultList();
    }
}
