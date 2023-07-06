package com.br.consultapramim.repositories;

import com.br.consultapramim.domains.CarHunter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarHunterRepository extends JpaRepository<CarHunter, Long> {
}
