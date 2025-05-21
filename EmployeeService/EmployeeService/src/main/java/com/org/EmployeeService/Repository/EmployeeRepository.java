package com.org.EmployeeService.Repository;

import com.org.EmployeeService.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public abstract List<Employee> findEmployeeDepartmentByDeptId(int deptId);
}
