package com.example.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="DEPT")
public class Department {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    @JsonIgnore
    private Integer deptId;

    @Column(name="name")
    private String name;

    @Column(name="hod")
    private String hod;

    @Column(name="size")
    private Integer size;

    //One To Many Bidirectional mapping - Inverse or parent side
    // Without JsonIgnore in this bidirectional relation, json serialization leads to Jackson infinite recursion problem
    @OneToMany(mappedBy = "dept", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    List<Employee> emps = new ArrayList<>();

    public void addEmp(Employee e) {
        if(emps == null) {
            System.out.println("emps is null");
            emps = new ArrayList<>();
        }
        emps.add(e);
        //e.setDept(this);

    }
    public void removeEmp(Employee e) {
        emps.remove(e);
        //e.setDept(null);
    }
}
