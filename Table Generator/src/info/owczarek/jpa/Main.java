package info.owczarek.jpa;

import info.owczarek.jpa.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Employee employee1 = new Employee();
//		employee.setId(1L);
		employee1.setFirstName("Jan");
		employee1.setLastName("Nowak");
		employee1.setSalary(3333.3);
		
		Employee employee2 = new Employee();
//		employee2.setId(1L);
		employee2.setFirstName("Robert");
		employee2.setLastName("Bednarek");
		employee2.setSalary(4444.4);
		
		Employee employee3 = new Employee();
//		employee2.setId(1L);
		employee3.setFirstName("Damian");
		employee3.setLastName("Stach");
		employee3.setSalary(5555.4);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee1);
		entityManager.persist(employee2);
		entityManager.persist(employee3);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
