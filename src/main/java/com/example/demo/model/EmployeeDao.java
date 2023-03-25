package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class EmployeeDao {
	
	HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	//create
	public void save(Employee e) {
		template.save(e);
	}
	
	//update
	public void update(Employee e) {
		template.update(e);
	}
	
	//delete
	public void delete(Employee e) {
		template.delete(e);
	}
	
	//readbyID
	public Employee getById(int id) {
		Employee e = template.get(Employee.class, id);
		return e;
	}
	
	//readAll
	public List<Employee> getallEmp() {
		List<Employee> list = new ArrayList<Employee>();
		list=template.loadAll(Employee.class);
		return list;
	}
}
