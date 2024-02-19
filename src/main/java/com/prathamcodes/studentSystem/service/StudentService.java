package com.prathamcodes.studentSystem.service;

import com.prathamcodes.studentSystem.model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
}
