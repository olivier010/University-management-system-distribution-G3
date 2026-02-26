package com.group3.service;

import com.group3.dao.InstitutionDAO;
import com.group3.entity.Institution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InstitutionService {

    @Autowired
    private InstitutionDAO institutionDAO;

    public void saveInstitution(Institution institution) {
        institutionDAO.save(institution);
    }

    public Institution getInstitution(Long id) {
        return institutionDAO.findById(id);
    }
}

