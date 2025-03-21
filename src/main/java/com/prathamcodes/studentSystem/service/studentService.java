package com.prathamcodes.studentSystem.service;

import com.prathamcodes.studentSystem.model.student;

import java.util.List;
import java.util.Optional;

public interface studentService {
    public student savestudent(student student);

    public List<student> getAllstudents();

    public Optional<student> getStudentById(int id);

    public Optional<student> updateStudent(int id, student updatedStudent);

    public boolean deletestudent(int id);

}


