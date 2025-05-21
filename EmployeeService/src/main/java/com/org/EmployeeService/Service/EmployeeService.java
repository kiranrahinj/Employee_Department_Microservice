package com.org.EmployeeService.Service;

import com.org.EmployeeService.Entity.Employee;
import com.org.EmployeeService.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private  final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    public Employee getEmployeeById(int id){
        return employeeRepository.findById(id).get();
    }
    public List<Employee> getEmployeeByDeptId(int deptId){
        return employeeRepository.findEmployeeDepartmentByDeptId(deptId);
    }
}
