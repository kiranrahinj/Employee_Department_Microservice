package com.org.DepartmentService.Entity;

import lombok.Builder;

import java.util.List;
import java.util.Optional;

@Builder
public record DepartmentWithEmployee(Department department, List<Employee> employees) {
}
