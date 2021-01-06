package com.rest.wfm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rest.wfm.entity.Softlock;

@RepositoryRestResource(collectionResourceRel = "locks", path = "locks")
public interface SoftlockRepository extends JpaRepository<Softlock,Long>{

	@Query("From Softlock where employee.wfm_manager=:user and status='waiting'")
	public List<Softlock> getLocks(@Param("user")String user );
	
	@Query("from Softlock where employee.wfm_manager=:user and status!='waiting'")
	public List<Softlock> getLocksNotActive(@Param("user")String user);
	
	@Query("from Softlock where manager=:user order by reqdate desc")
	public List<Softlock> getManagerLocksNotActive(@Param("user")String user);
    
    @Query(value="select * from softlock where datediff(now(),reqdate)>3 and"
    		+ " status='waiting'",nativeQuery = true)
	public List<Softlock> getExpired();
    
    @Query(value="select * from softlock where datediff(now(),lastupdated)>7 and"
    		+ " managerstatus='awaiting_approval'",nativeQuery = true)
	public List<Softlock> getUnAccepted();
    
    
    @Query(value="from Softlock where manager=:user and status='approved' and managerstatus='awaiting_approval'" )
    public List<Softlock> getApproved(@Param("user") String user);
}
