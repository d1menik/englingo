package com.app.web.repository;

import com.app.web.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByRoleType(String roleType);

}
