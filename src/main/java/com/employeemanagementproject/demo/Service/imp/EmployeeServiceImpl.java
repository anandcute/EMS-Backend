package com.employeemanagementproject.demo.Service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.employeemanagementproject.demo.Service.EmployeeService;
import com.employeemanagementproject.demo.dto.EmployeeDto;
import com.employeemanagementproject.demo.entity.Employee;
import com.employeemanagementproject.demo.exception.ResourceNotFoundException;
import com.employeemanagementproject.demo.mapper.EmployeeMapper;
import com.employeemanagementproject.demo.repo.Empolyee_Repo;

//import lombok.AllArgsConstructor;

@Service
//@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	
	private Empolyee_Repo employeerepo;

	
	public EmployeeServiceImpl(Empolyee_Repo employeerepo) {
		super();
		this.employeerepo = employeerepo;
	}

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeerepo.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	

	@Override
	public EmployeeDto getEmployeeById(Integer employeeId) {
		Employee employee = employeerepo.findById(employeeId)
					.orElseThrow(() -> 
					new ResourceNotFoundException("Empolyee is not exist with give id : " + employeeId));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}


	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<Employee> employees = employeerepo.findAll();
		return employees.stream().map((employee) ->EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}


	@Override
	public EmployeeDto updatedEmployee(Integer employeeId, EmployeeDto updatedEmployee) {
		Employee employee = employeerepo.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not exists with given  id:" + employeeId));
		
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		
		Employee updateEmployeeObj = employeerepo.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updateEmployeeObj);
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		Employee employee = employeerepo.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not exists with given  id:" + employeeId));
		
		employeerepo.deleteById(employeeId);
		
	}

}
