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

import net.javaguides.organizationservice.dto.OrganizationDto;
import net.javaguides.organizationservice.service.OrganizationService;

@RestController
@RequestMapping("api/organizations")
public class OrganizationController {
	
	@Autowired
	private OrganizationService organizationService;
	
	@PostMapping
	public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
		OrganizationDto saveOrganization = organizationService.saveOrganization(organizationDto);
		return new ResponseEntity<OrganizationDto>(saveOrganization, HttpStatus.CREATED);
	}
	
	@GetMapping("{orgnaizationCode}")
	public ResponseEntity<OrganizationDto> getOrganization(@PathVariable String orgnaizationCode){
		OrganizationDto organizationDto = organizationService.getOrganizationByCode(orgnaizationCode);
		return ResponseEntity.ok(organizationDto);
	}

}
