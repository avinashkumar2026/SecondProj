package com.as.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.Entity.Student;

public interface IStudentRepo extends JpaRepository<Student, Integer> {

}
