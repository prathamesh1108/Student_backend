package com.prathamcodes.studentSystem.controller;

import com.prathamcodes.studentSystem.model.student;
import com.prathamcodes.studentSystem.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;



import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
@CrossOrigin

public class studentController {
    @Autowired
    private studentService studentservice;

    // Add a new student
    @PostMapping("/add")
    public String add(@RequestBody student student) {
        studentservice.savestudent(student);
        return "New Student is Added";
    }

    // Get all students
    @GetMapping("/getAll")
    public List<student> getAll() {
        return studentservice.getAllstudents();
    }

    // Get a student by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<student> getStudentById(@PathVariable int id) {
        Optional<student> student = studentservice.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a student by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable int id, @RequestBody student updatedStudent) {
        Optional<student> student = studentservice.updateStudent(id, updatedStudent);
        if (student.isPresent()) {
            return ResponseEntity.ok("Student updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a student by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        boolean deleted = studentservice.deletestudent(id);
        if (deleted) {
            return ResponseEntity.ok("Student is Deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}