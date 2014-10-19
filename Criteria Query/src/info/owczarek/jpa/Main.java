package info.owczarek.jpa;

import java.util.List;

import info.owczarek.jpa.domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

public class Main {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main(String[] args) {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();

		addEmployees();
		
		// select e from Employee e where e.salary > 3000 and e.salary < 5000
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);
		Root<Employee> employee = criteriaQuery.from(Employee.class);
		
		Path<Double> salary = employee.get("salary");
		criteriaQuery.select(employee).where(builder.and(builder.greaterThan(salary, 3000.0), builder.lessThan(salary, 5000.0)));
		
		TypedQuery<Employee> query = entityManager.createQuery(criteriaQuery);
		List<Employee> employees = query.getResultList();
		
		for (Employee emp : employees) {
			System.out.println(emp.getFirstName());
			System.out.println(emp.getLastName());
			System.out.println(emp.getSalary());
			System.out.println();
		}

		entityManager.close();
		entityManagerFactory.close();
	}

	private static void addEmployees() {
		addEmployee("Karol", "Mateusiak", 2633);
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
