package com.iliasServices.fraud;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface FraudCechkHistoryRepository extends JpaRepository<FraudCeckHistory, CriteriaBuilder.In> {
}
