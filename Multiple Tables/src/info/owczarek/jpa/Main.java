package info.owczarek.jpa;

import info.owczarek.jpa.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Employee employee = new Employee();
		employee.setFirstName("Jan");
		employee.setLastName("Nowak");
		employee.setSalary(1111.1);
		employee.setLocality("Warszawa");
		employee.setZipCode("11-111");
		employee.setStreet("Koszykowa");
		employee.setStreetNumber(111);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
