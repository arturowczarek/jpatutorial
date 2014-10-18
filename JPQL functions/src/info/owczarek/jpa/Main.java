package info.owczarek.jpa;

import info.owczarek.jpa.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main(String[] args) {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();

		addEmployees();

		Query query = entityManager.createQuery("select substring(e.firstName, 1, 3), trim(e.lastName), lower(e.firstName), upper(e.firstName), length(e.firstName) from Employee e where e.firstName = 'Karol'");
		Object[] result = (Object[]) query.getSingleResult();
		System.out.println("Pierwsze trzy litery imienia: " + result[0]);
		System.out.println("Nazwisko: |" + result[1] + "|");
		System.out.println("Imię małymi literami: " + result[2]);
		System.out.println("Imię wielkimi literami: " + result[3]);
		System.out.println("Długość imienia: " + result[4]);
		
		entityManager.close();
		entityManagerFactory.close();
	}

	private static void addEmployees() {
		addEmployee("Karol", "   Mateusiak   ", 2633);
		addEmployee("Marika", "Bednarek", 2345);
		addEmployee("Jan", "Mateusiak", 7346);
		addEmployee("Daria", "Kowalska", 2352);
		addEmployee("Monika", "Ucińska", 4263);
		addEmployee("Ernest", "Pająk", 2634);
		addEmployee("Kamil", "Stępień", 2345);
		addEmployee("Przemek", "Maciejewski", 5433);
		addEmployee("Robert", "Woźniak", 3324);
		addEmployee("Agnieszka", "Nowak", 2000);
		addEmployee("Angelika", "Bednarska", 1000);
	}

	private static void addEmployee(String firstName, String lastName,
			double salary) {
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setSalary(salary);

		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
	}
}
