package com.rest.wfm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rest.wfm.entity.Employee;

@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
   @Query("from Employee where lockstatus='not_requested' and manager!=:user")
	public List<Employee> getEmployees(@Param("user") String user);
}
