package com.janya.mvrg.ers.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.janya.mvrg.ers.enitity.StudentRegistrationEntity;

@Repository
public interface StudentRegistrationRepository extends CrudRepository<StudentRegistrationEntity, Long> {

	@Query(value = "SELECT * FROM STUDENT_REGISTRATION_ENTITY u WHERE u.CLG_ID = :clg_id", 
			  nativeQuery = true) 
	Page<StudentRegistrationEntity> listCollegeStudentRegDetail(Pageable pageable, @Param("clg_id") long clg_id);
}

