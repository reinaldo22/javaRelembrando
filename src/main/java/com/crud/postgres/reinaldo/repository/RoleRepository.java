package com.crud.postgres.reinaldo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.postgres.reinaldo.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {


}
