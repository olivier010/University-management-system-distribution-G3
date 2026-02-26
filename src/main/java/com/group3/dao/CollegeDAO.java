package com.group3.dao;

import com.group3.entity.College;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Repository
public class CollegeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<College> findAll() {
        TypedQuery<College> query = entityManager.createQuery("FROM College c ORDER BY c.name", College.class);
        return query.getResultList();
    }

    public void save(College college) {
        entityManager.persist(college);
    }

    public College findById(Long id) {
        return entityManager.find(College.class, id);
    }
}
