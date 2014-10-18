package info.owczarek.jpa;

import info.owczarek.jpa.domain.Professor;
import info.owczarek.jpa.domain.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Professor professor = new Professor();
		professor.setFirstName("Jan");
		professor.setLastName("Nowak");
		professor.setSalary(7563.0);
		
		Student student = new Student();
		student.setFirstName("Marek");
		student.setLastName("Kowalski");
		student.setAverageGrade(4.75);
		
		entityManager.getTransaction().begin();
		entityManager.persist(professor);
		entityManager.persist(student);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
