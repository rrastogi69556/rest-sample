package org.sample.rest.rest_sample;

import org.junit.Assert;
import org.junit.Test;

public class EmployeeTest {

    @Test
    public void testEmployee(){
        Employee emp = new Employee(1,"John","96372837");
        Assert.assertEquals("John", emp.getName());
    }

}