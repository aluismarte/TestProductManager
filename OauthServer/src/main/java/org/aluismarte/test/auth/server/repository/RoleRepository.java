package org.aluismarte.test.auth.server.repository;

import org.aluismarte.test.auth.server.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Aluis on 10/21/2021.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
