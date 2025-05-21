package com.org.DepartmentService.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "department",
        indexes=@Index(name = "idx_name",columnList = "name",unique = true)
)
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
}
