package org.sample.rest.rest_sample;

public class EmployeeController {
	
	private EmployeeServiceImpl esi;
	
	public EmployeeController(EmployeeServiceImpl esi) {
		this.esi=esi;
	}
	
	
	public EmployeeServiceImpl getEsi() {
		return esi;
	}

	public void setEsi(EmployeeServiceImpl esi) {
		this.esi = esi;
	}
	
	
}
