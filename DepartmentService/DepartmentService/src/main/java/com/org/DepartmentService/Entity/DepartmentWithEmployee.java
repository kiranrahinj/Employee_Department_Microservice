package com.org.DepartmentService.Entity;

import java.util.List;
import java.util.Optional;

public record DepartmentWithEmployee(Department department, List<Employee> employees) {
}
