package net.javaguides.employeeservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.javaguides.employeeservice.entity.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Long>{
	
	Optional<Employee> findByEmail(String email);

}
