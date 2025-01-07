package com.joseaugustopaivajr.testesantander.infrastructure.adapter.repository;

import com.joseaugustopaivajr.testesantander.domain.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepositoryImpl extends JpaRepository<LogEntity, Long> {
}
