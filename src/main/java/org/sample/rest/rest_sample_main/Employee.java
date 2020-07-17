package org.sample.rest.rest_sample_main;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
	
	private int id;
	private String name;
	private String ph;
	
	public Employee(){}
	
	public Employee(int id,String name,String ph){
		this.id=id;
		this.name=name;
		this.ph=ph;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
	}
	@Override
	public String toString() {
		return new String("Employee [ " + id + ", name: " + name + ", ph: "+ph );
	}
	
}
