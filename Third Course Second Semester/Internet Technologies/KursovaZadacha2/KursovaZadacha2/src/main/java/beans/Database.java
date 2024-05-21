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

    public void AddReservation(Hotel reservation) {
        em.persist(reservation);
    }

    public Hotel getReservations(String names) {
        return em.createQuery("SELECT t FROM hotel t WHERE t.names = :names", Hotel.class)
                 .setParameter("names", names)
                 .getSingleResult();
    }

    public List<Hotel> getAllReservations() {
        return em.createQuery("SELECT t FROM hotel t", Hotel.class).getResultList();
    }

    public String getReservationAsJson() {
        return new Gson().toJson(getAllReservations());
    }
}
