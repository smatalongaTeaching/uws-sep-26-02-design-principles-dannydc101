package com.uws.excercise1;


public class MainClass {// refactored main class to account for the new classes
    
    public static void main(String[] args) {
        EmployeeRepository repository = new EmployeeRepository();
// initialise the employee repository
        Employee emp = repository.findById(1);

        //print selected employee details
        if (emp != null) {
            System.out.println("Loaded Employee:");
            System.out.println("ID: "       + emp.getId());
            System.out.println("Name: "     + emp.getName());
            System.out.println("Position: " + emp.getPosition());
            System.out.println("Salary: "   + emp.getSalary());


            // use employee payrolll class for salary calculations
            EmployeePayroll payroll = new EmployeePayroll(emp);
            payroll.printPayrollSummary();
        } else {
            System.out.println("Employee with ID 1 does not exist.");
        }


        // attempt loading non vailid employee
        Employee nonExistent = repository.findById(999);
        if (nonExistent == null) {
            System.out.println("Employee with ID 999 does not exist.");
        }
    }

        }