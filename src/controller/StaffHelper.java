package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Events;
import model.Staff;

public class StaffHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MiniProj");
	
	public void insertStaff(Events e) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Staff> showAllStaff() {
		EntityManager em = emfactory.createEntityManager();
		List<Staff> allStaff = em.createQuery("SELECT e FROM Events e").getResultList();
		return allStaff;
	}
}
