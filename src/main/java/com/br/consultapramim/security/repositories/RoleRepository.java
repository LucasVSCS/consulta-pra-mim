package com.br.consultapramim.security.repositories;

import com.br.consultapramim.security.domains.Role;
import com.br.consultapramim.security.domains.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnum name);
}
