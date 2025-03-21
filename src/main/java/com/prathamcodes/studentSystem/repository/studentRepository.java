package com.prathamcodes.studentSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prathamcodes.studentSystem.model.student;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends JpaRepository<student, Integer> {
}
