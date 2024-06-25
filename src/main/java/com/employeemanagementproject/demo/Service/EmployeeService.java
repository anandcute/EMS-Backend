package com.employeemanagementproject.demo.Service;

import java.util.List;

import com.employeemanagementproject.demo.dto.EmployeeDto;

public interface EmployeeService  {
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Integer employeeId);

	List<EmployeeDto> getAllEmployee();
	
	EmployeeDto updatedEmployee(Integer employeeId , EmployeeDto updatedEmployee);
	
	void deleteEmployee(Integer employeeId);
}
