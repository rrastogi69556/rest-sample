package org.sample.rest.rest_sample;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.sample.rest.rest_sample.Employee;
import org.sample.rest.rest_sample.EmployeeServiceImpl;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("employees")
public class MyResource {
	
	private EmployeeServiceImpl ob = new EmployeeServiceImpl();
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    public List<Employee> getIt() {
    	
    	this.ob.addEmployee(new Employee(1,"Bob","1234567890"));
    	this.ob.addEmployee(new Employee(2,"Sam","9087654321"));
    	return ob.getEmployees().size() > 0 ? ob.getEmployees() : Arrays.asList(new Employee(0,"",""));
    }
   
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> createEmployee(Employee emp) {
    	try{
    		Employee e = new Employee();
    	/*	if(emp instanceof String){
    			List<String> employee = Arrays.asList(((String)emp).split(","));
    			e = new Employee(Integer.parseInt(employee.get(0)), employee.get(1), employee.get(2));
    		}else*/ if(emp instanceof Employee) {
    			e = ((Employee)emp);
    		}
    		
    		List<Employee> employees = this.ob.addEmployee(e);
    		return employees;
    		
    		
    	}catch(Exception ex){
    		return Arrays.asList(new Employee());
    	}
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{employeeId}")
    public Employee updateEmployee(@PathParam("employeeId") int id,Employee e){
    	e.setId(id);
    	return this.ob.updateEmployee(e);
    	
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{employeeId}")
    public List<Employee> deleteEmployee(@PathParam("employeeId") int id){
    	return this.ob.deleteEmployee(id);
    }
    
    @GET
    @Path("/{employeeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployee(@PathParam("employeeId") int id){
    	Employee e = this.ob.getEmployee(id);
    	if(e != null ) return e;
    	else return new Employee();
    }
}
