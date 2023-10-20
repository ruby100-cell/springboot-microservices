package net.javaguides.employeeservice.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import net.javaguides.employeeservice.dto.APIResponseDto;
import net.javaguides.employeeservice.dto.DepartmentDto;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.exception.EmailAlreadyExistsException;
import net.javaguides.employeeservice.exception.ResourceNotFoundException;
import net.javaguides.employeeservice.mapper.AutoUserMapper;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.APIClient;
import net.javaguides.employeeservice.service.EmployeeService;

@Service
public class EmployeeServiceimpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
//	@Autowired
//	private RestTemplate restTemplate;
	
//	@Autowired
//	private WebClient webClient;
	
	@Autowired
	private APIClient apiClient;

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
	public APIResponseDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee", "EmployeeId", employeeId)
				);
//		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
//				DepartmentDto.class);
//		DepartmentDto departmentDto = responseEntity.getBody();
		
//		DepartmentDto departmentDto = webClient.get().uri("http://localhost:8080/api/departments/"+ employee.getDepartmentCode()).
//		retrieve()
//		.bodyToMono(DepartmentDto.class)
//		.block();
		
		DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
		
//		EmployeeDto employeeDto = new EmployeeDto(employee.getId(), 
//				employee.getFirstName(), employee.getLastName(), employee.getEmail());
		
//		EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
		EmployeeDto employeeDto = AutoUserMapper.MAPPER.mapToEmployeeDto(employee);
		
		APIResponseDto apiResponseDTO = new APIResponseDto();
		apiResponseDTO.setDepartmentDto(departmentDto);
		apiResponseDTO.setEmployeeDto(employeeDto);
		
		return apiResponseDTO;
	}
	
	

}
