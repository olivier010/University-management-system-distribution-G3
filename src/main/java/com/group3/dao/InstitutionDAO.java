package com.group3.dao;

import com.group3.entity.Institution;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class InstitutionDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Institution institution) {
        entityManager.persist(institution);
    }

    public Institution findById(Long id) {
        return entityManager.find(Institution.class, id);
    }
}

