package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Staff;

public class EventHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MiniProj");
	
	public void insertNewStaffDetails(Staff s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Staff> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<Staff> allStaff = em.createQuery("SELECT s FROM Staff s").getResultList();
		return allStaff;
	}

}
