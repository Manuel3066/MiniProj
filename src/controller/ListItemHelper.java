package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Events;
import model.Staff;

public class ListItemHelper {
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
		List<Staff> allStaff = em.createQuery("SELECT s FROM Staff s").getResultList();
		return allStaff;
	}

	public void deleteItem(Staff toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Staff> typedQuery = em.createQuery(
				"select li from Staff li where li.store = :selectedEvent and li.item = :selectedStaff",
				Staff.class);
		typedQuery.setParameter("selectedEvent", toDelete.getEvent());
		typedQuery.setParameter("selectedStaff", toDelete.getStaff());

		typedQuery.setMaxResults(1);

		Staff result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	public Staff searchForStaffById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Staff found = em.find(Staff.class, idToEdit);
		em.close();
		return found;
	}

	public void updateStaff(Staff toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Staff> searchForStaffByEvent(String eventName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Staff> typedQuery = em.createQuery("select li from Staff li where li.event = :selectedEvent", Staff.class);
		typedQuery.setParameter("selectedName", eventName);

		List<Staff> foundStaff = typedQuery.getResultList();
		em.close();
		return foundStaff;
	}

	public List<Staff> searchForStaffByStaff(String staffName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Staff> typedQuery = em.createQuery("select li from Staff li where li.staff = :selectedStaff", Staff.class);
		typedQuery.setParameter("selectedStaff", staffName);

		List<Staff> foundStaff = typedQuery.getResultList();
		em.close();
		return foundStaff;
	}
	
	public void cleanUp(){
		emfactory.close();
	}
}