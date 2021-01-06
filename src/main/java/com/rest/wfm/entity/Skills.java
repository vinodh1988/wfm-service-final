package com.rest.wfm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Skills {
  @Id
    private Integer skillid;
  @Column
    private String name;
public Integer getSkillid() {
	return skillid;
}
public void setSkillid(Integer skillid) {
	this.skillid = skillid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
  
  
}
