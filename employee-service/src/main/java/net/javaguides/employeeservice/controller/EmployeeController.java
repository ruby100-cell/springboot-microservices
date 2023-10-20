package net.javaguides.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.employeeservice.dto.APIResponseDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto saveEmployee = employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping("{employeeId}")
	public ResponseEntity<APIResponseDto> getEmployee(@PathVariable Long employeeId){
		APIResponseDto apiResponseDTO = employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<APIResponseDto>(apiResponseDTO, HttpStatus.OK);
	}

}
