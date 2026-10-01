package com.as.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.Entity.Faculty;

public interface IFacultyRepo extends JpaRepository<Faculty, Integer> {

}
