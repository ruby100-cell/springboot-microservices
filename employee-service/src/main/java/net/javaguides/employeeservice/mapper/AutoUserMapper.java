package net.javaguides.employeeservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;

@Mapper
public interface AutoUserMapper {
	
	AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
	Employee mapToEmployee(EmployeeDto employeeDto);
	EmployeeDto mapToEmployeeDto(Employee employee);

}
