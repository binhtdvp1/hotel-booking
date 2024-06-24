package com.hrs.booking.repository;

import com.hrs.booking.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByRoleCodeAndActiveFlag(String roleCode, int activeFlag);
}
