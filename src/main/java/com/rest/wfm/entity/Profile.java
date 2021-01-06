package com.rest.wfm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Profile {
  @Id
    private Integer profile_id;
  @Column
    private String name;
  
public Integer getProfile_id() {
	return profile_id;
}
public void setProfile_id(Integer profile_id) {
	this.profile_id = profile_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
  
  
}
