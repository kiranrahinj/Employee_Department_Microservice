package com.org.EmployeeService.Controller;

import com.org.EmployeeService.Entity.Employee;
import com.org.EmployeeService.Service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class myController {
    private final EmployeeService employeeService;

    public myController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
      return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping("/deptId")
    public ResponseEntity<List<?>> getEmployeeByDeptId(@RequestParam  int deptId){
        return ResponseEntity.ok(employeeService.getEmployeeByDeptId(deptId));
    }


}
