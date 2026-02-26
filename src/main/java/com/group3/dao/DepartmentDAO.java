package com.group3.dao;

import com.group3.entity.Department;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Repository
public class DepartmentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Department> findAll() {
        TypedQuery<Department> query = entityManager.createQuery("FROM Department d ORDER BY d.name", Department.class);
        return query.getResultList();
    }

    public List<Department> findAll(int page, int size) {
        TypedQuery<Department> query = entityManager.createQuery("FROM Department d ORDER BY d.name", Department.class);
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query.getResultList();
    }

    public long count() {
        return entityManager.createQuery("SELECT COUNT(d) FROM Department d", Long.class).getSingleResult();
    }

    public void save(Department department) {
        entityManager.persist(department);
    }

    public Department findById(Long id) {
        return entityManager.find(Department.class, id);
    }

    public void update(Department department) {
        entityManager.merge(department);
    }

    public void delete(Long id) {
        Department department = findById(id);
        if (department != null) {
            entityManager.remove(department);
        }
    }
}
