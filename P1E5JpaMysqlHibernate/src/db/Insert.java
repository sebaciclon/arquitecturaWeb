package db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import seba.dao.Direccion;
import seba.dao.Persona;

public class Insert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Direccion dir = new Direccion("Tandil", "Rodriguez");
		em.persist(dir);
		Persona per1 = new Persona(1, "Seba", 41, dir);
		Persona per2 = new Persona(2, "Sebastian", 41, dir);
		em.persist(per1);
		em.persist(per2);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
