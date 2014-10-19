package info.owczarek.jpa;

import info.owczarek.jpa.domain.Employee;
import info.owczarek.jpa.domain.Phone;

import java.util.ArrayList;
import java.util.List;

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
		employee.setSalary(3434.34);
		List<Phone> phones = new ArrayList<>();
		Phone phone1 = new Phone();
		phone1.setType("home");
		phone1.setNumber("432423424");
		Phone phone2 = new Phone();
		phone2.setType("work");
		phone2.setNumber("875884755");
		phones.add(phone1);
		phones.add(phone2);
		employee.setPhones(phones);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
//		entityManager.persist(phone1);
//		entityManager.persist(phone2);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
