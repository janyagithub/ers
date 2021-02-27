package com.janya.mvrg.ers.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.janya.mvrg.ers.enitity.MasterEventEntity;

@Repository
public interface EventActivityRepository extends CrudRepository<MasterEventEntity, Long> {
}