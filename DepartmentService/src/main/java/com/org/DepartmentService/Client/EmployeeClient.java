package com.org.DepartmentService.Client;

import com.org.DepartmentService.Entity.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("EMPLOYEE-SERVICE")
@Service
public interface EmployeeClient {

    @GetMapping("/employee/deptId")
    public ResponseEntity<List<Employee>> getEmployeeByDeptId(@RequestParam int deptId);
}
