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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.javaguides.employeeservice.dto.APIResponseDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.service.EmployeeService;

@Tag(
		name = "Employee Service - EmployeeController",
		description = "Employee Controller exposes Rest Api's for Employee-Service"
		)
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Operation(
			summary = "Saved Employee Rest Api",
			description = "Save Employee Rest Api is used to save employee object in a database"
			)
	@ApiResponse(
			responseCode = "201",
			description = "Http Status 201 CREATED"
			)
	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto saveEmployee = employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
	}
	
	@Operation(
			summary = "Get Employee Rest Api",
			description = "Get Employee Rest Api is used to get a employee object from the database"
			)
	@ApiResponse(
			responseCode = "200",
			description = "Http Status 200 OK"
			)
	@GetMapping("{employeeId}")
	public ResponseEntity<APIResponseDto> getEmployee(@PathVariable Long employeeId){
		APIResponseDto apiResponseDTO = employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<APIResponseDto>(apiResponseDTO, HttpStatus.OK);
	}

}
