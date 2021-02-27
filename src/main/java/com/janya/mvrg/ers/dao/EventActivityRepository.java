package com.janya.mvrg.ers.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.janya.mvrg.ers.enitity.EventActivityEntity;

@Repository
public interface EventActivityRepository extends CrudRepository<EventActivityEntity, Long> {

	@Query("SELECT me.eventName, clg.clgName, me.eventLoc,  ma.name, eae.winner, eae.runner "//
			+ "FROM EventActivityEntity eae " + "JOIN eae.MasterEventEntity me "//
			+ "JOIN me.createdByMasterCollegeEntity clg " + "JOIN eae.masterActivityEntity ma "
			+ "where me.id = :eventId") //
	List<Object[]> getEventResultByEventId(@Param("eventId") Long eventId);

}