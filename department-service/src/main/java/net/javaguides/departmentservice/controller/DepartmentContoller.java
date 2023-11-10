package net.javaguides.departmentservice.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.exception.ErrorDetails;
import net.javaguides.departmentservice.exception.ResourceNotFoundException;
import net.javaguides.departmentservice.service.DepartmentService;

@Tag(
		name = "Department Service - DepartmentController",
		description = "Department Controller exposes Rest Api's for Department-Service"
		)
@RestController
@RequestMapping("/api/departments")
public class DepartmentContoller {
	
	@Autowired
	private DepartmentService departmentService;
	
	@Operation(
			summary = "Saved Department Rest Api",
			description = "Save Department Rest Api is used to save department object in a database"
			)
	@ApiResponse(
			responseCode = "201",
			description = "Http Status 201 CREATED"
			)
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
		DepartmentDto saveDepartment = departmentService.saveDepartment(departmentDto);
		return new ResponseEntity<DepartmentDto>(saveDepartment, HttpStatus.CREATED);
	}
	
	@Operation(
			summary = "Get Department Rest Api",
			description = "Get Department Rest Api is used to get a department object from the database"
			)
	@ApiResponse(
			responseCode = "200",
			description = "Http Status 200 OK"
			)
	@GetMapping("{departmentCode}")
	public ResponseEntity<DepartmentDto> getDepartment(@PathVariable String departmentCode){
		DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
		return new ResponseEntity<DepartmentDto>(departmentDto, HttpStatus.OK);	
	}

}