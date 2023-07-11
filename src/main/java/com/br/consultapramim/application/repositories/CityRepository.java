package com.br.consultapramim.application.repositories;

import com.br.consultapramim.application.domains.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    @Query("select c from City c where unaccent(upper(c.name)) like CONCAT('%', unaccent(upper(?1)), '%') order by c.name asc")
    List<City> findByNameLikeIgnoreCase(@NonNull String name);
}