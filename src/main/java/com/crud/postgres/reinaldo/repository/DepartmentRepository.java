package com.crud.postgres.reinaldo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.postgres.reinaldo.model.Department;
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
