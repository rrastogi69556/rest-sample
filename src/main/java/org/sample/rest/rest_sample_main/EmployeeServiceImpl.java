package org.sample.rest.rest_sample_main;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl {

	private List<Employee> employees;

	public EmployeeServiceImpl() {
		this.employees = new ArrayList<Employee>();
	}
	
	public EmployeeServiceImpl(List<Employee> employees) {
		this.employees = employees;
	}
	
	public List<Employee> getEmployees() {
		if(this.employees != null && this.employees.size() > 0L) {
			return employees;
		}else {
			return new ArrayList<Employee>();
		}
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public List<Employee> addEmployee(Employee e) {
		this.employees.add(e);
		return getEmployees();
	}
	
	public List<Employee> deleteEmployee(Employee e) {
		this.employees.remove(e);
		return getEmployees();
	}
	
	public List<Employee> deleteEmployee(int id) {
		for(Employee e : this.employees) {
			if(e.getId() == id) {
				this.employees.remove(e);
			}
		}
		return getEmployees();
	}
	
	public Employee updateId(Employee e, int id) {
		for(Employee emp : getEmployees()) {
			if(e.getId() == emp.getId() && e.getName().equals(emp.getName()) && e.getPh().equals(emp.getPh())) {
				emp.setId(id);
				return emp;
			}
		}
		return new Employee();
	}
	
	public Employee updateName(Employee e, String name) {
		for(Employee emp : getEmployees()) {
			if(e.getId() == emp.getId() && e.getName().equals(emp.getName()) && e.getPh().equals(emp.getPh())) {
				emp.setName(name);
				return emp;
			}
		}
		return new Employee();
	}
	public Employee updatePh(Employee e, String ph) {
		for(Employee emp : getEmployees()) {
			if(e.getId() == emp.getId() && e.getName().equals(emp.getName()) && e.getPh().equals(emp.getPh())) {
				emp.setName(ph);
				return emp;
			}
		}
		return new Employee();
	}
	public Employee updateEmployee(Employee e) {
		for(Employee emp : getEmployees()) {
			if(e.getId() == emp.getId() && e.getName().equals(emp.getName()) && e.getPh().equals(emp.getPh())) {
				emp.setName(e.getName());
				emp.setId(e.getId());
				emp.setPh(e.getPh());
				return emp;
			}
		}
		return new Employee();
	}
	public Employee getEmployee(int id){
		for(Employee e : this.employees) {
			if(e.getId() == (id)) {
				return e;
			}
		}
		return null;
	}
}
