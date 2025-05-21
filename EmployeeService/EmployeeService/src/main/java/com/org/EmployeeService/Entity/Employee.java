package com.org.EmployeeService.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table( name = "employee",
        uniqueConstraints = @UniqueConstraint(columnNames = "email"),
        indexes= {
                @Index(name = "idx_name", columnList = "name", unique = true),
                @Index(name = "idx_phone", columnList = "phone")
        })
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String phone;
    private String email;
    public int deptId;

}
