package net.javaguides.employeeservice.service;

import java.util.Optional;

import net.javaguides.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto saveEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Long employeeId);

}
