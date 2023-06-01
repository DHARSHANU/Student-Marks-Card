package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Student;


public class Studentdao {
	
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction  = entityManager.getTransaction();
	
	public void update(Student st) {
		entityTransaction.begin();
		entityManager.persist(st);
		entityTransaction.commit();
	}
	
	public Student find(String email) {
		List<Student> list = entityManager.createQuery("select x from  student x where email=?2").setParameter(2, email)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public Student find(int empreg) {
		return entityManager.find(Student.class, empreg);
	}

	public Student find(long mobile) {
		List<Student> list = entityManager.createQuery("select x from student x where mobile=?1").setParameter(1, mobile)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}}

	
	
		public void update1(Student student) {
			entityTransaction.begin();
			entityManager.merge(student);
			entityTransaction.commit();
		}
		
		
		public List<Student> fetchall() {
			return entityManager.createQuery("select x from student x ").getResultList();
		}
		
		
	}