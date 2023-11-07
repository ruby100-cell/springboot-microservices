package net.javaguides.organizationservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.javaguides.organizationservice.entity.Organization;

public interface OrganizationRepository extends MongoRepository<Organization, Long>{
	
	Organization findByOrganizationCode(String organizationCode);

}
