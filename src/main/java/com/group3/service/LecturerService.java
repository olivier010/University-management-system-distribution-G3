package com.group3.service;

import com.group3.dao.LecturerDAO;
import com.group3.entity.Lecturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
// below java block code is about lecturer service
public class LecturerService {

    @Autowired
    private LecturerDAO lecturerDAO;

    public List<Lecturer> getLecturers(int page, int size) {
        return lecturerDAO.findAll(page, size);
    }

    public long getLecturerCount() {
        return lecturerDAO.count();
    }

    public void saveLecturer(Lecturer lecturer) {
        lecturerDAO.save(lecturer);
    }

    public Lecturer getLecturer(Long id) {
        return lecturerDAO.findById(id);
    }

    public void updateLecturer(Lecturer lecturer) {
        lecturerDAO.update(lecturer);
    }

    public void deleteLecturer(Long id) {
        lecturerDAO.delete(id);
    }
}

