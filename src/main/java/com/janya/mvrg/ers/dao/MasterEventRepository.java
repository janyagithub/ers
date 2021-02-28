package com.janya.mvrg.ers.dao;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.janya.mvrg.ers.enitity.MasterEventEntity;

@Repository
public interface MasterEventRepository extends JpaRepository<MasterEventEntity, Long> {

	@Query("SELECT new com.janya.mvrg.ers.enitity.MasterEventEntity(mee.id, mee.eventName) "//
			+ "FROM MasterEventEntity mee WHERE mee.startDate > :today " + "ORDER BY mee.startDate DESC") //
	Page<MasterEventEntity> getUpComingEvents(Pageable pageable, @Param("today") Date date);

	@Query("SELECT new com.janya.mvrg.ers.enitity.MasterEventEntity(mee.id, mee.eventName, mee.eventCorrosalpic) "//
			+ "FROM MasterEventEntity mee " + "WHERE mee.endDate < :today") //
	Page<MasterEventEntity> getLastEvents(Pageable pageable, @Param("today") Date date);

}