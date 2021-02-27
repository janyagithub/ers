package com.janya.mvrg.ers.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.janya.mvrg.ers.enitity.MasterCollegeEntity;

@Repository
public interface MasterCollegeRepository extends JpaRepository<MasterCollegeEntity, Long> {
}