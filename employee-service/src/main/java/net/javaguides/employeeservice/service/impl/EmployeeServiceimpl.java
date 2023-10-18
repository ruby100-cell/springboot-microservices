package net.javaguides.employeeservice.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.exception.EmailAlreadyExistsException;
import net.javaguides.employeeservice.exception.ResourceNotFoundException;
import net.javaguides.employeeservice.mapper.AutoUserMapper;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.EmployeeService;

@Service
public class EmployeeServiceimpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
//		Employee employee = new Employee(employeeDto.getId(),
//				employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getEmail());
		
//		Employee employee = modelMapper.map(employeeDto, Employee.class);
		Optional<Employee> optionalEmployee = employeeRepository.findByEmail(employeeDto.getEmail());
		if(optionalEmployee.isPresent()) {
			throw new EmailAlreadyExistsException("Email Already Exists");
		}
		
		Employee employee = AutoUserMapper.MAPPER.mapToEmployee(employeeDto);
		
		Employee saveEmployee = employeeRepository.save(employee);
		
//		EmployeeDto savedEmployeeDto = new EmployeeDto(saveEmployee.getId(),
//				saveEmployee.getFirstName(), saveEmployee.getLastName(), saveEmployee.getEmail());
		
//		EmployeeDto savedEmployeeDto = modelMapper.map(saveEmployee, EmployeeDto.class);
		
		EmployeeDto savedEmployeeDto = AutoUserMapper.MAPPER.mapToEmployeeDto(saveEmployee);
		
		return savedEmployeeDto;
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "EmployeeId", employeeId)
				);
//		EmployeeDto employeeDto = new EmployeeDto(employee.getId(), 
//				employee.getFirstName(), employee.getLastName(), employee.getEmail());
		
//		EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
		EmployeeDto employeeDto = AutoUserMapper.MAPPER.mapToEmployeeDto(employee);
		return employeeDto;
	}
	
	

}
