package com.group3.dao;

import com.group3.entity.Lecturer;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Repository
public class LecturerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Lecturer> findAll(int page, int size) {
        TypedQuery<Lecturer> query = entityManager.createQuery("FROM Lecturer l ORDER BY l.lastName", Lecturer.class);
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query.getResultList();
    }

    public long count() {
        return entityManager.createQuery("SELECT COUNT(l) FROM Lecturer l", Long.class).getSingleResult();
    }

    public void save(Lecturer lecturer) {
        entityManager.persist(lecturer);
    }

    public Lecturer findById(Long id) {
        return entityManager.find(Lecturer.class, id);
    }

    public void update(Lecturer lecturer) {
        entityManager.merge(lecturer);
    }

    public void delete(Long id) {
        Lecturer lecturer = findById(id);
        if (lecturer != null) {
            entityManager.remove(lecturer);
        }
    }
}

