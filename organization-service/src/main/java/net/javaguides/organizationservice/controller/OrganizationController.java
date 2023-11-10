package net.javaguides.organizationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.javaguides.organizationservice.dto.OrganizationDto;
import net.javaguides.organizationservice.service.OrganizationService;

@Tag(
	name = "Organization Service - OrganizationController",
	description = "OrganizationController exposes Rest Api's for Organization Service"
	)
@RestController
@RequestMapping("api/organizations")
public class OrganizationController {
	
	@Autowired
	private OrganizationService organizationService;
	
	@Operation(
			summary = "Saved Organization Rest Api",
			description = "Save Organization Rest Api is used to save department object in a database"
			)
	@ApiResponse(
			responseCode = "201",
			description = "Http Status 201 CREATED"
			)
	@PostMapping
	public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
		OrganizationDto saveOrganization = organizationService.saveOrganization(organizationDto);
		return new ResponseEntity<OrganizationDto>(saveOrganization, HttpStatus.CREATED);
	}
	
	@Operation(
			summary = "Get Organization Rest Api",
			description = "Get Organization Rest Api is used to get a department object from the database"
			)
	@ApiResponse(
			responseCode = "200",
			description = "Http Status 200 OK"
			)
	@GetMapping("{orgnaizationCode}")
	public ResponseEntity<OrganizationDto> getOrganization(@PathVariable String orgnaizationCode){
		OrganizationDto organizationDto = organizationService.getOrganizationByCode(orgnaizationCode);
		return ResponseEntity.ok(organizationDto);
	}

}
