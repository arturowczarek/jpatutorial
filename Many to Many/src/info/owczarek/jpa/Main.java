package info.owczarek.jpa;

import java.util.ArrayList;
import java.util.List;

import info.owczarek.jpa.domain.Employee;
import info.owczarek.jpa.domain.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Project project1 = new Project();
		project1.setName("Projekt 1");
		Project project2 = new Project();
		project2.setName("Projekt 2");
		
		Employee employee1 = new Employee("Jan", "Nowak", 123.0);
		Employee employee2 = new Employee("Maria", "Kowalska", 123.0);
		Employee employee3 = new Employee("Angelika", "Ucińska", 123.0);
		Employee employee4 = new Employee("Robert", "Bednarek", 123.0);
		Employee employee5 = new Employee("Dawid", "Szcześniak", 123.0);
		
		List<Employee> employees1 = new ArrayList<Employee>();
		employees1.add(employee1);
		employees1.add(employee2);
		employees1.add(employee3);
		List<Employee> employees2 = new ArrayList<Employee>();
		employees2.add(employee2);
		employees2.add(employee4);
		employees2.add(employee5);
		
		project1.setEmployees(employees1);
		project2.setEmployees(employees2);
		
		entityManager.getTransaction().begin();
		entityManager.persist(project1);
		entityManager.persist(project2);
		entityManager.persist(employee1);
		entityManager.persist(employee2);
		entityManager.persist(employee3);
		entityManager.persist(employee4);
		entityManager.persist(employee5);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
