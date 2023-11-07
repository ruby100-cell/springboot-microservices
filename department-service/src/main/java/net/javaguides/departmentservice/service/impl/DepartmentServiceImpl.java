package net.javaguides.departmentservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.web.client.ResourceAccessException;

import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.exception.DepartmentAlreadyExistException;
import net.javaguides.departmentservice.exception.ResourceNotFoundException;
import net.javaguides.departmentservice.mapper.AutoUserMapper;
import net.javaguides.departmentservice.mapper.DepartmentMapper;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import net.javaguides.departmentservice.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
//		Department department = new Department(departmentDto.getId(),
//				departmentDto.getDepartmentName(), departmentDto.getDepartmentDescription(),
//				departmentDto.getDepartmentCode());
		
//		Department department = modelMapper.map(departmentDto, Department.class);
		Optional<Department> optionalDepartment = departmentRepository.findByDepartmentDescription(departmentDto.getDepartmentDescription());
		if(optionalDepartment.isPresent()) {
			throw new DepartmentAlreadyExistException("Department Already Exists");
		}
		
//		Department department = AutoUserMapper.MAPPER.mapToDepartment(departmentDto);
		
		Department department = DepartmentMapper.mapToDepartment(departmentDto);
		
		Department savedDepartment = departmentRepository.save(department);
		
//		DepartmentDto savedDepartmentDto = new DepartmentDto(savedDepartment.getId(), 
//				savedDepartment.getDepartmentName(), savedDepartment.getDepartmentDescription(), 
//				savedDepartment.getDepartmentCode());
		
//		DepartmentDto savedDepartmentDto = modelMapper.map(department, DepartmentDto.class);
		
//		DepartmentDto savedDepartmentDto = AutoUserMapper.MAPPER.mapToDepartmentDto(savedDepartment);
		
		DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);
		return savedDepartmentDto;
	}

	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {
		Department department = departmentRepository.findByDepartmentCode(departmentCode).
				orElseThrow(
						()-> new ResourceNotFoundException("Department", "departmentCode", departmentCode) 
						);
//		DepartmentDto departmentDto = new DepartmentDto(department.getId(), 
//				department.getDepartmentName(), department.getDepartmentDescription(), 
//				department.getDepartmentCode());
		
//		DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);
		
//		DepartmentDto departmentDto = AutoUserMapper.MAPPER.mapToDepartmentDto(department);
		
		DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);
		
		return departmentDto;
	}

}