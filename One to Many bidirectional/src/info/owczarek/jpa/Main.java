package info.owczarek.jpa;

import info.owczarek.jpa.domain.Employee;
import info.owczarek.jpa.domain.Phone;

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
		employee.setSalary(2344.3);
		Phone phone1 = new Phone();
		phone1.setType("mobile");
		phone1.setNumber("33434343");
		phone1.setEmployee(employee);
		Phone phone2 = new Phone();
		phone2.setType("home");
		phone2.setNumber("785773847");
		phone2.setEmployee(employee);
		
		entityManager.getTransaction().begin();
		entityManager.persist(phone1);
		entityManager.persist(phone2);
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		
		entityManager.refresh(employee);
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
