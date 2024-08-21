package com.cg.in.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.in.entity.Student;
//import com.cg.in.entity.User;

public interface StudentRepository extends JpaRepository<Student, Long> {
   // Optional<User> findByUsername(String username);
}
