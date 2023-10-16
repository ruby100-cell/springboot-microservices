package net.javaguides.departmentservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.javaguides.departmentservice.entity.Department;

public interface DepartmentRepository extends MongoRepository<Department, Long>{
	
	Department findByDepartmentCode(String departmentCode);

}