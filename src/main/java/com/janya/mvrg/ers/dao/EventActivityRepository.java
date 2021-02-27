package com.janya.mvrg.ers.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.janya.mvrg.ers.enitity.EventActivityEntity;

@Repository
public interface EventActivityRepository extends CrudRepository<EventActivityEntity, Long> {
	
	
}