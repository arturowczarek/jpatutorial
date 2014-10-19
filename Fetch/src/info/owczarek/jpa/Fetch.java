package info.owczarek.jpa;

import info.owczarek.jpa.domain.Employee;
import info.owczarek.jpa.domain.Phone;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Fetch {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Employee employee = entityManager.find(Employee.class, 1L);
		
		List<Phone> phones = employee.getPhones();
		System.out.println(phones);
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
