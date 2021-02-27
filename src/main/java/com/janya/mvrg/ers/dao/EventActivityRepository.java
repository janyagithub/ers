package com.janya.mvrg.ers.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.janya.mvrg.ers.enitity.EventActivityEntity;

@Repository
public interface EventActivityRepository extends JpaRepository<EventActivityEntity, Long> {

	@Query("SELECT me.eventName, clg.clgName, me.eventLoc,  ma.name, eae.winner, eae.runner, eae.details, eae.pic "//
			+ "FROM EventActivityEntity eae " + "JOIN eae.MasterEventEntity me "//
			+ "JOIN me.createdByMasterCollegeEntity clg " + "JOIN eae.masterActivityEntity ma "
			+ "where me.id = :eventId") //
	Page<Object[]> getEventResultByEventId(@Param("eventId") Long eventId, Pageable pageable);

	@Query("SELECT count(*) FROM EventActivityEntity e where e.MasterEventEntity.id = :eventId")
	int countByEventId(@Param("eventId") Long eventId);

}