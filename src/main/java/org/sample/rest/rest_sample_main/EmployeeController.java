package org.sample.rest.rest_sample_main;

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
