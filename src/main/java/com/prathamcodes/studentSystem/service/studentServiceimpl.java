package com.prathamcodes.studentSystem.service;

import com.prathamcodes.studentSystem.model.student;
import org.springframework.beans.factory.annotation.Autowired;
import com.prathamcodes.studentSystem.repository.studentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class  studentServiceimpl implements studentService {

    @Autowired
    private studentRepository studentRepository;
    @Override
    public student savestudent(student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<student> getAllstudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<student> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public Optional<student> updateStudent(int id, student updatedStudent) {
        return studentRepository.findById(id).map(existingStudent -> {
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setAddress(updatedStudent.getAddress());
            return studentRepository.save(existingStudent);
        });
    }

    @Override
    public boolean deletestudent(int id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
