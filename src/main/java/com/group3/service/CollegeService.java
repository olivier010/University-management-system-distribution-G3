package com.group3.service;

import com.group3.dao.CollegeDAO;
import com.group3.entity.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CollegeService {

    @Autowired
    private CollegeDAO collegeDAO;

    public void saveCollege(College college) {
        collegeDAO.save(college);
    }

    public List<College> getAllColleges() {
        return collegeDAO.findAll();
    }

    public College getCollege(Long id) {
        return collegeDAO.findById(id);
    }
}

