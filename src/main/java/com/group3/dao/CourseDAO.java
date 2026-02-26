package com.group3.dao;

import com.group3.entity.Course;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Repository
public class CourseDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Course> findAll(int page, int size) {
        TypedQuery<Course> query = entityManager.createQuery("FROM Course c ORDER BY c.courseName", Course.class);
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query.getResultList();
    }

    public long count() {
        return entityManager.createQuery("SELECT COUNT(c) FROM Course c", Long.class).getSingleResult();
    }

    public void save(Course course) {
        entityManager.persist(course);
    }

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public void update(Course course) {
        entityManager.merge(course);
    }

    public void delete(Long id) {
        Course course = findById(id);
        if (course != null) {
            entityManager.remove(course);
        }
    }
}

