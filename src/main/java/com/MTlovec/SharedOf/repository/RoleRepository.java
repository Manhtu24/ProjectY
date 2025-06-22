package com.MTlovec.SharedOf.repository;

import com.MTlovec.SharedOf.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * Find a role by its name.
     *
     * @param roleName the name of the role
     * @return the role if found, otherwise null
     */
    Role findByRoleName(String roleName);
}
