package com.example.springdata.emp.service;

import com.example.model.EmpData;
import com.example.persistence.entity.Department;
import com.example.springdata.emp.exception.InputValidationException;

import java.util.List;
import java.util.Optional;

public interface DeptService {
	
	public Department saveDepartment(Department req) throws InputValidationException;

	public List<EmpData> getEmpsFromDept(String deptName);

	public Optional<Department> getDepartment(String name);

	public int updateDept(String hod, String deptName);
}
