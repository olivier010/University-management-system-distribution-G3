package com.group3.dao;

import com.group3.entity.Student;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Repository
public class StudentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Student> findAll(int page, int size) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student s ORDER BY s.lastName", Student.class);
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query.getResultList();
    }

    public long count() {
        return entityManager.createQuery("SELECT COUNT(s) FROM Student s", Long.class).getSingleResult();
    }

    public void save(Student student) {
        entityManager.persist(student);
    }

    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public void update(Student student) {
        entityManager.merge(student);
    }

    public void delete(Long id) {
        Student student = findById(id);
        if (student != null) {
            entityManager.remove(student);
        }
    }
}

