package com.rest.wfm.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Employee {
	@Id
	private Long employee_id;
	@Column
	private String name;
	@Column
	private String wfm_manager;
	@Column
	private String status;
	@Column
	private String manager;
	@Column
	private String email;
	@Column 
	private String lockstatus;
	@Column
	private Integer experience;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "skillmap", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "skillid"))
	private Set<Skills> skills;

	@ManyToOne
	@JoinColumn(name="profile_id")
	private Profile profile;
	
	
	
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Set<Skills> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skills> skills) {
		this.skills = skills;
	}
	
	

	public String getLockstatus() {
		return lockstatus;
	}

	public void setLockstatus(String lockstatus) {
		this.lockstatus = lockstatus;
	}

	public Long getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWfm_manager() {
		return wfm_manager;
	}

	public void setWfm_manager(String wfm_manager) {
		this.wfm_manager = wfm_manager;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	
}
