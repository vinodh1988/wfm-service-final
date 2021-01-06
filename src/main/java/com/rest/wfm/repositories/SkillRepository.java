package com.rest.wfm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rest.wfm.entity.Skills;

@RepositoryRestResource(collectionResourceRel = "skills", path = "skills")
public interface SkillRepository extends JpaRepository<Skills, Long> {
   
	
}
