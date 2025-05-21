package com.org.DepartmentService.Service;

import com.org.DepartmentService.Client.EmployeeClient;
import com.org.DepartmentService.Entity.Department;
import com.org.DepartmentService.Entity.DepartmentWithEmployee;
import com.org.DepartmentService.Entity.Employee;
import com.org.DepartmentService.Repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeClient employeeClient;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeClient employeeClient) {
        this.departmentRepository = departmentRepository;
        this.employeeClient = employeeClient;
    }

    public List<DepartmentWithEmployee> findAll(){
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentWithEmployee> result = new ArrayList<>();

        for(Department department : departments){
            int id=department.getId();
            List<Employee>temp=employeeClient.getEmployeeByDeptId(id).getBody();
            result.add(new DepartmentWithEmployee(department,temp));
        }
//        return departments.stream()
//                .map(dept -> {
//                    List<Employee> employees = Optional.ofNullable(employeeClient.getEmployeeByDeptId(dept.getId()).getBody())
//                            .orElse(Collections.emptyList());
//                    return new DepartmentWithEmployee(dept, employees);
//                })
//                .collect(Collectors.toList());

        return result;
    }


    public DepartmentWithEmployee getDepartmentById(int id){
        Department departments = departmentRepository.findById(id).get();
        List<Employee> employees= employeeClient.getEmployeeByDeptId(id).getBody();

       return new DepartmentWithEmployee(departments,employees);
    }
}
