package net.javaguides.employeeservice.dto;

public class APIResponseDto {
	
	private EmployeeDto employeeDto;
	private DepartmentDto departmentDto;
	public APIResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public APIResponseDto(EmployeeDto employeeDto, DepartmentDto departmentDto) {
		super();
		this.employeeDto = employeeDto;
		this.departmentDto = departmentDto;
	}
	public EmployeeDto getEmployeeDto() {
		return employeeDto;
	}
	public void setEmployeeDto(EmployeeDto employeeDto) {
		this.employeeDto = employeeDto;
	}
	public DepartmentDto getDepartmentDto() {
		return departmentDto;
	}
	public void setDepartmentDto(DepartmentDto departmentDto) {
		this.departmentDto = departmentDto;
	}
	
}
