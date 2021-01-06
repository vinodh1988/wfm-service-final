package com.rest.wfm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rest.wfm.entity.Profile;




@RepositoryRestResource(collectionResourceRel = "profiles", path = "profiles")
public interface ProfileRepository extends JpaRepository<Profile,Long>{

}
