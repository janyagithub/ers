package com.janya.mvrg.ers.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.janya.mvrg.ers.enitity.Student;

@Repository
public interface StudentRepository extends CrudRepository <Student, Long> { 
    List<Student> findByName(String name); 
}