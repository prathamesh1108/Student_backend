package com.prathamcodes.studentSystem.service;

import com.prathamcodes.studentSystem.model.Student;
import com.prathamcodes.studentSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository StudentRepository;

    @Override
    public Student saveStudent(Student student) {
        return StudentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return StudentRepository.findAll();
    }
}
