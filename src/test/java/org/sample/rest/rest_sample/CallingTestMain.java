package org.sample.rest.rest_sample;

import org.junit.runner.JUnitCore;
import org.junit.runner.Request;

public class CallingTestMain {
    public static void main(String[] args) {
        JUnitCore junit = new JUnitCore();

        // PDF:
        Request runTest = Request.method(EmployeeTest.class, "testEmployee");

        junit.run(runTest);
        System.exit(0);
    }
}
