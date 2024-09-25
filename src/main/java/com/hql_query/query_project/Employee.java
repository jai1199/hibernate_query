package com.hql_query.query_project;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee 
{
	@Id
   private int eid;
   private String ename;
   private String department;
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
@Override
public String toString() {
	return "Employee [eid=" + eid + ", ename=" + ename + ", department=" + department + "]";
}
   
}
