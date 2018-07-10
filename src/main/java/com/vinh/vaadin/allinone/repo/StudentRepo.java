package com.vinh.vaadin.allinone.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinh.vaadin.allinone.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{
	List<Student> findByLastName(String name);
}
