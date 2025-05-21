package com.org.DepartmentService.Repository;

import com.org.DepartmentService.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
