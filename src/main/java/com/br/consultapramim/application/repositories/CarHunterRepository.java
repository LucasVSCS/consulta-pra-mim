package com.br.consultapramim.application.repositories;

import com.br.consultapramim.application.domains.CarHunter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarHunterRepository extends JpaRepository<CarHunter, Long>, JpaSpecificationExecutor<CarHunter> {
    CarHunter findByExternalId(UUID externalId);
}
