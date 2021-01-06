package com.rest.wfm.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Softlock {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long lockid;
  @Column
  private Long employee_id;
  @Column
  private Date reqdate;
  @Column
  private Date lastupdated;
  @Column
  private String manager;
  @Column
  private String status;
  @Column
  private String requestmessage;
  @Column
  private String wfmremark;
  @Column
  private String managerstatus;
  @Column
  private String mgrstatuscomment;
  @Column
  private Date mgrlastupdate;
  
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "employee_id",insertable = false,updatable = false)
  private Employee employee;
  
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "manager",referencedColumnName = "username",insertable = false,updatable = false)
  private Users user;
  
public Long getLockid() {
	return lockid;
}
public void setLockid(Long lockid) {
	this.lockid = lockid;
}
public Long getEmployee_id() {
	return employee_id;
}
public void setEmployee_id(Long employee_id) {
	this.employee_id = employee_id;
}


public Date getReqdate() {
	return reqdate;
}
public void setReqdate(Date reqdate) {
	this.reqdate = reqdate;
}
public Date getLastupdated() {
	return lastupdated;
}
public void setLastupdated(Date lastupdated) {
	this.lastupdated = lastupdated;
}
public String getManager() {
	return manager;
}
public void setManager(String manager) {
	this.manager = manager;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Employee getEmployee() {
	return employee;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}
public Users getUser() {
	return user;
}
public void setUser(Users user) {
	this.user = user;
}
public String getRequestmessage() {
	return requestmessage;
}
public void setRequestmessage(String requestmessage) {
	this.requestmessage = requestmessage;
}
public String getWfmremark() {
	return wfmremark;
}
public void setWfmremark(String wfmremark) {
	this.wfmremark = wfmremark;
}


public String getManagerstatus() {
	return managerstatus;
}
public void setManagerstatus(String managerstatus) {
	this.managerstatus = managerstatus;
}
public String getMgrstatuscomment() {
	return mgrstatuscomment;
}
public void setMgrstatuscomment(String mgrstatuscomment) {
	this.mgrstatuscomment = mgrstatuscomment;
}
public Date getMgrlastupdate() {
	return mgrlastupdate;
}
public void setMgrlastupdate(Date mgrlastupdate) {
	this.mgrlastupdate = mgrlastupdate;
}
@Override
public String toString() {
	return "Softlock [lockid=" + lockid + ", employee_id=" + employee_id + ", reqdate=" + reqdate + ", lastupdated="
			+ lastupdated + ", manager=" + manager + ", status=" + status + "]";
}


  
}
