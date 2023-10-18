package net.javaguides.departmentservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.entity.Department;

@Mapper
public interface AutoUserMapper {
	
	AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
	
	Department mapToDepartment(DepartmentDto departmentDto);
	DepartmentDto mapToDepartmentDto(Department dpartment);

}
