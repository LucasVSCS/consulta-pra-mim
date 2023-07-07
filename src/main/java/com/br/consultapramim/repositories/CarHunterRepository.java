package com.br.consultapramim.repositories;

import com.br.consultapramim.domains.CarHunter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarHunterRepository extends JpaRepository<CarHunter, Long>, JpaSpecificationExecutor<CarHunter> {
    CarHunter findByExternalId(UUID externalId);
}
