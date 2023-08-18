package com.example.springdata.emp.persistence;


import com.example.model.EmpData;

import java.util.List;

public interface EmpDao {

    public List<EmpData> getAllEmps(String deptName);
}
