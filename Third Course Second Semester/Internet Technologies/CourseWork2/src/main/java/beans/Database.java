package beans;

import java.util.List;
import com.google.gson.Gson;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class Database {
    @PersistenceContext(unitName = "JPADefaultDataBaseConnection")
    private EntityManager em;

    public void AddProduct(Product reservation) {
        em.persist(reservation);
    }

    public Product getProducts(String names) {
        return em.createQuery("SELECT t FROM hotel t WHERE t.code = :code", Product.class)
                 .setParameter("names", names)
                 .getSingleResult();
    }

    public List<Product> getAllProducts() {
        return em.createQuery("SELECT t FROM hotel t", Product.class).getResultList();
    }

    public String getProductAsJson() {
        return new Gson().toJson(getAllProducts());
    }
}
