package net.javaguides.departmentservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.javaguides.departmentservice.entity.Department;

public interface DepartmentRepository extends MongoRepository<Department, Long>{
	
	Optional<Department> findByDepartmentCode(String departmentCode);
	
	Optional<Department> findByDepartmentDescription(String departmentDescription);

}